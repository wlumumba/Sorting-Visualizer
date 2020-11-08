package Main;

import javafx.scene.shape.Rectangle;

public class RectHelp extends Rectangle
{
    private int height;
    private int width;

    public RectHelp(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public int getH()
    {
        return this.height;
    }

}
