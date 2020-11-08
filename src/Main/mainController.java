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
import java.util.Random;
import java.util.ResourceBundle;

public class mainController implements Initializable
{
    @FXML
    private HBox hBox;

    @FXML
    private Button change;

    //Declaring our array size slider to intake value
    @FXML
    private Slider sizeSlider;

    public static final int hBoxWidth = 780;
    public static final int hBoxHeight = 500;
    public static int numOfRecs = 5;           //Can alter this value
    public static final int spacing = 5;

    public static int widthOfRecs = hBoxWidth / numOfRecs - spacing; /* hBox width / numNodes - spacing */

    static ArrayList<RectHelp> rects = new ArrayList<RectHelp>();

    @FXML
    void changeHeight(ActionEvent event)
    {
        //Wrks as long as index < index1
        int index = 0;
        int index2 = 1;
        Rectangle test = (Rectangle) hBox.getChildren().get(index);
        Rectangle test1 = (Rectangle) hBox.getChildren().get(index2);


        TranslateTransition st = new TranslateTransition(Duration.millis(2000), test);
        st.setByX((hBoxWidth/numOfRecs) * (index2-index)); //110 is width including spacing
        //st.play();

        TranslateTransition st1 = new TranslateTransition(Duration.millis(2000), test1);
        st1.setToX((-1 * hBoxWidth/numOfRecs) * (index2-index));
        //st1.play();

        ParallelTransition sync = new ParallelTransition(st, st1);
        sync.play();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        hBox.setSpacing(spacing);
        hBox.setAlignment(Pos.TOP_CENTER);
        rects = Model.generateRandomRects();
        hBox.getChildren().addAll(rects);

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

    //Method that will intake slider values from the slider boxes, then calling the generator methods...
    //OnRelease will clear hBox and call generator
    public void sizeSliderSelection()
    {
        //Obtaining slider value and setting it into numOfRect
        numOfRecs = (int) sizeSlider.getValue();
        //Clearing hBox on drag release
        hBox.getChildren().clear();

    }//End sliderSelections


}//End mainController class


