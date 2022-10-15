package lillexi;

import java.awt.*;

public abstract class Glyph {
    protected Window window;

    protected int width;
    protected int height;

    protected int x;
    protected int y;

    public int getWidth(){return width;}
    public int getHeight(){return height;}

    public abstract void  draw(int x, int y);

}
