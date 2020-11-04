package Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController
{
    @FXML
    private Slider slider;
    @FXML
    private Label label;

    public void onSliderChanged() {
        //Using onMouseRelease FXML::id defined label, setting the value of slider to the corresponding text box (see fxml for more)
    label.setText(slider.getValue()+" ");
}

    /*@Override
    //public void initialize(URL location, ResourceBundle resources)
    {
       /* //HBox hbox = new HBox();
        Button button1 = new Button("Add");
        Button button2 = new Button("Remove");
        hBox.setHgrow(button1, Priority.ALWAYS);
        hBox.setHgrow(button2, Priority.ALWAYS);
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        hBox.getChildren().addAll(button1, button2);*/
    }




