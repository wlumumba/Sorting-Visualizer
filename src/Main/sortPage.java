package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import java.util.Random;

public class sortPage {

    //Function to fill array with random numbers, taking in selected size of array from the slider in sortPage.fxml
    public static void generateRandom(int array[], int selectedSize)
    {

        Random filler = new Random();
        //Declaring a range of elements in order to restrict element size for hBox height (Below will generate numbers between 20-490)
        int range = filler.nextInt(21) + 469;
        //int random_integer = rand.nextInt(upperbound-lowerbound) + lowerbound;


        //return array;
    }//End generateRandom method

}//End sortPage class

