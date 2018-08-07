/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.gymmanagementsystem.common.FxmlLoader;
import lk.ijse.gymmanagementsystem.common.Transition;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class DashPaneController implements Initializable {

    
    @FXML
    private AnchorPane dashPane;

    @FXML
    private ImageView addMember;

    @FXML
    private ImageView addSchedule;

    @FXML
    private ImageView attendance;

    @FXML
    private ImageView addPayment;

    @FXML
    private ImageView addMeasurement;
    
    @FXML
    void addMeasurementOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddMeasurement.fxml");

    }

    @FXML
    void addMemberOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddMember.fxml");
    }

    @FXML
    void addPaymentOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/Payment.fxml");
    }

    @FXML
    void addScheduleOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddWorkoukSchedule.fxml");
    }

    @FXML
    void attendanceOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/Attendance.fxml");
    }

    @FXML
    void onMouseEntered(MouseEvent event) {
        Transition.onMouseEntered(event);
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        Transition.OnMOuseExited(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
