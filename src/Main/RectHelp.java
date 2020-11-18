package Main;

import javafx.scene.shape.Rectangle;

public class RectHelp extends Rectangle
{
    //Instance variables for each rectangle
    private int height;
    private int width;

    //Default constructor
    public RectHelp(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    //Return height method
    public int getH()
    {
        return this.height;
    }

    //Return height method
    public int getW()
    {
        return this.width;
    }

    @Override
    public String toString() {
        return "RectHelp{" +
                "height=" + height +
                '}';
    }

}
