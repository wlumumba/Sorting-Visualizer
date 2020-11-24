package Main;

import Sorts.*;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class sortController implements Initializable
{
    //Declaring hBox - This will contain our rectangles
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

    //Declaring stop button
    @FXML
    private Button stopSortBtn;

    //Declaring output text area
    @FXML
    private TextArea outputText;

    //Declaring choicebox to retrieve selected sort
    @FXML
    private ComboBox sortComboBox;

    @FXML
    private Button hoverBtn;

    /* Instance variables */
    public static final int hBoxWidth = 815; //Do not edit!
    public static final int hBoxHeight = 500; //Do not edit!
    public static int numOfRecs = 10; //This variable will contain the size of the array, adjusted by sizeSlider input, set to 5 for initial screen
    public static final int spacing = 5; //This is the spacing between the rectangles
    public static int speed = 50;  //Sets the speed of swaps in millis, this is adjusted by speedSlider input
    public static int widthOfRecs = hBoxWidth / numOfRecs - spacing; // hBox width / numNodes - spacing, this is the math use to allow variance in array size

    //Declaring our arraylist that will contain both height and width of rectangles, see RectHelp.java for more
    static ArrayList<RectHelp> rects = new ArrayList<RectHelp>();

    //Declare final list of transitions
    SequentialTransition sq = new SequentialTransition(); //might have to clear??

    //Initializing method that will be called upon screen launch
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //Disabling pause button for now, will be re-enabled upon start
        pauseSortBtn.setDisable(true);
        stopSortBtn.setDisable(true);
        startSortBtn.setDisable(true);

        Tooltip quickSort = new Tooltip("Quick Sort Info\nColors are as follows:\nPivot: Green\nSorted: Red\nIterator: Lavender");
        Tooltip bubbleSort = new Tooltip("Bubble Sort Info\nColors are as follows:\nComparisons: Blue\nSorted: Red");
        Tooltip heapSort = new Tooltip("Heap Sort info");
        Tooltip mergeSort = new Tooltip("Merge Sort info");
        Tooltip selectionSort = new Tooltip("Selection Sort info");

        //Setting the choice box sort list, updated to combo due to prompt ease of use
        sortComboBox.getItems().addAll("Merge Sort", "Bubble Sort", "Quick Sort", "Selection Sort", "Heap Sort");
        sortComboBox.setPromptText("Select a sort:");
        //Checking if an item was selected from the sort choices, then enabling the start button (disallows null string to be passed in start button method)
        //Added button to hold tooltips on choice changed
        sortComboBox.valueProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                startSortBtn.setDisable(false);

                if (newValue == "Quick Sort")
                {
                    hoverBtn.setTooltip(quickSort);
                }
                else if (newValue == "Bubble Sort")
                {
                    hoverBtn.setTooltip(bubbleSort);
                }
                else if (newValue == "Merge Sort")
                {
                    hoverBtn.setTooltip(mergeSort);
                }
                else if (newValue == "Selection Sort")
                {
                    hoverBtn.setTooltip(selectionSort);
                }
                else if (newValue == "Heap Sort")
                {
                    hoverBtn.setTooltip(heapSort);
                }
            }

        });

        Tooltip outputField = new Tooltip("Array elements (Unsorted and Sorted) will show here, alongside the sort time complexity!");
        outputText.setTooltip(outputField);

        //Defining our hBox values, using the above declared variables (some may be dynamic)
        hBox.setSpacing(spacing);
        hBox.setAlignment(Pos.TOP_CENTER);
        //Randomizing the rectangles (IE: Array elements, see Model.java), then adding the elements to our hBox
        rects = Model.generateRandomRects();
        hBox.getChildren().addAll(rects);

    }//End initialize method

    //Method that will intake slider values from the slider boxes, then calling the generator methods
    //OnRelease will clear hBox and call generator
    public void sliderSelection()
    {
        //Obtaining slider value for speed
        speed = (int) speedSlider.getValue();

        //Obtaining slider value for size -> this will set the number of rectangles/array
        numOfRecs = (int) sizeSlider.getValue();

        hBox.getChildren().clear();

        //Resizing our width with the updated values
        widthOfRecs = hBoxWidth / numOfRecs - spacing;

        //Generating our rectangles using the passed in value from slider, and filling our hBox
        rects = Model.generateRandomRects();
        hBox.getChildren().addAll(rects);

    }//End sliderSlection method

    //Method that will start the sorting and call other methods/sorts,etc...
    public void startButton (ActionEvent event)
    {

        //Calling disabler method to disallow user manipulation during sorting, and enabling our pause button as previously disabled
        disabler(true);
        pauseSortBtn.setDisable(false);
        stopSortBtn.setDisable(false);

        //Checking what the passed in sort was from the comboBox
        //String sortChoice = (String) sortChoiceBox.getSelectionModel().getSelectedItem();
        String sortChoice = (String) sortComboBox.getSelectionModel().getSelectedItem();

        //Calling our output function to print the arrays to text area
        outputText.appendText("Initial Unsorted Array:\n");
        outputLog();



        //Switch/case statements to pull user selection from choice box and call upon our sorting methods and begin animation
        switch (sortChoice)
        {
            case "Merge Sort":
                MergeSort mSort = new MergeSort();
                sq.getChildren().addAll(mSort.start(rects));
                outputText.appendText("Sort Time Complexity: MISSING!");
                break;

            case "Bubble Sort":
                outputText.appendText("Sort Time Complexity: \nBest & Worst: O(n^2) \n ");
                BubbleSort start = new BubbleSort();
                //System.out.println(rects);
                sq.getChildren().addAll(start.bubble(rects));
                //System.out.println(rects);
                break;

            case "Selection Sort":
                outputText.appendText("Sort Time Complexity: \nWorst: O(n^2)\nBest: O(n) \n");
                SelectionSort start2 = new SelectionSort();
                System.out.println(rects);
                sq.getChildren().addAll(start2.selection(rects));
                System.out.println(rects);
                break;

            case "Quick Sort":
                outputText.appendText("Sort Time Complexity: \n(Worst: O(n^2) ) \n(Best: O(n logn) )\n");
                QuickSort qstart = new QuickSort();
                sq.getChildren().addAll(qstart.startSort(rects));
                break;

            case "Heap Sort":
                outputText.appendText("Sort Time Complexity: \nBest & Worst: O(n logn)\n");
                HeapSort hstart = new HeapSort();
                sq.getChildren().addAll(hstart.startSort(rects));
                break;

        }//End switch statement


        //Playing our animation and running tasks on finished, then clearing SQ animation
        sq.play();

        sq.setOnFinished(f -> {
            disabler(false);
            pauseSortBtn.setDisable(true);
            stopSortBtn.setDisable(true);
            outputText.appendText("\nSorted Array:\n");
            outputLog();

        });

        sq.getChildren().clear();

    }//End startButton method

    //Pause button to disable sequential transition
    public void pauseButton (ActionEvent event)
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
    }//End pauseButton

   //Output method that will output our text to the textArea within our pane
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

    }//End outputLog method

    //This is a really weird/bad method, basically grabbing current window and relaunching our fxml.
    public void stopButton (ActionEvent event) throws IOException{

        Stage currentStage = (Stage) stopSortBtn.getScene().getWindow();
        currentStage.close();

        Stage relaunchStage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/Style/fxmls/sortPage.fxml"));
        relaunchStage.setTitle("Sorting Visualizer");
        relaunchStage.setResizable(false);
        relaunchStage.setScene(new Scene(root, 1000, 600));
        relaunchStage.show();

    }

    //Method that will intake boolean value for setDisable options for each buttons declared
    public void disabler (Boolean option)
    {
        sizeSlider.setDisable(option);
        speedSlider.setDisable(option);
        startSortBtn.setDisable(option);
        sortComboBox.setDisable(option);

    }//End disabler method

    public void returnMain(ActionEvent event) throws IOException {

        //Loading in User.fxml and setting it to scene
        Parent Main = FXMLLoader.load(getClass().getResource("/Style/fxmls/main.fxml"));
        Scene mainScene = new Scene(Main);

        //Obtaining stage information and setting our new scene/fxml
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(mainScene);
        currentStage.show();

    }//End openUser


}//End mainController class


