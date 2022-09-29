import javax.swing.*;
import java.awt.*;

public abstract class Glyph {
    protected Object contents;
    protected JEditorPane window;

    abstract void draw();


}
