package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class mainController {

    public void openSorts(ActionEvent event) throws IOException {

        //Loading in User.fxml and setting it to scene
        Parent Sorts = FXMLLoader.load(getClass().getResource("/Style/fxmls/sortPage.fxml"));
        Scene sortsScene = new Scene(Sorts);

        //Obtaining stage information and setting our new scene/fxml
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(sortsScene);
        currentStage.show();

    }//End openUser

    public void openInformation(ActionEvent event) throws IOException {

        //Loading in fxml and setting it to scene
        Parent Sorts = FXMLLoader.load(getClass().getResource("/Style/fxmls/informationPage.fxml"));
        Scene infoScene = new Scene(Sorts);

        //Obtaining stage information and setting our new scene/fxml
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(infoScene);
        currentStage.show();

    }//End openUser

    public void exitProgram(ActionEvent event) throws IOException
    {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


}
