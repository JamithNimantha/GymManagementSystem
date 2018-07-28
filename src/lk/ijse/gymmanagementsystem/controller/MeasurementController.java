/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import lk.ijse.gymmanagementsystem.business.custom.MeasurementBO;
import lk.ijse.gymmanagementsystem.model.CustomDTO;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class MeasurementController implements Initializable {

    private MeasurementBO measurementBO=measurementBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.MEASUREMENT);

    
    @FXML
    private ScrollPane measurementScrollPane;


    @FXML
    private JFXButton addMeasurementBtn;


    @FXML
    private TableView<CustomDTO> tblMeasurement;
    @FXML
    private JFXButton btnReload;
    
    void loadMeasurements() throws Exception{
            tblMeasurement.setItems(FXCollections.observableArrayList(measurementBO.getAllMeasurements()));
        
    }

    @FXML
    void addMeasurementOnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/AddMeasurement.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    void measurementOnClicked(MouseEvent event) {
        measurementScrollPane.setContent(tblMeasurement);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         tblMeasurement.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("full_name"));
         tblMeasurement.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("membership_id"));
         tblMeasurement.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("measurement_id"));
         tblMeasurement.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("height"));
         tblMeasurement.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("weight"));
         tblMeasurement.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("bmi"));
         tblMeasurement.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("bmi_status"));
         tblMeasurement.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("chest"));
         tblMeasurement.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("waist"));
         tblMeasurement.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("thigs"));
         tblMeasurement.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("arms"));
         tblMeasurement.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("result_date"));
        
        try {
            loadMeasurements();
        } catch (Exception ex) {
            Logger.getLogger(MeasurementController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
         
        
    }    

    @FXML
    private void btnReloadOnAction(ActionEvent event) throws Exception {
        loadMeasurements();
    }
    
}
