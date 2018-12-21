package lk.ijse.gymmanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;


public class LoadingController implements Initializable {


    @FXML
    private Label progress;
    public static Label label;

    //public static double value;
    @FXML
    private ProgressBar loadingBar;

    public static ProgressBar bar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadingBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        label=progress;
        bar=loadingBar;

    }


}
