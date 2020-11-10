package Main;

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

        for(int i = 0; i < mainController.numOfRecs; i++)
        {
            int h = rand.nextInt(mainController.hBoxHeight-20) + 20;
            temp = new RectHelp(mainController.widthOfRecs, h);
            if(i != 0)
                xVal += mainController.widthOfRecs + 5;
            temp.setX( xVal );
            temp.setWidth(mainController.widthOfRecs);
            temp.setHeight(h);
            temp.setFill(Color.LIGHTSLATEGRAY);

            tempArr.add(temp);
        }

        return tempArr;
    }

    /* Transition of swapping two bars */
    public static ParallelTransition swapTwo(ArrayList<RectHelp> rects, int leftI, int rightI)
    {
        ParallelTransition sync = new ParallelTransition();
        int diff = rightI - leftI;  //Basically how many rectangles to move over
        int widthAndSpace = mainController.hBoxWidth/mainController.numOfRecs; //Width and spacing of each rec

        /*TranslateTransition left = new TranslateTransition(Duration.millis(2000), rects.get(leftI));
        left.setByX((mainController.hBoxWidth/mainController.numOfRecs) * (diff));

        TranslateTransition right = new TranslateTransition(Duration.millis(2000), rects.get(rightI));
        right.setByX((-1 * mainController.hBoxWidth/mainController.numOfRecs) * (diff));*/


        //Works as long as leftIndex < rightIndex
        sync.getChildren().addAll(moveByX(rects.get(leftI), (widthAndSpace * diff)), moveByX(rects.get(rightI), (-widthAndSpace * diff)) );

        //HAVE TO SWAP THE LITERAL ELEMENTS IN LIST
        Collections.swap(rects, leftI, rightI);

        return sync;

    }

    /* Moving one bar TranslateTransition method */
    public static TranslateTransition moveByX(RectHelp rect, int x)
    {
        TranslateTransition moveThis = new TranslateTransition(Duration.millis(mainController.speed), rect);
        moveThis.setByX(x);
        return moveThis;
    }


}
