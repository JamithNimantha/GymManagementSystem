package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DashBoardController implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane slidePane;

    @FXML
    private JFXButton memberbtn;

    @FXML
    private AnchorPane dashPanel;
    
    @FXML
    private JFXButton dashbtn;
    
     @FXML
    private JFXButton measurementBtn;
     
      @FXML
    private JFXButton membershipBtn;
     
     @FXML
    private JFXButton trainerBtn;

     @FXML
    private JFXButton workoutBtn;
     
      @FXML
    private JFXButton paymentBtn;
      
      @FXML
    private JFXButton settingBtn;
      
       @FXML
    private JFXButton attendenceBtn;
       
       @FXML
    private ImageView dashImage;
       
         @FXML
    private JFXButton reportBtn;
    @FXML
    private JFXButton btnLogOut;
       
       @FXML
    void attendenceBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/AttendancePane.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }
      
      @FXML
    void paymentBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/PaymentPane.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }
    @FXML
    void settingsBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Settings.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }
    
    @FXML
    void workoutBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getClass().getResource("/lk/ijse/gymmanagementsystem/view/Workout.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }
     
    @FXML
    void handleDashOnClick(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/DashPane.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }

    @FXML
    void handleMemberOnClick(MouseEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Member.fxml"));
        dashPanel.getChildren().setAll(anchorPane);
        System.gc();
    }
    @FXML
    void measurementOnClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Measurement.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }
    @FXML
    void trainerBtnOnAction(ActionEvent event) throws IOException {
         AnchorPane pame = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Trainer.fxml"));
         dashPanel.getChildren().setAll(pame);
         System.gc();
    }
    
    @FXML
    void membershipBtnOnAction(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Package.fxml"));
          dashPanel.getChildren().setAll(pane);
          System.gc();
    }
    @FXML
    void reportBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/Report.fxml"));
        dashPanel.getChildren().setAll(pane);
        System.gc();
    }
    
    
    void loadDashPane(){
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/DashPane.fxml"));
            dashPanel.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    void imageOnMouseEntered(MouseEvent event) {
        ImageView image = (ImageView) event.getSource();
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), image);
        scaleTransition.setToX(0.8);
        scaleTransition.setToY(0.8);
        scaleTransition.play();
        
    }

    @FXML
    void imageOnMouseExited(MouseEvent event) {
        ImageView image = (ImageView) event.getSource();
        ScaleTransition tran = new ScaleTransition(Duration.millis(300), image);
        tran.setToX(1.0);
        tran.setToY(1.0);
        tran.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDashPane();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void btnLogOutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymmanagementsystem/view/LogIn.fxml"));
        Scene scene =  new Scene(parent);
        stage.resizableProperty().setValue(Boolean.FALSE);

        stage.setScene(scene);
        stage.show();
    }

}
