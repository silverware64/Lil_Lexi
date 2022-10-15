/**
 * Author: Tobin Nickels
 * Date: October 14, 2022
 *
 * Purpose:
 * Graphical representation of cursor on text document.
 * All CursorGlyphs look the same.
 */
package lillexi;
/*
 * Date:
 * Author: Deez Nutz and Joe Mama
 */
import javax.swing.*;
import java.awt.*;

// This class is the Cursor class that
public class CursorGlyph extends Glyph {

    private JLabel content;

    public CursorGlyph(Window w){
        window = w;
        content = new JLabel("|");
        content.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        content.setForeground(Color.BLUE);
        Rectangle r = new Rectangle(new Dimension(15,15));
        content.setBounds(r);
    }

    public String toString(){
        return "";
    }

    @Override
    public void draw(int x, int y){
        window.add(content);
        window.panel.add(content);
        content.setLocation(x,y);

    }

}
