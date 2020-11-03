package Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable
{
    @FXML
    private HBox hBox;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //HBox hbox = new HBox();
        Button button1 = new Button("Add");
        Button button2 = new Button("Remove");
        hBox.setHgrow(button1, Priority.ALWAYS);
        hBox.setHgrow(button2, Priority.ALWAYS);
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        hBox.getChildren().addAll(button1, button2);
    }
}


