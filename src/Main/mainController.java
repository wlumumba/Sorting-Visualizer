package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable
{
    @FXML
    private HBox hBox; //need to figure out # of rectangles

    @FXML
    private Button change;

    @FXML
    void changeHeight(ActionEvent event)
    {
        Rectangle test = (Rectangle) hBox.getChildren().get(1);
        test.setHeight(40); //theoretically we can change the height
    }
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
        Rectangle r1 = new Rectangle(20, 10);
        Rectangle r2 = new Rectangle(20, 100);
        Rectangle r3 = new Rectangle(20, 20);
        Rectangle r4 = new Rectangle(20, 50);

        hBox.setAlignment(Pos.TOP_CENTER);

        //HBox.setMargin(r1, new Insets(2, 2, 2, 2));


        hBox.getChildren().addAll(r1, r2, r3, r4);

        ///Testing looping over rectangles
        for(Node rec: hBox.getChildren())
        {
            //rec = (Rectangle) rec;
            System.out.println(((Rectangle) rec).getHeight());
        }
        Rectangle test = (Rectangle) hBox.getChildren().get(1);
        System.out.println((int)test.getHeight());

        //Try to add a button method which changes size of rectangle
    }
}


