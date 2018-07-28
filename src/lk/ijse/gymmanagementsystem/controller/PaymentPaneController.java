/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
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
import lk.ijse.gymmanagementsystem.business.custom.PaymentBO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class PaymentPaneController implements Initializable {

    @FXML
    private JFXButton addPaymentBtn;
    @FXML
    private TableView<CustomDTO> tblePayment;
    @FXML
    private JFXButton btnRefresh;

    private PaymentBO paymentBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
    @FXML
    private JFXButton btnReport;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tblePayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("full_name"));
        tblePayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("payment_id"));
        tblePayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("payment_date"));
        tblePayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("payment_time"));
        tblePayment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("payment_description"));
        tblePayment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("payment_amount"));
        
        
         
        try {
            loadPaymentDetails();
        } catch (Exception ex) {
            Logger.getLogger(PaymentPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    


    @FXML
    private void addPaymentBtnOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Payment.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
        try {
            loadPaymentDetails();
        } catch (Exception ex) {
            Logger.getLogger(PaymentPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadPaymentDetails() throws Exception{
        tblePayment.setItems(FXCollections.observableArrayList(paymentBO.getAllPaymentDetails()));
    }

    @FXML
    private void btnReportOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gymmanagementsystem/reports/payment.jasper");
            HashMap map = new HashMap();
            
            
            JasperPrint Jasperprint = JasperFillManager.fillReport(resourceAsStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(Jasperprint,false);
        } catch (IOException | JRException ex) {
            Logger.getLogger(PaymentPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
