/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.AttendanceBO;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
import lk.ijse.gymmanagementsystem.business.custom.impl.AttendanceBOImpl;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.AttendanceDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AttendanceController implements Initializable {
    
        private MemberBO memberBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);

     @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField AttendanceIDTxt;
    @FXML
    private JFXDatePicker dateDatePicker;
    @FXML
    private JFXTimePicker inTimeTimePicker;
    @FXML
    private JFXTextField MemberIDTxt;
    
    private static AttendanceBO attendanceBO = new AttendanceBOImpl();
    @FXML
    private JFXTextField txtMemberName;

    @FXML
    void cancelOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/imogi_sad.gif").toString()));
        alert.setTitle("Confirm Close");
        alert.setContentText("Are you want to Close?");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if(showAndWait.get()==ButtonType.OK){
            Stage stage  = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
        }else{}
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
    }

    @FXML
    void saveOnAction(ActionEvent event) {
         try {
             String date = dateDatePicker.getValue().toString();
             String inTime = inTimeTimePicker.getValue().toString();
             String attendanceID = AttendanceIDTxt.getText();
             String memberID = null;
             memberID = memberBO.searchMemberIDUsingFullName(txtMemberName.getText());
             MemberIDTxt.setText(memberID);
             
             AttendanceDTO attendanceDTO = new AttendanceDTO(attendanceID, date, inTime, memberID);
             boolean addAttendance = attendanceBO.addAttendance(attendanceDTO);
             if(addAttendance){
                 Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                 a.setHeaderText(null);
                 //a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                 a.setContentText("Congrats! Attendance Marked Successfully...");
                 a.show();
                 clear();
                 
             }
         } catch (Exception ex) {
             Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateDatePicker.setValue(LocalDate.now());
        inTimeTimePicker.setValue(LocalTime.now());
        Platform.runLater(()->txtMemberName.requestFocus());
        setAttendanceID();
            try {
                TextFields.bindAutoCompletion(txtMemberName,memberBO.getMemberNames() );
            } catch (Exception ex) {
                Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
    private void clear(){
        MemberIDTxt.clear();
        dateDatePicker.setValue(LocalDate.now());
        inTimeTimePicker.setValue(LocalTime.now());
        setAttendanceID();
        
    }
    private void setAttendanceID(){
       try {
           String newAttendanceID = IDGenarator.getNewID("Attendance","attendance_id","A");
           AttendanceIDTxt.setText(newAttendanceID);
       } catch (SQLException | ClassNotFoundException | IOException ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
