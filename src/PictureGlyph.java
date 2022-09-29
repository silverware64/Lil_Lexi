import javax.swing.*;
import java.awt.*;

public class PictureGlyph extends Glyph{
    PictureGlyph(JEditorPane window, String contents){
        this.contents = contents;
        this.window = window;
    }

    @Override
    void draw() {
        window.add(new JLabel(new ImageIcon((String)contents)));
    }
}
