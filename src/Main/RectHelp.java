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

    public int getW()
    {
        return this.width;
    }

    @Override
    public String toString() {
        return "RectHelp{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
