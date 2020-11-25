package Main;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class mainController  {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button exitBtn;

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
