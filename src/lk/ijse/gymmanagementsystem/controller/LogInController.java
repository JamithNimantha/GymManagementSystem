/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.gymmanagementsystem.db.DBConnection;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class LogInController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     */
    
    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void cancelBtnOnAction(ActionEvent event) {
        /*
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gymmanagementsystem/reports/SQL_REport.jasper");
        HashMap map = new HashMap();
        JasperPrint Jasperprint = JasperFillManager.fillReport(resourceAsStream, map,DBCo);
        JasperViewer.viewReport(Jasperprint,false);
        */
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirm Close");
        alert.setContentText("Are you want to Close?");
        Optional<ButtonType> showAndWait = alert.showAndWait();
            if(showAndWait.get()==ButtonType.OK){
                Stage stage  = (Stage) cancelBtn.getScene().getWindow();
                stage.close();
               }
        
    }   

    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
        
                /*
                String userName =txtUserName.getText();
                String pass =txtPassword.getText();

                Connection connection = DBConnection.getInstance().getConnection();
                Statement createStatement = connection.createStatement();
                ResultSet rst=createStatement.executeQuery("select * from User where user_name='"+userName+"' && password='"+pass+"'");



                try {
                if(rst.next()){
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/DashBoard.fxml"));
                Scene scene =  new Scene(parent);
                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.setScene(scene);
                //   stage.show();
                }
                else{
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
                a.setContentText("Invalid UserName or Password...");
                a.show();
                }
                } catch (SQLException ex) {
                Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/DashBoard.fxml"));
        Scene scene =  new Scene(parent);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirm Close");
                alert.setContentText("Are you want to Close");
                Optional<ButtonType> showAndWaint = alert.showAndWait();
                if (showAndWaint.get()==ButtonType.OK){
                    System.exit(0);
                }

            }
        });

        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->txtUserName.requestFocus());
    }    

    @FXML
    private void txtUserNameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }
    
}
