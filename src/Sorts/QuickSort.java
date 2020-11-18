package Sorts;

import Main.Model;
import Main.RectHelp;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class QuickSort {
    public  ArrayList<Transition> transitionsList;

    public QuickSort(){this.transitionsList = new ArrayList<>();}

    public void quick(ArrayList<RectHelp> rect, int low, int high){
        if(low < high){
            int q = partition(rect, low, high);
            quick(rect, low, q - 1);
            quick(rect, q + 1, high);
        }
    }
    public int partition(ArrayList<RectHelp> rect, int low, int high){
        int i = low;
        ParallelTransition sp;

        this.transitionsList.add(Model.colorTwo(rect,i,high , Color.POWDERBLUE ));
        this.transitionsList.add(Model.colorTwo(rect,i,high , Color.KHAKI));
        for(int j = low; j < high; j++){
            RectHelp lowval = rect.get(j);
            RectHelp highval = rect.get(high);
            int highV = highval.getH();
            int lowV = lowval.getH();
            if( lowV < highV){
                sp = Model.swapTwo(rect, i, j);
                transitionsList.add(sp);
                i++;
            }
        }
        transitionsList.add(Model.swapTwo(rect, i, high));
        return i;
    }

    public ArrayList<Transition> startSort(ArrayList<RectHelp> rect){
        quick(rect,0,rect.size()-1);
        return transitionsList;
    }

    // public  /*ArrayList<Transition>*/ ArrayList<RectHelp>  quick(ArrayList<RectHelp> rects){
      /*  ParallelTransition sp;
        if(rects.size() <= 1) {
           //return transitionsList;
            return rects;
        }
        ArrayList<RectHelp> sorted = new ArrayList<>();
        ArrayList<RectHelp> lesser = new ArrayList<>();
        ArrayList<RectHelp> greater = new ArrayList<>();

        RectHelp pivotRectangle = rects.get(rects.size() - 1);
        int pivotHeight = pivotRectangle.getH();
        int pivot = rects.size() - 1;

        for(int i = 0; i < rects.size() - 1; i++){
            RectHelp cRec = rects.get(i);
            int currRec = cRec.getH();
            this.transitionsList.add(Model.colorTwo(rects,i,pivot , Color.POWDERBLUE ));
            if(currRec <= pivotHeight){
                lesser.add(cRec);
            } else {
                sp = Model.swapTwo(rects, pivot, i);
                this.transitionsList.add(sp);
            }
            //this.transitionsList.add(Model.colorTwo(rects,i,pivot, Color.SLATEGRAY ));
            //this.transitionsList.add(Model.colorTwo(rects,i,pivot, Color.SLATEGRAY ));
           // this.transitionsList.add(Model.colorTwo(rects,currRec,pivot, Color.SLATEGRAY ));
           // FillTransition finalBars = new FillTransition();
           // finalBars.setShape(rects.get(rects.size() - 1));
           // finalBars.setToValue(Color.SALMON);
            //this.transitionsList.add(finalBars);
        }

        lesser = quick(lesser);
        greater = quick(greater);

        //quick(lesser);
        //quick(greater);

        lesser.add(pivotRectangle);
        lesser.addAll(greater);

        sorted = lesser;
        //System.out.println(sorted);
       // System.out.println("This is sorted");
        //System.out.println(sorted);
        //return transitionsList;

        return sorted;

    } */

}
