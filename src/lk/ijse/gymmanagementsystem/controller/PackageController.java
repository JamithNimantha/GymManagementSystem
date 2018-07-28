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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.PackageBO;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.PackageDTO;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class PackageController implements Initializable {

    private PackageBO packageBO;

    public PackageController() {
        packageBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.PACKAGE);
    }
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton removeBtn;
    @FXML
    private JFXTextField packageIDTxt;
    @FXML
    private JFXTextField nameTxt;
    @FXML
    private JFXTextField descriptionTxt;
    @FXML
    private JFXTextField feeTxt;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private TableView<PackageDTO> tblPackage;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPackageID();
        tblPackage.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("packageID"));
        tblPackage.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblPackage.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblPackage.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        try {
            getAllTrainers();
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }    
    
    void getAllTrainers() throws Exception{
        tblPackage.setItems(FXCollections.observableArrayList(packageBO.getAllPackages()));
    }
    
   private void clear(){
       setPackageID();
       nameTxt.clear();
       descriptionTxt.clear();
       feeTxt.clear();
       
   }

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        try {
            PackageDTO packageDTO = new PackageDTO(packageIDTxt.getText(), nameTxt.getText(), descriptionTxt.getText(), Double.parseDouble(feeTxt.getText()));
            boolean addPackage = packageBO.addPackage(packageDTO);
            if(addPackage){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.setHeaderText(null);
               // a.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/emogi_clap.gif").toString()));
                a.setContentText("Congrats! New Package Added Successfully...");
                a.show();
                clear();
                getAllTrainers();
            }
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void removeBtnOnAction(ActionEvent event) {
    }
    
    private void setPackageID(){
        try {
            String newID = IDGenarator.getNewID("Package", "package_id", "P");
            packageIDTxt.setText(newID);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
