package lillexi;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CursorGlyph extends Glyph {

    private JLabel content;

    public CursorGlyph(Window w){
        window = w;
        content = new JLabel("|");
        content.setForeground(Color.BLUE);
        Rectangle r = new Rectangle(new Dimension(15,15));
        content.setBounds(r);
    }

    @Override
    public void draw(int x, int y){
        window.add(content);
        window.panel.add(content);
        content.setLocation(x,y);

    }

}
