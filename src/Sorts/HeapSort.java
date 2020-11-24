package Sorts;

import Main.Model;
import Main.RectHelp;
import javafx.animation.FillTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort
{
    public ArrayList<Transition> transitionsList;

    public HeapSort()
    {
        this.transitionsList = new ArrayList<>();
    }

    public void heapify(ArrayList<RectHelp> rects, int i, int n)
    {
        int left = 2 * i + 1; //index of parent (i) left
        int right = 2 * i + 1; //index of parent (i) right
        int parent = i;

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && rects.get(l).getH() > rects.get(largest).getH())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && rects.get(r).getH() > rects.get(largest).getH())
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            this.transitionsList.add(Model.colorTwo(rects, i, largest, Color.POWDERBLUE));
            this.transitionsList.add(Model.swapTwo(rects, i, largest));
            this.transitionsList.add(Model.colorTwo(rects, i, largest, Color.SLATEGRAY));

            // Recursively heapify the affected sub-tree
            heapify(rects, largest, n);
        }
    }

    public void heap(ArrayList<RectHelp> rects)
    {
        int len = rects.size();

        //Build INITIAL max heap since array is not heap.. yet
        for(int i = rects.size() / 2 - 1; i >= 0; i--)
        {
            heapify(rects, i, rects.size());
        }

        //Once heap, swap first and last, then reheapify with last ommitted
        for(int i = len-1; i > 0; i--)
        {
            //Colors in first element as sorted (largest), since its moved to back
            FillTransition finalBars = new FillTransition();
            finalBars.setShape(rects.get(0));
            finalBars.setToValue(Color.SALMON);
            this.transitionsList.add(finalBars);

            this.transitionsList.add(Model.swapTwo(rects, 0, i));

            heapify(rects, 0, i);
        }

        //Colors in final element
        FillTransition finalBars = new FillTransition();
        finalBars.setShape(rects.get(0));
        finalBars.setToValue(Color.SALMON);
        this.transitionsList.add(finalBars);
    }

    public ArrayList<Transition> startSort(ArrayList<RectHelp> rects)
    {
        heap(rects);
        return transitionsList;
    }
}
