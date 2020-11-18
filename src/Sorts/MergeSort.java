package Sorts;

import Main.RectHelp;
import javafx.animation.Transition;
import java.util.ArrayList;

public class MergeSort
{
    public ArrayList<Transition> merge(ArrayList<RectHelp> rects, ArrayList<RectHelp> left, ArrayList<RectHelp> right)
    {
        ArrayList<Transition> transitionsList = new ArrayList<Transition>();

        int sizeL = left.size();
        int sizeR = right.size();

        int k = 0; //index holder for passed arr
        int i = 0; //indexies for l and r arrays
        int j = 0;
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

        System.out.println("Merged: " + rects);

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

        split(left);
        split(right);
        System.out.println("---------------");
        merge(rects, left, right);

        return transitionsList;
    }
}
