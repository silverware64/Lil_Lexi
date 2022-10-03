import javax.swing.*;
import java.awt.*;

public class CharGlyph extends Glyph {
    CharGlyph(String content)  {
        this.content = content;
    }
    @Override
    public String getContent() {
        return (String)content;
    }
}
