package Main;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Model
{
    /* Helper to generate rectangles with random heights */
    public static ArrayList<RectHelp> generateRandomRects()
    {
        ArrayList<RectHelp> tempArr = new ArrayList<RectHelp>();
        Random rand = new Random();    //Creates random HEIGHTS, not RECTANGLES
        RectHelp temp;
        int xVal = 0;   //To set x coordinates of each rect respectively

        for(int i = 0; i < sortController.numOfRecs; i++)
        {
            int h = rand.nextInt(sortController.hBoxHeight-20) + 20;  //Generate random height
            temp = new RectHelp(sortController.widthOfRecs, h);
            if(i != 0)
                xVal += sortController.widthOfRecs + 5;
            temp.setX( xVal );
            temp.setWidth(sortController.widthOfRecs);
            temp.setHeight(h);
            temp.setFill(Color.SLATEGRAY);

            tempArr.add(temp);
        }

        return tempArr;
    }

    /* Color animates the comparison of two bars */
    public static ParallelTransition colorTwo(ArrayList<RectHelp> rects, int leftI, int rightI, Color color)
    {
        ParallelTransition sync = new ParallelTransition();

        FillTransition fill;
        fill = new FillTransition(Duration.millis(100), rects.get(leftI)); ////Remember to make speed here dynamic
        fill.setToValue(color);
        sync.getChildren().add(fill);

        fill = new FillTransition(Duration.millis(100), rects.get(rightI));
        fill.setToValue(color);
        sync.getChildren().add(fill);


        /*for (int i = 0; i < 2; i++)
        {
            FillTransition fill = new FillTransition();
            fill.setShape(rects.get(leftI));
            fill.setToValue(color);
            fill.setDuration(Duration.millis(100));
            sync.getChildren().add(fill);
        }*/
        return sync;
    }

    /* Transition of swapping two bars */
    public static ParallelTransition swapTwo(ArrayList<RectHelp> rects, int leftI, int rightI)
    {
        ParallelTransition sync = new ParallelTransition();
        int diff = rightI - leftI;  //Basically how many rectangles to move over
        int widthAndSpace = sortController.hBoxWidth/ sortController.numOfRecs; //Width and spacing of each rec

        //Works as long as leftIndex < rightIndex
        sync.getChildren().addAll(moveByX(rects.get(leftI), (widthAndSpace * diff)), moveByX(rects.get(rightI), (-widthAndSpace * diff)) );

        //HAVE TO SWAP THE LITERAL ELEMENTS IN LIST
        Collections.swap(rects, leftI, rightI);

        return sync;

    }

    //Color fill for quicksort pivot
    public static ParallelTransition pivotColor(ArrayList<RectHelp> rects, Color color, int ...val)
    {
        //Declaring new parallel
        ParallelTransition pt = new ParallelTransition();

        //For loop that will iterate through inputted value (high/low from qs)
        for (int i = 0; i < val.length; i++)
        {
            FillTransition ft = new FillTransition();
            ft.setShape(rects.get(val[i]));
            ft.setToValue(color);
            //Displaying longer duration due to allowing user to understand where the pivot is
            ft.setDuration(Duration.millis(600));
            pt.getChildren().add(ft);
        }

        return pt;
    }

    /* Transition of swapping two bars */
    public static ParallelTransition swapTwo2(ArrayList<RectHelp> rects, int leftI, int rightI)
    {
        ParallelTransition sync = new ParallelTransition();
        int diff = rightI - leftI;  //Basically how many rectangles to move over
        int widthAndSpace = sortController.hBoxWidth/ sortController.numOfRecs; //Width and spacing of each rec

        //Works as long as leftIndex < rightIndex
        sync.getChildren().addAll(moveByX(rects.get(leftI), (widthAndSpace * diff)), moveByX(rects.get(rightI), (-widthAndSpace * diff)) );

        return sync;

    }

    /* Moving one bar TranslateTransition method */
    public static TranslateTransition moveByX(RectHelp rect, int x)
    {
        TranslateTransition moveThis = new TranslateTransition(Duration.millis(sortController.speed), rect);
        moveThis.setByX(x);
        return moveThis;
    }


}
