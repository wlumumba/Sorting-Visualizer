package Sorts;

import Main.Model;
import Main.RectHelp;
import Main.sortController;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import java.util.ArrayList;

public class MergeSort
{
    public ArrayList<Transition> merge(ArrayList<RectHelp> rects, ArrayList<RectHelp> left, ArrayList<RectHelp> right)
    {
        ArrayList<Transition> transitionsList = new ArrayList<Transition>();

        //Recall that rects comes in as unsorted!

        int sizeL = left.size();
        int sizeR = right.size();

        int k = 0; //index holder for passed arr
        int i = 0; //indexies for l and r arrays
        int j = 0;

        ArrayList<RectHelp> copy = new ArrayList<RectHelp>(rects.size());

        for (RectHelp rect: rects)
            copy.add(rect);

        System.out.println("Initial rects: " + rects);

        //Replace index k in original with smallest between left/right (printing recs looks like its duplicating elements but in reality its not)
        while(i < sizeL && j < sizeR)
        {
            if(left.get(i).getH() <= right.get(j).getH())
            {
                rects.set(k, left.get(i));
                System.out.println("Left went in: " + rects + "i: " + i);
                i = i + 1;

            }
            else
            {
                rects.set(k, right.get(j));
                System.out.println("Right went in: " + rects + "i: " + i);
                j = j + 1;
            }
            k = k + 1;
        }
        System.out.println("Finished regular: " + rects);

        //Whatever is leftover in left is added in
        while (i < sizeL)
        {
            rects.set(k, left.get(i));
            System.out.println("Moved extras in left: " + rects);
            k = k + 1;
            i = i + 1;
        }

        //Whatever is leftover in right is added in
        while (j < sizeR)
        {
            rects.set(k, right.get(j));
            System.out.println("Moved extras in right: " + rects);
            k = k + 1;
            j = j + 1;
        }

        ParallelTransition pt = new ParallelTransition();
        for(int x = 0; i < rects.size(); i++)
        {
            if(rects.get(x).getH() != copy.get(x).getH())
            {
                //find the one in merged
                for(int y = x; y < rects.size(); y++)
                {
                    if(rects.get(x).getH() == copy.get(y).getH())
                    {
                        pt.getChildren().add(Model.swapTwo2(copy, x, y)); //Turns out x values dont actually change on completion. They revert back to initial values and LITERAL swapping is what determines if we visually move them. Shit
                        break;
                    }
                }
            }
        }

        transitionsList.add(pt);

        System.out.println("Merged: " + rects);
        System.out.println("Initial rects: " + copy);
        System.out.println("New rects: " + copy);

        return transitionsList;
    }

    public ArrayList<Transition> split(ArrayList<RectHelp> rects)
    {
        ArrayList<Transition> transitionsList = new ArrayList<Transition>();

        if(rects.size() < 2)
            return transitionsList;

        int mid = rects.size()/ 2;

        ArrayList<RectHelp> left = new ArrayList<>();
        ArrayList<RectHelp> right = new ArrayList<>();

        for(int i = 0; i < mid; i++)
        {
            left.add(rects.get(i));
        }
        System.out.println("Left: " + left);

        for(int i = mid; i < rects.size(); i++)
        {
            right.add(rects.get(i));
        }
        System.out.println("Right: " + right);
        System.out.println();

        transitionsList.addAll(split(left));
        transitionsList.addAll(split(right));
        System.out.println("---------------");
        transitionsList.addAll(merge(rects, left, right));

        return transitionsList;
    }
}
