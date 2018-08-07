package lk.ijse.gymmanagementsystem.common;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gymmanagementsystem.controller.LoadingController;

public class PreLoader extends Preloader{
    private Stage preLoaderStage;
    private Scene scene;

    public PreLoader(){

    }

    @Override
    public void init() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/gymmanagementsystem/view/Loading.fxml"));
        scene=new Scene(root);
    }
    @Override
    public void start(Stage primaryStage) {
        this.preLoaderStage=primaryStage;

        preLoaderStage.initStyle(StageStyle.UNDECORATED);
        preLoaderStage.setScene(scene);
        primaryStage.show();
    }

    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
        if (info instanceof ProgressNotification){
           // LoadingController.label.setText(((ProgressNotification) info).getProgress()+"%");
            LoadingController.bar.setProgress(((ProgressNotification) info).getProgress()/100);
        }

    }

    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {
        StateChangeNotification.Type type=info.getType();
        switch (type){
            case BEFORE_START:
                preLoaderStage.hide();
                break;
        }

    }
}
