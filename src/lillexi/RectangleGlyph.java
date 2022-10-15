package lillexi;

public class RectangleGlyph extends Glyph{

    public RectangleGlyph(Window w){
        window = w;
    }

    @Override
    public void draw(int x, int y){
        window.add(content);
        window.panel.add(content);
        content.setLocation(x,y);

    }
}
