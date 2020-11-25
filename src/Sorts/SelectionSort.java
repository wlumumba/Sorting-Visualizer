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

        for (int i = 0; i < rects.size() - 1; i++) {
            minIndx = i;
            transitionsList.add(Model.colorTwo(rects, i, minIndx, Color.POWDERBLUE));

            for (int j = i + 1; j < rects.size(); j++) {
                transitionsList.add(Model.colorTwo(rects, j, j, Color.POWDERBLUE));
                if (rects.get(j).getH() < rects.get(minIndx).getH()) {
                    if (minIndx == i) {
                        transitionsList.add(Model.colorTwo(rects, minIndx, j, Color.POWDERBLUE));
                    } else {
                        transitionsList.add(Model.colorTwo(rects, minIndx, j, Color.SLATEGRAY));
                    }
                    minIndx = j;
                } else {
                    transitionsList.add(Model.colorTwo(rects, j, minIndx, Color.SLATEGRAY));
                }
            }

            if (minIndx != i) {
                //transitionsList.add(swap(arr, i, minIndx));
                sp = Model.swapTwo(rects, i, minIndx);
                this.transitionsList.add(sp);
            }

            transitionsList.add(Model.colorTwo(rects, i, minIndx, Color.SLATEGRAY));
        }

        //transitionsList.add(Model.colorTwo(Arrays.asList(rects), Color.SALMON));
        return transitionsList;
    }
}
        /*ParallelTransition sp;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < rects.size() - 1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < rects.size(); j++)
                if (rects.size(j) < rects.size(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = rects.size(min_idx);
            rects.size(min_idx) = rects.size(i);
            rects.size(i) = temp;
        }
    }*/

