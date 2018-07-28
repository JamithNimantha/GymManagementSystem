/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
import lk.ijse.gymmanagementsystem.business.custom.PackageBO;
import lk.ijse.gymmanagementsystem.business.custom.TrainerBO;
import lk.ijse.gymmanagementsystem.common.Alerts;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.MemberDTO;
import lk.ijse.gymmanagementsystem.model.MembershipDTO;
import lk.ijse.gymmanagementsystem.model.RegistrationDTO;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AddMemberController implements Initializable {
    
    private MemberBO memberBO=memberBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);
    
    private PackageBO packageBO=packageBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.PACKAGE);
    
    private TrainerBO trainerBO= trainerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.TRAINER);

    
   @FXML
    private AnchorPane addMemberPane;

    
    @FXML
    private JFXTextField memberIdTxt;

    @FXML
    private JFXRadioButton maleRadioBtn;

    @FXML
    private JFXRadioButton femaleRadioBtn;

    @FXML
    private JFXDatePicker dateOfBirthTxt;

    @FXML
    private JFXTextField addreesTxt;

    @FXML
    private JFXTextField mobileNumberTxt;

    @FXML
    private JFXTextField emailTxt;

    @FXML
    private JFXTextField joiningDateDatePicker;

    @FXML
    private JFXComboBox<String> packageCmbBox;

    @FXML
    private JFXComboBox<String> trainerCmbBox;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXDatePicker firstPaymentDatePicker;
    
    @FXML
    private JFXTextField registrationID;
    @FXML
    private JFXTextField txtFullName;
    
   
        

    @FXML
    void cancelOnAction(ActionEvent event) {
        Stage stage  = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
    }
    
    private void clear(){
        memberIdTxt.clear();
        registrationID.clear();
        txtFullName.clear();
        maleRadioBtn.setSelected(true);
        femaleRadioBtn.setSelected(false);
        dateOfBirthTxt.setValue(null);
        mobileNumberTxt.clear();
        addreesTxt.clear();
        emailTxt.clear();
        joiningDateDatePicker.clear();
        packageCmbBox.setValue(null);
        firstPaymentDatePicker.setValue(null);
        trainerCmbBox.setValue(null);
        joiningDateDatePicker.setText(LocalDate.now().toString());
        firstPaymentDatePicker.setValue(LocalDate.now());
        firstPaymentDatePicker.setVisible(false);
        Platform.runLater(()->txtFullName.requestFocus());
        setMemberID();
        setRegID();
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String gender=null;
        if(maleRadioBtn.isSelected()){
            gender="Male";
        }else if(femaleRadioBtn.isSelected()){
            gender="Female";
        }
        String packageName = packageCmbBox.getSelectionModel().getSelectedItem();
        String packageId=null;
        String trainerName =trainerCmbBox.getSelectionModel().getSelectedItem();
        String trainerID=null;
        try {
            trainerID  = trainerBO.searchTrainersUsingName(trainerName);
        } catch (Exception ex) {
            Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
       try {
           packageId = packageBO.searchPackageUsingName(packageName);
           
       } catch (Exception ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        String dob = dateOfBirthTxt.getValue().toString();
        String firtPaymentDate = firstPaymentDatePicker.getValue().toString();
        RegistrationDTO registrationDTO=new RegistrationDTO(registrationID.getText(),joiningDateDatePicker.getText(), memberIdTxt.getText());
        MembershipDTO membershipDTO = new MembershipDTO(memberIdTxt.getText(),firtPaymentDate,registrationID.getText(), packageId,trainerID);
        MemberDTO memberDTO=new MemberDTO(memberIdTxt.getText(), txtFullName.getText(), addreesTxt.getText(), gender, mobileNumberTxt.getText(), dob, emailTxt.getText(),registrationDTO,membershipDTO);
        try {
            boolean addMember = memberBO.addMember(memberDTO);
            if(addMember){
                
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                //a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("Congrats! New Member Added Successfully...");
                a.show();
                clear();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void setMemberID(){
       try {
           String newMemberID = IDGenarator.getNewID("Member","member_id","M");
           memberIdTxt.setText(newMemberID);
       } catch (SQLException | ClassNotFoundException | IOException ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    private void setRegID(){
       try {
           String newRegID = IDGenarator.getNewID("Registration","registration_id","R");
           registrationID.setText(newRegID);
       } catch (SQLException | ClassNotFoundException | IOException ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ToggleGroup pickGender = new ToggleGroup();
       maleRadioBtn.setToggleGroup(pickGender);
       maleRadioBtn.setSelected(true);
       femaleRadioBtn.setToggleGroup(pickGender);
       setMemberID();
       setRegID();
        try {
            trainerCmbBox.setItems(FXCollections.observableArrayList(trainerBO.getAllTrainersNames()));
        } catch (Exception ex) {
            Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
       try {
           packageCmbBox.setItems(FXCollections.observableArrayList(packageBO.getAllPackageNames()));
           
       } catch (Exception ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       joiningDateDatePicker.setText(LocalDate.now().toString());
       firstPaymentDatePicker.setValue(LocalDate.now());
       firstPaymentDatePicker.setVisible(false);
       Platform.runLater(()->txtFullName.requestFocus());
      
    }

    
    
    @FXML
    private void dateOfBirthOnAction(ActionEvent event) {
    //mobileNumberTxt.requestFocus();
    }
    
    @FXML
    private void addressOnAction(ActionEvent event) {
        emailTxt.requestFocus();
    }
    
    @FXML
    private void mobileNumberOnAction(ActionEvent event) {
         String name = mobileNumberTxt.getText();
        if (!name.matches("[0-9]{10}")) {
            Alerts.invalidInput();
            mobileNumberTxt.selectAll();
            mobileNumberTxt.requestFocus();
        }else{
            addreesTxt.requestFocus();
        }
    
    }
    
    @FXML
    private void emailOnAction(ActionEvent event) {
        String email = emailTxt.getText();
        if(!email.matches("\\S+@\\S+\\.\\S+")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid",ButtonType.OK);
                alert.setHeaderText(null);
                alert.setContentText("Invalid Input");
                alert.show();
                emailTxt.selectAll();
                emailTxt.requestFocus();
        }else{
            packageCmbBox.requestFocus();
        }
    }
    
    @FXML
    private void packageCmbBoxOnAction(ActionEvent event) {
    //trainerCmbBox.requestFocus();
    }
    
    @FXML
    private void trainerCmbBoxOnAction(ActionEvent event) {
    //saveBtn.requestFocus();
    }

    @FXML
    private void txtFullNameOnAction(ActionEvent event) {
        String name = txtFullName.getText();
        if(!name.matches("[A-z .]+")){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Invalid",ButtonType.OK);
            alert.setContentText("InValid");
            alert.setHeaderText(null);
            alert.show();
            txtFullName.selectAll();
            txtFullName.requestFocus();

        }else dateOfBirthTxt.requestFocus();
    }

}
