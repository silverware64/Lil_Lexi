package lillexi;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RectangleGlyph extends Glyph{
    private BufferedImage image;

    public RectangleGlyph(){
        try {
            image = ImageIO.read(new File("./rectangle.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }
    public String toString(){
        return "";
    }

    @Override
    public void draw(int x, int y) {

    }

}

