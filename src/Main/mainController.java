package Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable
{
    @FXML
    private HBox hBox;

    @FXML
    private Region region;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
//        Rectangle rect;
//        for(int i = 0; i < 50; i++)
//        {
//            rect = new Rectangle(10, 20);
//
//            //hBox.setHgrow(rect, Priority.ALWAYS);
//            hBox.setPrefWidth(400);
//            hBox.setSpacing(5);
//            hBox.getChildren().addAll(rect);
//        }

        // 5 pixels space between child nodes
        hBox.setSpacing(5);
        // 1 pixel padding between child nodes only
        hBox.setPadding(new Insets(1));
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 100);
        Rectangle r3 = new Rectangle(10, 20);
        Rectangle r4 = new Rectangle(20, 50);

        //HBox.setMargin(r1, new Insets(2, 2, 2, 2));

        hBox.getChildren().addAll(r1, r2, r3, r4);
    }
}


