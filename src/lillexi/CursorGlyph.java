package lillexi;

import javax.swing.*;
import java.awt.*;

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

    @Override
    public RectangleGlyph draw(int x, int y){
        window.add(content);
        window.panel.add(content);
        content.setLocation(x,y);

        return null;
    }

}
