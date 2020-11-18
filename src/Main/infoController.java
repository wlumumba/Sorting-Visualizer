package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class infoController {

    public void returnMain(ActionEvent event) throws IOException {

        //Loading in User.fxml and setting it to scene
        Parent Main = FXMLLoader.load(getClass().getResource("/Style/fxmls/main.fxml"));
        Scene mainScene = new Scene(Main);

        //Obtaining stage information and setting our new scene/fxml
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(mainScene);
        currentStage.show();

    }//End openUser
}
