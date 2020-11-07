package Main;

import javafx.animation.*;
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
import javafx.util.Duration;

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
        //Wrks as long as index < index1
        int index = 0;
        int index2 = 2;
        Rectangle test = (Rectangle) hBox.getChildren().get(index);
        Rectangle test1 = (Rectangle) hBox.getChildren().get(index2);


        TranslateTransition st = new TranslateTransition(Duration.millis(2000), test);
        st.setByX(110 * (index2-index));
        //st.play();

        TranslateTransition st1 = new TranslateTransition(Duration.millis(2000), test1);
        st1.setToX(-110 * (index2-index));
        //st1.play();

        ParallelTransition sync = new ParallelTransition(st, st1);
        sync.play();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //Number of rectangles
        int numOfRecs = 3;
        int hBoxX = 232;


        hBox.setSpacing(5);
        // 1 pixel padding between child nodes only
        //hBox.setPadding(new Insets(1));

        Rectangle temp;

        int width = (int) 331 / numOfRecs - 5; /* hBox width / numNodes - spacing */


        //hBox.setAlignment(Pos.BOTTOM_RIGHT);
        int xVal = 0;
        ArrayList<Rectangle> list = new ArrayList<Rectangle>();
        for(int i = 0; i < numOfRecs; i++)
        {
            temp = new Rectangle(width, 40 + (i*numOfRecs));
            if(i == 0)
                xVal = 0;
            else
                xVal += width + 5;
            temp.setX( xVal );
            list.add(temp);
        }



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


