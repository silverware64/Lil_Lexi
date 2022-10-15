package lillexi;

import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class CharacterGlyph extends Glyph{

    private JLabel content;

    public CharacterGlyph(Window w, String c){
        window = w;
        content = new JLabel(c);
        content.setFont(window.getCurrentFont());
        Rectangle2D content_bounds = content.getFontMetrics(window.getCurrentFont()).getStringBounds(c,window.getGraphics());
        content.setBounds(content_bounds.getBounds());
        this.width = content.getBounds().width;
        this.height = content.getBounds().height;
    }

    public String toSting(){
        return content.getText();
    }

    @Override
    public void draw(int x, int y){
        window.add(content);
        window.panel.add(content);
        content.setLocation(x,y);
    }
}
