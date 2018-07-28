/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
import lk.ijse.gymmanagementsystem.business.custom.ScheduleBO;
import lk.ijse.gymmanagementsystem.business.custom.WorkoutBO;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.ScheduleDTO;
import lk.ijse.gymmanagementsystem.model.ScheduleDetailDTO;
import lk.ijse.gymmanagementsystem.model.WorkoutDTO;
import lk.ijse.gymmanagementsystem.model.WorkoutTableDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AddWorkoukScheduleController implements Initializable {

    private ScheduleBO scheduleBO;
    private WorkoutBO workoutBO;
    private MemberBO memberBO;
    @FXML
    private TableColumn<String, String> tblclID;
    @FXML
    private TableColumn<String, String> tbleclName;
    @FXML
    private TableColumn<String, String> tbleclSets;
    @FXML
    private TableColumn<String, String> tblclReps;
    @FXML
    private TableColumn<String, String> tblclRest;

    public AddWorkoukScheduleController() {
        scheduleBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.SCHEDULE);
        workoutBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.WORKOUT);
        memberBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);
    }
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField txtScheduleID;
    @FXML
    private JFXComboBox<String> cmbWorkotName;
    @FXML
    private JFXTextField txtSets;
    @FXML
    private JFXTextField txtReps;
    @FXML
    private JFXTextField txtRestTime;
    @FXML
    private Button btnAddTexts;
    @FXML
    private Button btnClearTexts;
    @FXML
    private TableView<WorkoutTableDTO> tblSchedule;
    @FXML
    private Button btnClearTbl;
    @FXML
    private JFXTextField txtMemberName;
    private String scheduleDetailID;
    
    
    

    @FXML
    void cancelOnAction(ActionEvent event) {
        /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirm Close");
        alert.setContentText("Are you want to Close?");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if(showAndWait.get()==ButtonType.OK){*/
            Stage stage  = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
        //}else{}
    }

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {
        try {
            String memberID = null;
            String date =LocalDate.now().toString();
            
            try {
                memberID = memberBO.searchMemberIDUsingFullName(txtMemberName.getText());
            } catch (Exception ex) {
                Logger.getLogger(AddWorkoukScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String scheduleID=txtScheduleID.getText();
            String dob= LocalDate.now().toString();
            
            ArrayList<ScheduleDetailDTO> scheduleDetailDTOs= new ArrayList<>();
            
            for (int i = 0; i < tblSchedule.getItems().size(); i++) {
                String id= (String) tblSchedule.getColumns().get(0).getCellObservableValue(i).getValue();
                String name=(String) tblSchedule.getColumns().get(1).getCellObservableValue(i).getValue();
                String sets= (String) tblSchedule.getColumns().get(2).getCellObservableValue(i).getValue();
                String reps=(String) tblSchedule.getColumns().get(3).getCellObservableValue(i).getValue();
                String rest= (String) tblSchedule.getColumns().get(4).getCellObservableValue(i).getValue();
                ScheduleDetailDTO scheduleDetailDTO= new ScheduleDetailDTO(scheduleID, id, sets, reps, rest);
                scheduleDetailDTOs.add(scheduleDetailDTO);
            }
            ScheduleDTO scheduleDTO = new ScheduleDTO(scheduleID, memberID, "T0001", date, scheduleDetailDTOs);
            boolean addSchedule = scheduleBO.addSchedule(scheduleDTO);
            if (addSchedule) {
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                //a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("New Schedule Added Successfully...");
                a.show();
                //clear();
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddWorkoukScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tblSchedule.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
       tblSchedule.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
       tblSchedule.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sets"));
       tblSchedule.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("reps"));
       tblSchedule.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("rest"));
       
        setScheduleID();
        //setScheduleDetailID();
        
        Platform.runLater(()->txtMemberName.requestFocus());
        try {
            TextFields.bindAutoCompletion(txtMemberName,memberBO.getMemberNames() );
        } catch (Exception ex) {
            Logger.getLogger(AddWorkoukScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cmbWorkotName.setItems(FXCollections.observableArrayList(workoutBO.getAllWorkoutsNames()));
        } catch (Exception ex) {
            Logger.getLogger(AddWorkoukScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
private void setScheduleID(){
       try {
           String newScheduleID = IDGenarator.getNewID("Schedule","schedule_id","S");
           txtScheduleID.setText(newScheduleID);
       } catch (SQLException | ClassNotFoundException | IOException ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
//private void setScheduleDetailID(){
//       try {
//           scheduleDetailID = IDGenarator.getNewID("ScheduleDetail","schedule_detail_id","V");
//           
//       } catch (SQLException | ClassNotFoundException | IOException ex) {
//           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       
//    }

    @FXML
    private void btnAddTextsOnAction(ActionEvent event) {
        WorkoutTableDTO dTO = new WorkoutTableDTO();
        String workoutID=null;
        String workoutName= cmbWorkotName.getSelectionModel().getSelectedItem();
        try {
            workoutID  = workoutBO.searchWorkoutUsingName(workoutName);
        } catch (Exception ex) {
            Logger.getLogger(AddWorkoukScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dTO.setId(workoutID);
        dTO.setName(workoutName);
        dTO.setSets(txtSets.getText());
        dTO.setReps(txtReps.getText());
        dTO.setRest(txtRestTime.getText());
        tblSchedule.getItems().add(dTO);
        clearfield();
        
  
    }
    /* ObservableList<WorkoutTableDTO> getList(){
    ObservableList<WorkoutTableDTO> dTOs = FXCollections.observableArrayList();
    String workoutID=null;
    String workoutName= cmbWorkotName.getSelectionModel().getSelectedItem();
    try {
    workoutID  = workoutBO.searchWorkoutUsingName(workoutName);
    } catch (Exception ex) {
    Logger.getLogger(AddWorkoukScheduleController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    dTOs.add(new WorkoutTableDTO(workoutID, workoutName, txtSets.getText(),txtReps.getText(),txtRestTime.getText()));
    return dTOs;
    }*/
    @FXML
    private void btnClearTextsOnAction(ActionEvent event) {
        clearfield();
    }

    @FXML
    private void btnClearTblOnAction(ActionEvent event) {
       
    }
    void clearfield(){
        cmbWorkotName.setValue(null);
        txtReps.clear();
        txtRestTime.clear();
        txtSets.clear();
    }

    @FXML
    private void txtSetsOnAction(ActionEvent event) {
        String name = txtSets.getText();
        if (!name.matches("[0-9 .]+")) {
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                a.setContentText("Invalid Input");
                a.show();
            txtSets.selectAll();
            txtSets.requestFocus();
        }else{
            txtReps.requestFocus();
        }
    }

    @FXML
    private void txtRepsOnAction(ActionEvent event) {
        String name = txtReps.getText();
        if (!name.matches("[0-9 .]+")) {
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                a.setContentText("Invalid Input");
                a.show();
            txtReps.selectAll();
            txtReps.requestFocus();
        }else{
            txtRestTime.requestFocus();
        }
    }

    @FXML
    private void txtRestTimeOnAction(ActionEvent event) {
        String name = txtRestTime.getText();
        if (!name.matches("[0-9 .]+")) {
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                a.setContentText("Invalid Input");
                a.show();
            txtRestTime.selectAll();
            txtRestTime.requestFocus();
        }else{
           // txtRestTime.requestFocus();
        }
    }
}
