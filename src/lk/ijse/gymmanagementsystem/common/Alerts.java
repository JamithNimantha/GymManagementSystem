package lk.ijse.gymmanagementsystem.common;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerts {
   public static void invalidInput(){
       Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
       a.setHeaderText(null);
       a.setContentText("Invalid Input");
       a.show();

    }
}
