package controller;

import business.Coursebo;
import business.Factory.FactoryBo;
import business.St_Coursebo;
import business.Studentbo;
import com.jfoenix.controls.JFXTextField;
import dao.Dao.CourseDao;
import dao.Dao.Impl.St_CourseDaoImpl;
import dao.Dao.St_CourseDao;
import dao.Dao.StudentDao;
import dto.courses;
import dto.st_courses;
import dto.student;
import entity.Student;
import entity.st_Courses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.st_courseTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class student_reg_courses {
    public AnchorPane DetailContext;
    public JFXTextField txtcourseid;
    public JFXTextField txtName;
    public JFXTextField txtSt_Id;
    public JFXTextField txtC_Name;
    public TableView<st_courseTm> tbldetails;
    public TableColumn colSt_Id;
    public TableColumn colstName;
    public TableColumn colC_Id;
    public TableColumn colfee;
    public JFXTextField txtFee;
    public JFXTextField txt_search_St_Id;

    private final St_Coursebo bo = (St_Coursebo) FactoryBo.getFactoryBo().getBO(FactoryBo.BOTypes.ST_COURSE);
    private final Coursebo c = (Coursebo) FactoryBo.getFactoryBo().getBO(FactoryBo.BOTypes.COURSE);
    private final Studentbo st = (Studentbo) FactoryBo.getFactoryBo().getBO(FactoryBo.BOTypes.STUDENT);


    public void initialize(){
        colSt_Id.setCellValueFactory(new PropertyValueFactory<>("St_Id"));
        colstName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colC_Id.setCellValueFactory(new PropertyValueFactory<>("c_Id"));
        colfee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        try {
            loaddata();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loaddata() throws SQLException, ClassNotFoundException, IOException {
        tbldetails.getItems().setAll(loadTableData());
    }

    private ObservableList<st_courseTm> loadTableData() throws SQLException, ClassNotFoundException, IOException {
        ObservableList<st_courseTm> tmList = FXCollections.observableArrayList();
        List<st_courses> all = bo.getall();
        for(st_courses dto : all) {
            st_courseTm tm = new st_courseTm(
                    dto.getSt_Id().getSt_id(),
                    dto.getName(),
                    dto.getC_Id().getC_Id(),
                    dto.getFee()
            );
            tmList.add(tm);
        }
        return tmList;
    }

    public void openCourseDetails(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        courses search = c.search(txtcourseid.getText());
        if (search.getName().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Wrong Id").show();
        }else{
            txtC_Name.setText(search.getName());
            txtFee.setText(search.getFee());
        }
    }

    public void openStudentDetails(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        student search = st.search(txtSt_Id.getText());
        if (search.getName().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Wrong Id").show();
        }else{
            txtName.setText(search.getName());
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        Student search1 = new StudentDao().search(txtSt_Id.getText());
        entity.courses search = new CourseDao().search(txtcourseid.getText());

        st_courses d1=new st_courses(search1,search1.getName(),
                search,search.getName(),search.getFee());

        if (bo.add(d1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Added").show();
            clear();
            loaddata();
        }else{
            new Alert(Alert.AlertType.ERROR,"Try Again").show();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DetailContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        if (txt_search_St_Id.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Enter valid Id").show();
        }else{
            loadtable();
        }
    }

    public void loadtable() throws SQLException, IOException, ClassNotFoundException {
        List<st_courses> getdata = bo.getdata(txt_search_St_Id.getText());
        ObservableList<st_courseTm> tmList = FXCollections.observableArrayList();
        for(st_courses dto : getdata) {
            st_courseTm tm = new st_courseTm(
                    dto.getSt_Id().getSt_id(),
                    dto.getName(),
                    dto.getC_Id().getC_Id(),
                    dto.getFee()
            );
            tmList.add(tm);
        }
        tbldetails.getItems().setAll(tmList);
    }

    public void clear(){
        txtSt_Id.setText("");
        txtName.setText("");
        txtcourseid.setText("");
        txtC_Name.setText("");
        txtFee.setText("");
    }

}
