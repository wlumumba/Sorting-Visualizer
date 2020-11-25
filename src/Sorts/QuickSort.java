package Sorts;

import Main.Model;
import Main.RectHelp;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static Main.Model.pivotColor;

public class QuickSort {

    public  ArrayList<Transition> transitionsList;

    public QuickSort()
    {
        this.transitionsList = new ArrayList<>();
    }//end QuickSort

    public void quick(ArrayList<RectHelp> rect, int low, int high)
    {
        if(low < high)
        {
            int q = partition(rect, low, high);
            quick(rect, low, q - 1);
            quick(rect, q + 1, high);
        }
    }
    public int partition(ArrayList<RectHelp> rect, int low, int high)
    {
        int i = low;
        ParallelTransition sp;

        //Coloring our pivots
        this.transitionsList.add(pivotColor(rect, Color.GREEN, high));

        for(int j = low; j < high; j++){

            //Coloring unsorted/iteration as quicksort delves through the array
            //this.transitionsList.add(pivotColor(rect, Color.GREEN, j));
            //this.transitionsList.add(Model.colorTwo(rect,i,high , Color.LAVENDER ));

            RectHelp lowval = rect.get(j);
            RectHelp highval = rect.get(high);
            int highV = highval.getH();
            int lowV = lowval.getH();

            if( lowV < highV)
            {
                sp = Model.swapTwo(rect, i, j);

                transitionsList.add(sp);
                //Coloring our sorted elements
                this.transitionsList.add(Model.colorTwo(rect,i,high , Color.SALMON ));
                i++;
            }

            else
            {
                this.transitionsList.add(Model.colorTwo(rect,i,high , Color.LAVENDER ));
            }
        }

        transitionsList.add(Model.swapTwo(rect, i, high));
        this.transitionsList.add(Model.colorTwo(rect,i,high , Color.SALMON ));
        return i;

    }//end partition

    public ArrayList<Transition> startSort(ArrayList<RectHelp> rect)
    {
        quick(rect,0,rect.size()-1);
        return transitionsList;
    }//end startSort


}
