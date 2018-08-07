/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.custom.TrainerBO;
import lk.ijse.gymmanagementsystem.business.custom.impl.TrainerBOImpl;
import lk.ijse.gymmanagementsystem.common.Alerts;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.TrainerDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AddTrainerController implements Initializable {

    private static TrainerBO trainerBO = new TrainerBOImpl();
    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField trainerIDTxt;
    @FXML
    private JFXRadioButton maleRadioBtn;
    @FXML
    private JFXRadioButton femaleRadioBtn;
    @FXML
    private Label genderLbl;
    @FXML
    private JFXDatePicker dateOfBirthDatePicker;
    @FXML
    private JFXTextField addressTxt;
    @FXML
    private JFXTextField mobileNumberTxt;
    @FXML
    private JFXTextField emailTxt;
    @FXML
    private JFXTextField descriptionTxt;
    @FXML
    private JFXTextField joiningDateTxt;

    @FXML
    private JFXTextField txtFullName;
    

    @FXML
    void cancelBtnOnAction(ActionEvent event){
       // Alerts.confirmClose(cancelBtn);
        /*
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        //alert.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/imogi_sad.gif").toString()));
        alert.setTitle("Confirm Close");
        alert.setContentText("Are you want to Close?");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if(showAndWait.get()==ButtonType.OK){
            Stage stage  = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
        }else{}
        */
        Stage stage  = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
       
    }
    
    private void clear(){
        trainerIDTxt.clear();
        txtFullName.clear();
        maleRadioBtn.setSelected(true);
        femaleRadioBtn.setSelected(false);
        dateOfBirthDatePicker.setValue(null);
        mobileNumberTxt.clear();
        addressTxt.clear();
        emailTxt.clear();
        descriptionTxt.clear();
        setTrainerID();
        joiningDateTxt.setText(LocalDate.now().toString());
        Platform.runLater(()->txtFullName.requestFocus());
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        try {
            String gender = null;
            if(maleRadioBtn.isSelected()){
                gender="Male";
            }else if(femaleRadioBtn.isSelected()){
                gender="Female";
            }
            String dob = dateOfBirthDatePicker.getValue().toString();
            
            TrainerDTO trainerDTO = new TrainerDTO(trainerIDTxt.getText(),txtFullName.getText(), dob, gender, mobileNumberTxt.getText(), addressTxt.getText(), emailTxt.getText(), joiningDateTxt.getText(), descriptionTxt.getText());
            boolean addTrainer = trainerBO.addTrainer(trainerDTO);
            if(addTrainer){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
               // a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("Congrats! New Trainer Added Successfully...");
                a.show();
                clear();

            }
        } catch (Exception ex) {
            Logger.getLogger(AddTrainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup toggleGroup = new ToggleGroup();
        maleRadioBtn.setToggleGroup(toggleGroup);
        maleRadioBtn.setSelected(true);
        femaleRadioBtn.setToggleGroup(toggleGroup);
        setTrainerID();
        joiningDateTxt.setText(LocalDate.now().toString());
        Platform.runLater(()->txtFullName.requestFocus());
    }    
    
    private void setTrainerID(){
        try {
            String newTrainerId = IDGenarator.getNewID("Trainer","trainer_id","T");
            trainerIDTxt.setText(newTrainerId);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(AddTrainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
