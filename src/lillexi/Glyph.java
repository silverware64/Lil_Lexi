package lillexi;
/**
 * Author: Tobin Nickels
 * Date: October 14, 2022
 *
 * Purpose:
 * Abstract class representing graphic on a text document.
 *
 *
 */

public abstract class Glyph {
    protected Window window;

    protected int width;
    protected int height;

    protected int x;
    protected int y;

    public int getWidth(){return width;}
    public int getHeight(){return height;}

    /**
     * Used to update the glyph with current coordinates.
     *
     * @param x
     * @param y
     */
    public abstract void draw(int x, int y);

}
