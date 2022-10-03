import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Observer {
    static private JPanel window;

    public Observer(JPanel w){
        window = w;
    }

    public void add(List<Glyph> glyphs, int index){
        window.add(Integer.toString(index), new Label(glyphs.get(index).getContent()));
    }

    public void remove(List<Glyph> glyphs, int index){

    }

}
