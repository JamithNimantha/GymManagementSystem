/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.main;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.gymmanagementsystem.common.PreLoader;
import sun.launcher.resources.launcher_it;

import java.util.Optional;

/**
 *
 * @author jamith
 */
public class Main extends Application{

    private static final int countLimit =100000;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent =FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/LogIn.fxml"));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/lk/ijse/gymmanagementsystem/assestes/icons8_Triceps_100px.png")));
        
        Scene temp = new Scene(parent);
        primaryStage.setScene(temp);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);

        primaryStage.show();
        //primaryStage.setFullScreen(true);
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setHeaderText(null);
//                alert.setTitle("Confirm Close");
//                alert.setContentText("Are you want to Close");
//                Optional<ButtonType> showAndWaint = alert.showAndWait();
    //                if (showAndWaint.get()==ButtonType.OK){
    //                    System.exit(0);
    //                }else{}
//
//            }
//        });

                
    }
    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, PreLoader.class,args);
        
    }

    @Override
    public void init() throws Exception {
        for (int i=0;i<countLimit;i++){
            double progress =(100*i)/countLimit;
            LauncherImpl.notifyPreloader(this,new Preloader.ProgressNotification(progress));
        }
    }
}
