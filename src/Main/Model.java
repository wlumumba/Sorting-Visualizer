package Main;

import java.util.ArrayList;
import java.util.Random;

public class Model
{
    public static ArrayList<RectHelp> generateRandomRects()
    {
        ArrayList<RectHelp> tempArr = new ArrayList<RectHelp>();
        Random rand = new Random();    //Creates random HEIGHTS, not RECTANGLES
        RectHelp temp;
        int xVal = 0;

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
}
