package Sorts;

import Main.Model;
import Main.RectHelp;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BubbleSort
{
    public ArrayList<Transition> transitionsList;

    public BubbleSort()
    {
        this.transitionsList = new ArrayList<>();
    }

    //Swaps literal elements and adds series of parallel transitions to transitionList
    public ArrayList<Transition> bubble(ArrayList<RectHelp> rects)
    {
        ParallelTransition sp;

        int i, j;
        for(i = 0; i < rects.size(); i++)
        {
            for(j = 0; j < rects.size() - i - 1; j++)
            {
                //COLOR HAS to be set as a transition since array will already be sorted
                this.transitionsList.add(Model.colorTwo(rects, j, j+1, Color.CORAL));
                if(rects.get(j).getH() > rects.get(j+1).getH())
                {
                    sp = Model.swapTwo(rects, j, j+1);
                    this.transitionsList.add(sp);
                }
                this.transitionsList.add(Model.colorTwo(rects, j, j+1, Color.LIGHTSLATEGRAY));
            }

            //Set last bar to green on each i iteration since its sorted
            FillTransition finalBars = new FillTransition();
            finalBars.setShape(rects.get(rects.size()-1-i));
            finalBars.setToValue(Color.GREEN);
            this.transitionsList.add(finalBars);
        }

        return transitionsList;
    }
}
