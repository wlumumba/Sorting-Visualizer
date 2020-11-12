package Sorts;

import Main.Model;
import Main.RectHelp;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Transition> transitionsList;

    public MergeSort(){this.transitionsList = new ArrayList<>();}

    public ArrayList<Transition> merge(ArrayList<RectHelp> rect, int p, int q, int r){
        ArrayList<RectHelp> temp = new ArrayList<>();
        for(int i = p; i <=r; i++){
            RectHelp tmp1 = temp.get(i);
            RectHelp tmp2 = rect.get(i);
            //int tempVal = tmp1.getH();
            //int tempRectVal = tmp2.getH();
            tmp1 = tmp2;
            temp.add(tmp1);

        }
        int i = p;
        int j = q + 1;
        int k = p;

        while(i <= q && j <= r){
            RectHelp tmp1 = temp.get(i);
            RectHelp tmp2 = temp.get(j);
            int temp1Val = tmp1.getH();
            int temp2Val = tmp2.getH();
            if(temp1Val < temp2Val){
                RectHelp tmp3 = rect.get(k++);
                RectHelp tmp4 = temp.get(i++);
                tmp3 = tmp4;
            } else {
                RectHelp tmp3 = rect.get(k++);
                RectHelp tmp4 = temp.get(j++);
                tmp3 = tmp4;
            }
        }
        while( i <= q) {
            RectHelp tmp3 = rect.get(k++);
            RectHelp tmp4 = temp.get(i++);
            tmp3 = tmp4;
        }
        while( j <= r) {
            RectHelp tmp3 = rect.get(k++);
            RectHelp tmp4 = temp.get(j++);
            tmp3 = tmp4;
        }
        ParallelTransition sp;

        for(int x = p; x <=r; x++){
            for(int y = p; y <= r; y++){
                RectHelp tempX = temp.get(x);
                RectHelp tempY = rect.get(y);
                if(tempX == tempY){
                    sp = Model.swapTwo(rect,y ,x);
                    transitionsList.add(sp);
                }
            }
        }
        return transitionsList;
    }
    public ArrayList<Transition> mergeSort(ArrayList<RectHelp> rect, int p, int r){
        if(p < r){
            int q = (p + r) / 2;
            transitionsList.addAll(mergeSort(rect, p, q));
            transitionsList.addAll(mergeSort(rect, q + 1, r));
            transitionsList.addAll(merge(rect, p, q,r));
        }
        return transitionsList;
    }
    public  ArrayList<Transition> startSort(ArrayList<RectHelp> rect){
        transitionsList.addAll(mergeSort(rect, 0, rect.size() - 1));
        return  transitionsList;
    }
}

