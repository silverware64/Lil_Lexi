package lillexi;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

class Glyph {
    static JFrame frame, f2, f3, fontframe;
    static JTextPane pane;
    static JButton bim, set, button, button1;
    static Container cp;
    static Document doc;
    static Style style;
    static StyleContext context;
    static StyledDocument document;
    static SimpleAttributeSet attributeSet;

    static JTextField a, b, size1;
    static JScrollPane scrollpane;
    static JLabel l1, x, y, size, label;
    static JComboBox combobox;
    static Canvas c;
    static JMenuBar menuBar;
    static JMenu file, edit, imgopt, fontopt, bcolor, tools, options;
    static JMenuItem load, print, save, Quit, about, fontsize, newfile, backgroundcolor, fontcolor,
            fontstyle, fontface, rotateimg, resizeimg, removeimg, insertimg, cut, copy, copyall, paste, undo, redo;

    static Color c1;
    static float zoomLevel = 1.0f;
    static float textSize = 12.0f;
    static String selectedFont = "Arial";

    static Object choosemenu;
    static DecoratorPattern dp;


    Glyph() throws BadLocationException {

        frame = new JFrame("LIL LEXI EDITOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = frame.getContentPane();
        pane = new JTextPane();

        attributeSet = new SimpleAttributeSet();

        // Set the attributes before adding text 
        pane.setCharacterAttributes(attributeSet, true);
        doc = pane.getStyledDocument();

        JScrollPane scrollPane = new JScrollPane(pane);
        cp.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setJMenuBar((new menuBar()).createMenuBar());

    }
}

public class Lexi {

    static prototype p;

    @SuppressWarnings({"UseSpecificCatch", "Convert2Lambda"})

    public static void main(String[] args) {
        p = new prototype();
    }

}
