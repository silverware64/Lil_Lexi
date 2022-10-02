import javax.swing.*;
import java.awt.*;

public class CharGlyph extends Glyph {
    CharGlyph(JEditorPane window, String contents)  {
        this.contents = contents;
        this.window = window;
    }
    @Override
    void draw() {
        window.add(new JLabel((String)contents));
    }
}
