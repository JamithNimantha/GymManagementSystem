/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.gymmanagementsystem.common.FxmlLoader;
import lk.ijse.gymmanagementsystem.common.Transition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class SettingsController implements Initializable {

    @FXML
    private ImageView imgManageWorkouts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onMouseExited(MouseEvent event) {
       Transition.OnMOuseExited(event);
    }

    @FXML
    private void onMouseEntered(MouseEvent event) {
        Transition.onMouseEntered(event);
    }

    @FXML
    private void imgManageWorkoutsOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddWorkout.fxml");
    }

    @FXML
    private void addMemberOnMouseClicked(MouseEvent event) throws IOException {
        FxmlLoader.classLoader("/lk/ijse/gymmanagementsystem/view/AddWorkout.fxml");
    }
    
}
