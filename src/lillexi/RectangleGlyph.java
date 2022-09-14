package lillexi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

/*
Date: 14 Oct 2022
Author: Nicholas Bell
Purpose: The purpose of the RectangleGlyph class is to create a rectangle object with set margins, alignment, bounds.
 */
public class RectangleGlyph extends Glyph {

    private final JButton content;
    private final Window window;

    public RectangleGlyph(Window w, String c) {
        window = w;
        ImageIcon icon = new ImageIcon(c);
        JButton picButton = new JButton(icon);
        picButton.setBorder(new LineBorder(Color.WHITE));
        picButton.setMargin(new Insets(0, 0, 0, 0));
        picButton.setAlignmentY(.9f);
        picButton.setAlignmentX(.9f);
        picButton.setName("PICTURE_ID_" + new Random().nextInt());
        content = picButton;
        Rectangle r = new Rectangle(new Dimension(500, 500));
        content.setBounds(r);
        width = content.getBounds().width;
        height = content.getBounds().height;
    }

    @Override
    public void draw(int x, int y) {
        window.add(content);
        Window.panel.add(content);
        content.setLocation(x, y);
    }
}