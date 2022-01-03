package controller;

import business.Coursebo;
import business.Factory.FactoryBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.courses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.courseTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class CoursesController {
    public AnchorPane CourseContext;
    public JFXTextField txtcourseid;
    public JFXTextField txtName;
    public JFXTextField txtfee;
    public JFXTextField txtDuration;
    public TableView<courseTm> tblCourse;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colduration;
    public TableColumn colfee;
    public JFXButton btnsave;
    public JFXButton btnupdate;
    public JFXButton btndelete;

    private final Coursebo c = (Coursebo) FactoryBo.getFactoryBo().getBO(FactoryBo.BOTypes.COURSE);

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("c_Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
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
        tblCourse.getItems().setAll(loadTableData());

    }

    private ObservableList<courseTm> loadTableData() throws SQLException, ClassNotFoundException, IOException {
        ObservableList<courseTm> tmList = FXCollections.observableArrayList();
        List<courses> all = c.getall();
        for(courses dto : all) {
            courseTm tm = new courseTm(
                    dto.getC_Id(),
                    dto.getName(),
                    dto.getDuration(),
                    dto.getFee()
            );
            tmList.add(tm);
        }
        return tmList;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        courses co = new courses(txtcourseid.getText(), txtName.getText(), txtDuration.getText(), txtfee.getText());
        if (c.add(co)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added").show();
            clear();
            loaddata();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        courses co=new courses(txtcourseid.getText(),txtName.getText(),txtDuration.getText(),txtfee.getText());
        if (c.update(co)){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            clear();
            loaddata();
        }else{
            new Alert(Alert.AlertType.ERROR,"Try Again").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String c_id = tblCourse.getSelectionModel().getSelectedItem().getC_Id();

         if (c.delete(c_id)){
             new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
             c_id=null;
             clear();
             loaddata();
         }else{
             new Alert(Alert.AlertType.ERROR,"Try Again").show();
         }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) CourseContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadcoursedatatoupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (txtcourseid.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Id").show();
        }
        else{
            courses search = c.search(txtcourseid.getText());
            if (search.equals(null)){
                new Alert(Alert.AlertType.WARNING,"WRONG ID").show();
            }
            txtName.setText(search.getName());
            txtDuration.setText(search.getDuration());
            txtfee.setText(search.getFee());

        }
    }

    public void clear(){
        txtcourseid.setText("");
        txtName.setText("");
        txtDuration.setText("");
        txtfee.setText("");
    }
}
