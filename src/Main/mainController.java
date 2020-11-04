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
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
        test.setHeight(40); //theoretically we can change the property of any rectangle
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


        hBox.setSpacing(5);
        // 1 pixel padding between child nodes only
        //hBox.setPadding(new Insets(1));


        Rectangle r1 = new Rectangle(20, 100);
        Rectangle r2 = new Rectangle(400,0,20, 100);
        Rectangle r3 = new Rectangle(20, 20);
        Rectangle r4 = new Rectangle(20, 50);

        int width = (int) 331 / 2 - 5; /* hBox width / numNodes - spacing */
        r1.setWidth(width);
        r2.setWidth(width);
        r3.setWidth(width);
        r4.setWidth(width);

        //hBox.setAlignment(Pos.BOTTOM_RIGHT);

        ArrayList<Rectangle> list = new ArrayList<Rectangle>();
        list.add(r1);
        list.add(r2);
        //list.add(r3);
        //list.add(r4);


        //HBox.setMargin(r1, new Insets(2, 2, 2, 2));

        hBox.getChildren().addAll(list);

        ///Testing looping over rectangles
        /*
        for(Node rec: hBox.getChildren())
        {
            //rec = (Rectangle) rec;
            System.out.println(((Rectangle) rec).getHeight());
        }
        Rectangle test = (Rectangle) hBox.getChildren().get(1);
        System.out.println((int)test.getHeight());*/

        //Try to add a button method which changes size of rectangle
    }
}


