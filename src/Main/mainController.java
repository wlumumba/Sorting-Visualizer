package Main;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class mainController implements Initializable
{
    @FXML
    private HBox hBox;

    //Declaring our array size slider to intake value and speedSlider
    @FXML
    private Slider sizeSlider;
    @FXML
    private Slider speedSlider;

    //Declaring Start button
    @FXML
    private Button startSortBtn;

    //Declaring choicebox to retreive selected sort
    @FXML
    private ChoiceBox sortChoiceBox;

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
        sortChoiceBox.setItems(FXCollections.observableArrayList("Merge Sort", "Cliff", "Moses"));

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

        //Clearing hBox
        hBox.getChildren().clear();

        //Resizing our width with the updated values
        widthOfRecs = hBoxWidth / numOfRecs - spacing;

        //Generating our rectangles using the passed in value from slider
        rects = Model.generateRandomRects();

        //Filling our hBox
        hBox.getChildren().addAll(rects);

    }//End sizeSliderSelections

    //Method to intake speed slider selection
    //This value will determine the speed of the sort running
    public void speedSliderSelection()
    {

    }//End speedSliderSelection

    //Method that will start the sorting and call other methods/sorts,etc...
    public void startButton (ActionEvent event) throws IOException
    {
        //Disabling slider selections so user cannot manipulate values during a sort, causing issues with animation
        sizeSlider.setDisable(true);
        speedSlider.setDisable(true);

        //Checking what the passed in sort was from the choice box
        String sortChoice = (String) sortChoiceBox.getSelectionModel().getSelectedItem();

        if (sortChoice == "Merge Sort")
        {
            System.out.print("This is a test of merge");
            //Function call
        }
        else if (sortChoice == "Cliff")
        {
            System.out.print("This is a test of cliff");
            //Function call
        }

        //Eventually re-enable sliders after sort completed (we could use a timer?) or have a prompt on sort completed saying "Try again?"
        //sizeSlider.setDisable(false);
        //speedSlider.setDisable(false);


    }


}//End mainController class


