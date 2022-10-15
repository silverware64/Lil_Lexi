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

    @Override
    public RectangleGlyph draw(int x, int y) {
        return new RectangleGlyph();
    }

}

