package Sorts;

import Main.RectHelp;
import javafx.animation.Transition;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort
{
    public ArrayList<Transition> transitions;

    public BubbleSort()
    {
        this.transitions = new ArrayList<>();
    }

    public ArrayList<Transition> swap(ArrayList<RectHelp> rects)
    {
        int i, j;
        for(i = 0; i < rects.size()-1; i++)
        {
            for(j = 0; j < rects.size() - i - 1; j++)
            {
                if(rects.get(j).getH() > rects.get(j+1).getH())
                {
                    Collections.swap(rects, j, j+1);
                }
            }
        }

        return transitions;
    }
}
