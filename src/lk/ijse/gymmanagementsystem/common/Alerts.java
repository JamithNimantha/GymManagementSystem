package lk.ijse.gymmanagementsystem.common;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Alerts {
    public Alerts(){

    }

   public static void invalidInput(){
       Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
       a.setHeaderText(null);
       a.setContentText("Invalid Input");
       a.show();

    }

    public static void confirmClose(JFXButton button){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText(null);
       alert.setTitle("Confirm Close");
       alert.setContentText("Are you want to Close");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if (showAndWait.get()==ButtonType.OK){
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
    }

}
