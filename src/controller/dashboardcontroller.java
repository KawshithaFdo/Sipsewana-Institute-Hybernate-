package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class dashboardcontroller {
    public AnchorPane dashboardContext;

    public void btnstudentsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btncoursesOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CoursesForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btnStudentdetailsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/student_reg_Course.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
