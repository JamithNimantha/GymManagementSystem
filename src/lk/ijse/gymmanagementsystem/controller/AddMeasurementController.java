
package lk.ijse.gymmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.ijse.gymmanagementsystem.business.BOFactory;
import lk.ijse.gymmanagementsystem.business.custom.MeasurementBO;
import lk.ijse.gymmanagementsystem.business.custom.MemberBO;
import lk.ijse.gymmanagementsystem.common.IDGenarator;
import lk.ijse.gymmanagementsystem.model.MeasurementDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author jamith
 */
public class AddMeasurementController implements Initializable {

    private MeasurementBO measurementBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MEASUREMENT);
    private MemberBO memberBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField measurementIDTxt;
    @FXML
    private JFXTextField heightTxt;
    @FXML
    private JFXTextField weightTxt;
    @FXML
    private JFXTextField chestTxt;
    @FXML
    private JFXTextField waistTxt;
    @FXML
    private JFXTextField thighTxt;
    @FXML
    private JFXTextField ArmTxt;
    @FXML
    private JFXDatePicker resultDateDatePicker;
    @FXML
    private JFXTextField memberIDTxt;
    @FXML
    private JFXTextField bmiTxt;
    @FXML
    private JFXTextField bmiStatusTxt;
    @FXML
    private JFXTextField txrMemberName;
    
     @FXML
    void cancelOnAction(ActionEvent event) {
        /*        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setGraphic(new ImageView(this.getClass().getResource("/lk/ijse/gymmanagementsystem/assestes/imogi_sad.gif").toString()));
        alert.setTitle("Confirm Close");
        alert.setContentText("Are you want to Close?");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if(showAndWait.get()==ButtonType.OK){
        Stage stage  = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
        }else{}*/
        Stage stage  = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        clear();

    }

    @FXML
    void saveOnAction(ActionEvent event) {

                    String resultDate = resultDateDatePicker.getValue().toString();
                    String memberName = txrMemberName.getText();
                    String memberID = null;
                    try {
                        memberID = memberBO.searchMemberIDUsingFullName(memberName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                     memberIDTxt.setText(memberID);
                    try {
                          if (txrMemberName.getText().isEmpty()||! memberIDTxt.getText().equals(memberBO.searchMemberIDUsingFullName(memberIDTxt.getText()))) {
                            Alert alert = new Alert(Alert.AlertType.ERROR,"Error",ButtonType.OK);
                            alert.setHeaderText(null);
                            alert.setContentText("Member not Selected");
                            alert.show();
                            txrMemberName.requestFocus();
                            }

                                else if (heightTxt.getText().isEmpty()||weightTxt.getText().isEmpty()||chestTxt.getText().isEmpty()||waistTxt.getText().isEmpty()||thighTxt.getText().isEmpty()||ArmTxt.getText().isEmpty()) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Empty Fields");
                                    alert.show();
                                    }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Error",ButtonType.OK);
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid Member");
                        alert.show();
                        txrMemberName.requestFocus();
                        //e.printStackTrace();

                    }

                    MeasurementDTO measurementDTO = new MeasurementDTO(measurementIDTxt.getText(), Double.parseDouble(heightTxt.getText()), Double.parseDouble(weightTxt.getText()), Double.parseDouble(bmiTxt.getText()), bmiStatusTxt.getText(), Double.parseDouble(chestTxt.getText()), Double.parseDouble(waistTxt.getText()), Double.parseDouble(thighTxt.getText()), Double.parseDouble(ArmTxt.getText()), resultDate, memberIDTxt.getText());
                    boolean addMeasurent = false;
                    try {
                        addMeasurent = measurementBO.addMeasurent(measurementDTO);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (addMeasurent) {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
                        a.setHeaderText(null);
                        a.setContentText("New Measurement Added Successfully...");
                        a.show();
                        clear();
                    }


    }
    private void setMeasurementID(){
       try {
           String newMeaID = IDGenarator.getNewID("Measurement","measurement_id","M");
           measurementIDTxt.setText(newMeaID);
       } catch (SQLException | ClassNotFoundException | IOException ex) {
           Logger.getLogger(AddMemberController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
   private void bmiCalc(){
		double weight = Double.parseDouble(weightTxt.getText());
		double height = Double.parseDouble(heightTxt.getText());
		String bmiStatus = null;
		
		double bmi = (weight / ((height * height) / 100)) * 100;
		//System.out.println(Math.round(bmi*100.00)/100.00);
                bmiTxt.setText(Double.toString(Math.round(bmi*100.00)/100.00));
		
                    if (bmi < 16) {
                            bmiStatus="Severe Thinness";
                    }else if(bmi>16 && bmi<17){
                            bmiStatus="Moderate Thinness";
                    }else if(bmi>17 && bmi<18.5){
                            bmiStatus="Mild Thinness";
                    } else if (bmi > 18.5 && bmi < 25) {
                            bmiStatus="Normal";
                    } else if (bmi > 25 && bmi < 30) {
                             bmiStatus="Overweight";
                    }else if (bmi > 30 && bmi < 35) {
                             bmiStatus="Obese Class I";
                    }else if (bmi > 35 && bmi < 40) {
                             bmiStatus="Obese Class II";
                    } else if (bmi == 40 || bmi > 40) {
                             bmiStatus="Obese Class III";
                    }
	
        bmiStatusTxt.setText(bmiStatus);
}
   private void clear(){
       memberIDTxt.clear();
       measurementIDTxt.clear();
       resultDateDatePicker.setValue(null);
       heightTxt.clear();
       weightTxt.clear();
       bmiStatusTxt.clear();
       bmiTxt.clear();
       waistTxt.clear();
       thighTxt.clear();
       chestTxt.clear();
       ArmTxt.clear();
       setMeasurementID();
       resultDateDatePicker.setValue(LocalDate.now());
       txrMemberName.requestFocus();
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //saveBtn.setDisable(true);
        Platform.runLater(()->txrMemberName.requestFocus());
        setMeasurementID();
        resultDateDatePicker.setValue(LocalDate.now());
       
        try {
            TextFields.bindAutoCompletion(txrMemberName,memberBO.getMemberNames() );
        } catch (Exception ex) {
            Logger.getLogger(AddMeasurementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    



    @FXML
    private void heightTxtOnAction(ActionEvent event) {
//        String name = heightTxt.getText();
//        if (!name.matches("[0-9 .]+")) {
//            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
//                a.setHeaderText(null);
//                a.setContentText("Invalid Input");
//                a.show();
//            heightTxt.selectAll();
//            heightTxt.requestFocus();
 //       }else{
            weightTxt.requestFocus();
      //  }
    }

    @FXML
    private void weightTxtOnAction(ActionEvent event) {
//        String name = weightTxt.getText();
//        if (!name.matches("[0-9 .]+")) {
//            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
//                a.setHeaderText(null);
//                a.setContentText("Invalid Input");
//                a.show();
//            weightTxt.selectAll();
//            weightTxt.requestFocus();
       // }else{
           chestTxt.requestFocus();
        //}
    }

    @FXML
    private void chestTxtOnAction(ActionEvent event) {
//        String name = chestTxt.getText();
//        if (!name.matches("[0-9 .]+")) {
//            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
//                a.setHeaderText(null);
//                a.setContentText("Invalid Input");
//                a.show();
//            chestTxt.selectAll();
//            chestTxt.requestFocus();
    //    }else{
            waistTxt.requestFocus();
    //    }
    }

    @FXML
    private void waistTxtOnAction(ActionEvent event) {
//        String name = waistTxt.getText();
//        if (!name.matches("[0-9 .]+")) {
//            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
//                a.setHeaderText(null);
//                a.setContentText("Invalid Input");
//                a.show();
//            waistTxt.selectAll();
//            waistTxt.requestFocus();
      //  }else{
          thighTxt.requestFocus();
      //  }
    }

    @FXML
    private void thighTxtOnAction(ActionEvent event) {
//        String name = thighTxt.getText();
//        if (!name.matches("[0-9 .]+")) {
//            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
//                a.setHeaderText(null);
//                a.setContentText("Invalid Input");
//                a.show();
//            thighTxt.selectAll();
//            thighTxt.requestFocus();
//        }else{
            ArmTxt.requestFocus();
        //}
    }

    @FXML
    private void ArmTxtOnAction(ActionEvent event) {
        String name = ArmTxt.getText();
//        if (!name.matches("[0-9 .]+")) {
//            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
//                a.setHeaderText(null);
//                a.setContentText("Invalid Input");
//                a.show();
//            ArmTxt.selectAll();
//            ArmTxt.requestFocus();
//        }else{
            saveBtn.requestFocus();
        //}
    }

    @FXML
    private void weightTxtOnKeyReleased(KeyEvent event) {

        String name= weightTxt.getText();
        int caretPosition = weightTxt.getCaretPosition();
            if (!name.matches("\\d*")){
                weightTxt.setText(name.substring(0,caretPosition-1)+name.substring(caretPosition));
                weightTxt.positionCaret(caretPosition-1);
            }
        bmiCalc();
    }

    @FXML
    void ArmTxtOnKeyReleased(KeyEvent event) {
        String name = ArmTxt.getText();
        int caretPosition = ArmTxt.getCaretPosition();
             if(!name.matches("\\d*")){
              //  ArmTxt.setText(name.replaceAll("[^\\d]", ""));
               // ArmTxt.
                  ArmTxt.setText(name.substring(0,caretPosition-1)+name.substring(caretPosition));
                  ArmTxt.positionCaret(caretPosition-1);
            }

    }
    @FXML
    void chestTxtOnKeyReleased(KeyEvent event) {
         String name = chestTxt.getText();
          int caretPosition = chestTxt.getCaretPosition();
            if (!name.matches("\\d*")){
                chestTxt.setText(name.substring(0,caretPosition-1)+name.substring(caretPosition));
                chestTxt.positionCaret(caretPosition-1);
            }

    }
    @FXML
    void heightTxtOnKeyReleased(KeyEvent event) {
         String name =heightTxt.getText();
         int caretPosition = heightTxt.getCaretPosition();
            if (!name.matches("\\d*")){
                heightTxt.setText(name.substring(0,caretPosition-1)+name.substring(caretPosition));
                heightTxt.positionCaret(caretPosition-1);
            }

    }




    @FXML
    void thighTxtOnKeyReleased(KeyEvent event) {
         String name =thighTxt.getText();
        int caretPosition = thighTxt.getCaretPosition();
        if (!name.matches("\\d*")){
             thighTxt.setText(name.substring(0,caretPosition-1)+name.substring(caretPosition));
             thighTxt.positionCaret(caretPosition-1);
         }

    }



    @FXML
    void waistTxtOnKeyReleased(KeyEvent event) {
         String name = waistTxt.getText();
        int caretPosition = waistTxt.getCaretPosition();
        if (!name.matches("\\d*")){
            waistTxt.setText(name.substring(0,caretPosition-1)+name.substring(caretPosition));
            waistTxt.positionCaret(caretPosition-1);
        }


    }


}

