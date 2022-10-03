import javax.swing.*;
import java.awt.*;

public class PictureGlyph extends Glyph {
    PictureGlyph(String contents){
        this.content = contents;
    }

    @Override
    public String getContent(){
        return content;
    }
}
