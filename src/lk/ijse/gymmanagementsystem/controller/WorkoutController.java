/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gymmanagementsystem.common.FxmlLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class WorkoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton addWorkoutBtn;

    @FXML
    private JFXButton updateWorkoutBtn;

    @FXML
    private ScrollPane workoutMainScrollPane;

    @FXML
    private JFXButton updateWorkoutScheduleBtn;

    @FXML
    private JFXButton addWorkoutScheduleBtn;

    @FXML
    void addWorkoutBtnOnAction(ActionEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddWorkout.fxml");
    }

    @FXML
    void addWorkoutScheduleBtnOnAction(ActionEvent event) throws IOException {
       FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddWorkoukSchedule.fxml");
    }

    @FXML
    void updateWorkoutBtnOnAction(ActionEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/UpdateWorkout.fxml");
    }

    @FXML
    void updateWorkoutScheduleBtnOnAction(ActionEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/UpdateWorkoutSchedule.fxml");

       /*
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/UpdateWorkoutSchedule.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
        */

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
