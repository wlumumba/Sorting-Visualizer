package Main;

import Sorts.BubbleSort;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    /* Instance variables */
    public static final int hBoxWidth = 780;
    public static final int hBoxHeight = 500;
    public static int numOfRecs = 5;           //Can alter this value
    public static final int spacing = 5;

    public static int widthOfRecs = hBoxWidth / numOfRecs - spacing; /* hBox width / numNodes - spacing */

    static ArrayList<RectHelp> rects = new ArrayList<RectHelp>();

    @FXML
    void changeHeight(ActionEvent event)
    {
        //Works as long as index < index1
        ParallelTransition sync = Model.swapTwo(rects, 0, 4);
        sync.play();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        hBox.setSpacing(spacing);
        hBox.setAlignment(Pos.TOP_CENTER);
        rects = Model.generateRandomRects();
        hBox.getChildren().addAll(rects);
        sortChoiceBox.setItems(FXCollections.observableArrayList("Merge Sort", "Bubble Sort", "Moses"));

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

    }

    //Method to intake speed slider selection
    //This value will determine the speed of the sort running
    public void speedSliderSelection()
    {

    }

    //Method that will start the sorting and call other methods/sorts,etc...
    public void startButton (ActionEvent event) throws IOException
    {
        //Disabling slider selections so user cannot manipulate values during a sort, causing issues with animation
        sizeSlider.setDisable(true);
        speedSlider.setDisable(true);

        //Checking what the passed in sort was from the choice box
        String sortChoice = (String) sortChoiceBox.getSelectionModel().getSelectedItem();

        if (sortChoice == "Merge Sort") //Lets use a switch case maybe
        {
            System.out.print("This is a test of merge");
            //Function call
        }
        else if (sortChoice == "Bubble Sort")
        {
            System.out.print("This is a test of cliff");
            System.out.println(rects);
            BubbleSort start = new BubbleSort();

            SequentialTransition sq = new SequentialTransition();
            sq.getChildren().addAll(start.swap(rects));
            sq.play();

            System.out.println(rects);
            sq.setOnFinished(f -> sizeSlider.setDisable(false));
            //Function call
        }

        //Eventually re-enable sliders after sort completed (we could use a timer?) or have a prompt on sort completed saying "Try again?"
        //sizeSlider.setDisable(false);
        //speedSlider.setDisable(false);


    }


}


