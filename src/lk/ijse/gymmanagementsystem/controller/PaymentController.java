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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
import lk.ijse.gymmanagementsystem.business.custom.PaymentBO;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.PaymentDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class PaymentController implements Initializable {

    private MemberBO memberBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);
    
    private PaymentBO paymentBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
    
    //private static PaymentBO paymentBO = new PaymentBOImpl();
    
    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton clearBtn;

    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField memberIDTxt;
    @FXML
    private JFXTextField paymentIDTxt;
    
    @FXML
    private JFXDatePicker paymentDateDatePicker;
    @FXML
    private JFXTextField payementDescriptionTxt;
    @FXML
    private JFXTimePicker paymentTimeTimePicker;
    
    @FXML
    private JFXTextField paymentAmountTxt;
    @FXML
    private JFXTextField memberNameSearch;

    @FXML
    void cancelOnAction(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation Close");
//        alert.setHeaderText(null);
//        alert.setContentText("Are you sure you want to Cancel?");
//        Optional<ButtonType> showAndWait = alert.showAndWait();
//        if(showAndWait.get()==ButtonType.OK){
            Stage stage  = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
        //}else{}
        

    }

    @FXML
    void clearOnAction(ActionEvent event) {
        clean();
        
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        try {
            String payementID = paymentIDTxt.getText();
            String paymentDate = paymentDateDatePicker.getValue().toString();
            String paymentTime = paymentTimeTimePicker.getValue().toString();
            String paymentDescription = payementDescriptionTxt.getText();
            double paymentAmount = Double.parseDouble(paymentAmountTxt.getText());
            String memberID = null;
            memberID=memberBO.searchMemberIDUsingFullName(memberNameSearch.getText());
            PaymentDTO paymentDTO = new PaymentDTO(payementID, paymentDate, paymentTime, paymentDescription, paymentAmount, memberID);
            boolean addPayment = paymentBO.addPayment(paymentDTO);
            if(addPayment){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                //a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("Congrats! New Payment Made Successfully...");
                a.show();
                clean();
            }
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paymentDateDatePicker.setValue(LocalDate.now());
        paymentTimeTimePicker.setValue(LocalTime.now());
        Platform.runLater(()->memberNameSearch.requestFocus());
        setPayementID();
        try {
            TextFields.bindAutoCompletion(memberNameSearch,memberBO.getMemberNames() );
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void clean(){
    memberIDTxt.clear();
    payementDescriptionTxt.clear();
    paymentAmountTxt.clear();
    paymentDateDatePicker.setValue(LocalDate.now());
    paymentTimeTimePicker.setValue(LocalTime.now());
    setPayementID();
    
    }
    private void setPayementID(){
        try {
            String newID = IDGenarator.getNewID("Payment", "payment_id", "P");
            paymentIDTxt.setText(newID);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void paymentAmountTxtOnAction(ActionEvent event) {
        String name = paymentAmountTxt.getText();
        if (!name.matches("[0-9 .]+")) {
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                a.setContentText("Invalid Input");
                a.show();
            paymentAmountTxt.selectAll();
            paymentAmountTxt.requestFocus();
        }else{
          //  weightTxt.requestFocus();
        }
    }

    @FXML
    private void payementDescriptionTxtOnAction(ActionEvent event) {
        String name = payementDescriptionTxt.getText();
        if (!name.matches("[A-z .]+")) {
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                //a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("Invalid Input");
                a.show();
            payementDescriptionTxt.selectAll();
            payementDescriptionTxt.requestFocus();
        }else{
            paymentAmountTxt.requestFocus();
        }
    }

    @FXML
    private void memberNameSearchOnAction(ActionEvent event) {
        payementDescriptionTxt.requestFocus();
    }
    
}
