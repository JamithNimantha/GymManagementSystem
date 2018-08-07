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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.TrainerBO;
import lk.ijse.gymmanagementsystem.common.FxmlLoader;
import lk.ijse.gymmanagementsystem.model.TrainerDTO;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class TrainerController implements Initializable {

    private TrainerBO trainerBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.TRAINER);

    
     @FXML
    private ScrollPane tainerScrollPane;

    @FXML
    private TableView<TrainerDTO> trainerTbl;

    @FXML
    private JFXButton addTrainerBtn;

    @FXML
    private JFXButton updateTrainerBtn;

    @FXML
    private JFXButton btnReload;
    
   
   
    private void loadAllTrainers() throws Exception{
        trainerTbl.setItems(FXCollections.observableArrayList(trainerBO.getAllTrainers()));
    }
    

    @FXML
    void addMemberOnClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddTrainer.fxml");
            
    }

    @FXML
    void trainerOnClicked(MouseEvent event) throws Exception {
        loadAllTrainers();
    }

    @FXML
    void updateMemberOnClicked(MouseEvent event) throws IOException {
       FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/UpdateTrainer.fxml");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trainerTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("trainer_id"));
        trainerTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("full_name"));
        trainerTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        trainerTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
        trainerTbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("mobile_number"));
        trainerTbl.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("address"));
        trainerTbl.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));
        trainerTbl.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("joining_date"));
        trainerTbl.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("description"));
         try {
             loadAllTrainers();
         } catch (Exception ex) {
             Logger.getLogger(TrainerController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    

    @FXML
    private void btnReloadOnAction(ActionEvent event) throws Exception {
        loadAllTrainers();
    }
    
}
