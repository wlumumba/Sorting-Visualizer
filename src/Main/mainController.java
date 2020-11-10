package Main;

import Sorts.BubbleSort;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

    //Declaring Pause button
    @FXML
    private Button pauseSortBtn;

    //Declaring output text area
    @FXML
    private TextArea outputText;

    //Declaring choicebox to retrieve selected sort
    @FXML
    private ChoiceBox sortChoiceBox;

    /* Instance variables */
    public static final int hBoxWidth = 780;
    public static final int hBoxHeight = 500;
    public static int numOfRecs = 5;           //Can alter this value through slider
    public static final int spacing = 5;
    public static int speed = 250;  //Sets the speed of swaps in millis

    public static int widthOfRecs = hBoxWidth / numOfRecs - spacing; /* hBox width / numNodes - spacing */

    static ArrayList<RectHelp> rects = new ArrayList<RectHelp>();

    //Declare final list of transitions
    SequentialTransition sq = new SequentialTransition(); //might have to clear??

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //Disabling pause button for now, will be re-enabled upon start
        pauseSortBtn.setDisable(true);

        hBox.setSpacing(spacing);
        hBox.setAlignment(Pos.TOP_CENTER);
        rects = Model.generateRandomRects();
        hBox.getChildren().addAll(rects);
        //Setting the choice box sort list
        sortChoiceBox.setItems(FXCollections.observableArrayList("Merge Sort", "Bubble Sort", "Moses"));
        //Setting default value of the choice box
        sortChoiceBox.setValue("Bubble Sort");

    }

    //Method that will intake slider values from the slider boxes, then calling the generator methods
    //OnRelease will clear hBox and call generator
    public void sliderSelection()
    {
        //Obtaining slider value for speed
        speed = (int) speedSlider.getValue();

        //Obtaining slider value for size -> this will set the number of rectangles/array
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

    //Method that will start the sorting and call other methods/sorts,etc...
    public void startButton (ActionEvent event) throws IOException
    {
        //Calling disabler method to disallow user manipulation during sorting
        disabler(true);
        pauseSortBtn.setDisable(false);

        //Checking what the passed in sort was from the choice box
        String sortChoice = (String) sortChoiceBox.getSelectionModel().getSelectedItem();
        //Calling our output function to print the arrays to textarea
        outputText.appendText("Initial Unsorted Array:\n");
        outputLog();
        switch (sortChoice)
        {
            case "Merge Sort":
                System.out.print("This is a test of merge");
                break;

            case "Bubble Sort":
                BubbleSort start = new BubbleSort();
                //System.out.println(rects);
                sq.getChildren().addAll(start.bubble(rects));
                //System.out.println(rects);
                break;
        }

        //Playing our animation and running tasks on finished
        sq.play();

        sq.setOnFinished(f -> {
            disabler(false);
            pauseSortBtn.setDisable(true);
            outputText.appendText("Sorted Array:\n");
            outputLog();
        });

        sq.getChildren().clear();

    }

    //Pause button to disable sequential transition
    public void pauseButton (ActionEvent event) throws IOException
    {
        //Checking what the button text is
        if (pauseSortBtn.getText().equals("Pause Sort"))
        {
            //If button text = pause, will pause
            sq.pause();
            pauseSortBtn.setText("Play Sort");
        }
        else
        {
            //If button text not = pause, will play
            sq.play();
            pauseSortBtn.setText("Pause Sort");
        }
    }

   public void outputLog ()
    {
        //Initializing our string
        String output = " ";

        //Checking our array size
        for(int i = 0; i < rects.size(); i++)
        {
            //Setting the string to each element index (using getH, H = element size)
            output += rects.get(i).getH() + ", ";
        }
        //Manipulating string output
        output = output.substring(0, output.length() - 2);
        //System.out.print("Initial Array: [ " + output +" ]");

        //Checking if textArea is not null, then outputting our array
        if (outputText != null )
        {
            //outputText.appendText("Initial Array:\n");
            outputText.appendText("[ " + output +" ]\n\n");
        }

    }

    //Possible stop button
    //Current issue: Sorting starts from random area
    /*public void stopButton (ActionEvent event) throws IOException
    {
        sq.stop();
        sq.getChildren().clear();
        sizeSlider.setValue(10);
        speedSlider.setValue(250);
        //hBox.getChildren().clear();
        disabler(false);
    }*/

    //Method that will intake boolean value for setDisable options for each buttons declared
    public void disabler (Boolean option)
    {
        sizeSlider.setDisable(option);
        speedSlider.setDisable(option);
        startSortBtn.setDisable(option);
        sortChoiceBox.setDisable(option);

    }//End disabler method




}


