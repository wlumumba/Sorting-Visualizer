package Main;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class infoController implements Initializable {

    @FXML
    private ComboBox combo;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }//End initialize method

    public void returnMain(ActionEvent event) throws IOException {

        //Loading in fxml and setting it to scene
        Parent Main = FXMLLoader.load(getClass().getResource("/Style/fxmls/main.fxml"));
        Scene mainScene = new Scene(Main);

        //Obtaining stage information and setting our new scene/fxml
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(mainScene);
        currentStage.show();

    }//End returnMain


}
