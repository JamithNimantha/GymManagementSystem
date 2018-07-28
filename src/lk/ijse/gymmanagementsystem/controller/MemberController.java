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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
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
public class MemberController implements Initializable {

            private MemberBO memberBO =BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);

    
     @FXML
    private JFXButton addMemberBtn;

    @FXML
    private JFXButton updateMemberBtn;

    @FXML
    private ScrollPane memberScrollPane;
    
    
    
    
    @FXML
    private TableView<CustomDTO> tblMember;
    @FXML
    private JFXButton btnRefresh;
    @FXML
    private JFXButton btnReport;


    @FXML
    void addMemberOnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/AddMember.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    void updateMemberOnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/UpdateMember.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();

    }
    @FXML
    void viewMemberOnClicked(MouseEvent event) {
         memberScrollPane.setContent(tblMember);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblMember.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("member_id"));
        tblMember.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("full_name"));
        tblMember.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        tblMember.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblMember.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("mobile_number"));
        tblMember.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMember.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblMember.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("joining_date"));
        tblMember.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("package_name"));
        tblMember.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("t_full_name"));
                try {
                    loadMemberDetails();
                } catch (Exception ex) {
                    Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }    
    void loadMemberDetails() throws Exception{
        tblMember.setItems(FXCollections.observableArrayList(memberBO.getAllMemnerDetails()));
        
        
        
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
                try {
                    loadMemberDetails();
                } catch (Exception ex) {
                    Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void btnReportOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gymmanagementsystem/reports/Member.jasper");
            HashMap map = new HashMap();
            
            
            JasperPrint Jasperprint = JasperFillManager.fillReport(resourceAsStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(Jasperprint,false);
        } catch (IOException | JRException ex) {
            Logger.getLogger(PaymentPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
