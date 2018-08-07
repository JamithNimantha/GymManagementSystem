/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.AttendanceBO;
import lk.ijse.gymmanagementsystem.common.FxmlLoader;
import lk.ijse.gymmanagementsystem.model.CustomDTO;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AttendancePaneController implements Initializable {
    
    private AttendanceBO attendanceBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCE);


    @FXML
    private JFXButton markAttendanceBtn;
    @FXML
    private TableView<CustomDTO> tblAttendance;
    @FXML
    private JFXButton btnReload;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblAttendance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("first_name"));
        tblAttendance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("membership_id"));
        tblAttendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("attendance_id"));
        tblAttendance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("attendance_date"));
        tblAttendance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("in_time"));
        
        
        try {
            getAllAttendance();
            
        } catch (Exception ex) {
            Logger.getLogger(AttendancePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    void getAllAttendance() throws Exception{
        tblAttendance.setItems(FXCollections.observableArrayList(attendanceBO.getAllAttendanceToTable()));
    }

    @FXML
    private void markAttenceBtnOnAction(ActionEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/Attendance.fxml");

    }

    @FXML
    private void btnReladOnAction(ActionEvent event) throws Exception {
        getAllAttendance();
    }
    
}
