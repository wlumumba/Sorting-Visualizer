package Main;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Model
{
    /* Helper to generate rectangles with random heights */
    public static ArrayList<RectHelp> generateRandomRects()
    {
        ArrayList<RectHelp> tempArr = new ArrayList<RectHelp>();
        Random rand = new Random();    //Creates random HEIGHTS, not RECTANGLES
        RectHelp temp;
        int xVal = 0;   //To set x coordinate

        for(int i = 0; i < mainController.numOfRecs; i++)
        {
            int h = rand.nextInt(mainController.hBoxHeight-20) + 20;
            temp = new RectHelp(mainController.widthOfRecs, h);
            if(i == 0)
                xVal = 0;
            else
                xVal += mainController.widthOfRecs + 5;
            temp.setX( xVal );
            temp.setWidth(mainController.widthOfRecs);
            temp.setHeight(h);

            tempArr.add(temp);
        }

        return tempArr;
    }

    /* Transition of swapping two bars */
    public static ParallelTransition swapTwo(ArrayList<RectHelp> rects, int leftI, int rightI)
    {
        ParallelTransition sync = new ParallelTransition();
        int diff = rightI - leftI;
        //RectHelp rec1 = (RectHelp) hBox.getChildren().get(leftI);
        //RectHelp rec2 = (RectHelp) hBox.getChildren().get(leftI);
        RectHelp rec1 = rects.get(leftI);


        TranslateTransition st = new TranslateTransition(Duration.millis(2000), rec1);
        st.setByX((mainController.hBoxWidth/mainController.numOfRecs) * (diff));

        sync.getChildren().add(st);

        return sync;





    }


}
