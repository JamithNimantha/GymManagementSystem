/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.WorkoutBO;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.WorkoutDTO;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AddWorkoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField txtWorkout;
    @FXML
    private JFXTextField txtWorkoutName;
    @FXML
    private JFXTextField txtWorkoutDescription;
    @FXML
    private TableView<WorkoutDTO> tbleWorkout;
    private WorkoutBO workoutBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.WORKOUT);

    @FXML
    void cancelBtnOnAction(ActionEvent event) {
        
            Stage stage  = (Stage) cancelBtn.getScene().getWindow();
            stage.close();

    }

    @FXML
    void clearbtnOnAction(ActionEvent event) {
        clear();

    }
    void clear(){
    setWorkoutID();
    txtWorkoutName.clear();
    txtWorkoutDescription.clear();
    txtWorkoutName.requestFocus();
    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {
        String id = txtWorkout.getText();
        String name = txtWorkoutName.getText();
        String description = txtWorkoutDescription.getText();
        
        WorkoutDTO workoutDTO=new WorkoutDTO(id, name, description);
        try {
            boolean addWorkout = workoutBO.addWorkout(workoutDTO);
            if(addWorkout){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("Congrats! New Trainer Added Successfully...");
                a.show();
                clear();
                loadTrainerDetails();
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AddWorkoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setWorkoutID();
        Platform.runLater(()->txtWorkoutName.requestFocus());
        tbleWorkout.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("workout_id"));
        tbleWorkout.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("workout_name"));
        tbleWorkout.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("workout_description"));
        try {
            loadTrainerDetails();
        } catch (Exception ex) {
            Logger.getLogger(AddWorkoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    private void setWorkoutID(){
        try {
            String newWorkoutID = IDGenarator.getNewID("Workout","workout_id","W");
            txtWorkout.setText(newWorkoutID);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(AddTrainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void loadTrainerDetails() throws Exception{
        tbleWorkout.setItems(FXCollections.observableArrayList(workoutBO.getAllWorkouts()));
    }
}
