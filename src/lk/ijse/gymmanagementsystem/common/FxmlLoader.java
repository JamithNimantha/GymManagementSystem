package lk.ijse.gymmanagementsystem.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class FxmlLoader {

    public static void classLoader(String pathName) throws IOException {
        Parent root = FXMLLoader.load(FxmlLoader.class.getResource(pathName));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();

    }
}
