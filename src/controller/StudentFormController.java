package controller;

import business.Coursebo;
import business.Factory.FactoryBo;
import business.Studentbo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.courses;
import dto.student;
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
import view.tm.courseTm;
import view.tm.studentTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class StudentFormController {
    public AnchorPane StudentContext;
    public JFXTextField txtstudentid;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtcontact;
    public TableView<studentTm> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colcontact;
    public JFXTextField C_id;
    public JFXButton btnsave;
    public JFXButton btnupdate;
    public JFXButton btndelete;

    private final Studentbo s = (Studentbo) FactoryBo.getFactoryBo().getBO(FactoryBo.BOTypes.STUDENT);
    
    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("st_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        try {
            loaddata();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btndelete.setDisable(false);
        });
    }

    private void loaddata() throws SQLException, ClassNotFoundException, IOException {
        tblStudent.getItems().setAll(loadTableData());
    }

    private ObservableList<studentTm> loadTableData() throws SQLException, ClassNotFoundException, IOException {
        ObservableList<studentTm> tmList = FXCollections.observableArrayList();
        List<student> all = s.getall();
        for(student dto : all) {
            studentTm tm = new studentTm(
                    dto.getSt_id(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getContact()
            );
            tmList.add(tm);
        }
        return tmList;
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        student st=new student(txtstudentid.getText(),txtName.getText(),txtAddress.getText(),txtcontact.getText());
        if (s.update(st)){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            clear();
            loaddata();
        }else{
            new Alert(Alert.AlertType.ERROR,"Try Again").show();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) StudentContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String c_id = tblStudent.getSelectionModel().getSelectedItem().getSt_id();
        if (c_id.equals(null)){
            new Alert(Alert.AlertType.WARNING,"Please select a row").show();
        }else {
            if (s.delete(c_id)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
                btndelete.setDisable(true);
                clear();
                loaddata();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        student st = new student(txtstudentid.getText(), txtName.getText(), txtAddress.getText(), txtcontact.getText());
        if (s.add(st)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added").show();
            clear();
            loaddata();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }

    }

    public void loadstudentupdatedata(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (txtstudentid.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Id").show();
        }
        else{
            student search = s.search(txtstudentid.getText());
            if (search!=null){
                txtName.setText(search.getName());
                txtcontact.setText(search.getContact());
                txtAddress.setText(search.getAddress());
            }
        }
    }

    public void clear(){
        txtstudentid.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtcontact.setText("");
    }

}
