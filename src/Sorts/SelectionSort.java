package Sorts;

import Main.Model;
import Main.RectHelp;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort
{
    public ArrayList<Transition> transitionsList;

    public SelectionSort()
    {
        this.transitionsList = new ArrayList<>();
    }

    public ArrayList<Transition> selection(ArrayList<RectHelp> rects)
    {
        ParallelTransition sp;
        int minIndx;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < rects.size() - 1; i++)
        {
            // Find the minimum element in unsorted array
            minIndx = i;
            transitionsList.add(Model.colorTwo(rects, i, minIndx, Color.POWDERBLUE));

            for (int j = i + 1; j < rects.size(); j++)
            {

                // Colors minimum index and iterates through rects
                transitionsList.add(Model.colorTwo(rects, minIndx, j, Color.POWDERBLUE));
                if (rects.get(j).getH() < rects.get(minIndx).getH())
                {
                    if (minIndx == i)
                    {
                        transitionsList.add(Model.colorTwo(rects, minIndx, j, Color.SLATEGRAY));
                    }
                    else
                        {
                        transitionsList.add(Model.colorTwo(rects, minIndx, j, Color.SLATEGRAY));
                    }
                    minIndx = j;
                }
                else {
                    transitionsList.add(Model.colorTwo(rects, j, minIndx, Color.SLATEGRAY));
                }
            }

            // Swap the found minimum element with the first element
            if (minIndx != i)
            {
                sp = Model.swapTwo(rects, i, minIndx);
                this.transitionsList.add(sp);
            }

            //Set last bar to salmon on each i iteration since its sorted
            FillTransition finalBars = new FillTransition();
            finalBars.setShape(rects.get(i));
            finalBars.setToValue(Color.SALMON);
            this.transitionsList.add(finalBars);


        }

        //Set last bar to salmon on each i iteration since its sorted
        FillTransition finalBars = new FillTransition();
        finalBars.setShape(rects.get(rects.size()-1));
        finalBars.setToValue(Color.SALMON);
        this.transitionsList.add(finalBars);

        return transitionsList;
    }
}

