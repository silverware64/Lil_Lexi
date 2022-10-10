package lillexi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

interface photoCanvas {
    void image();
}

public class strategy {
    photoCanvas o;

    public strategy(String s) {
        insertImage i = new insertImage();
        i.image();
    }

    public strategy(String s, Canvas c) {
        switch (s) {
            case "Insert Image":
                o = new insertImage();
                break;
            case "Remove Image":
                o = new removeImage();
                break;
        }
        o.image();
    }
}

class insertImage implements photoCanvas {

    @Override
    public void image() {
        File pictureFile = choosePictureFile();

        if (pictureFile == null) {

            Glyph.pane.requestFocusInWindow();
            return;
        }

        ImageIcon icon = new ImageIcon(pictureFile.toString());
        JButton picButton = new JButton(icon);
        picButton.setBorder(new LineBorder(Color.WHITE));
        picButton.setMargin(new Insets(0, 0, 0, 0));
        picButton.setAlignmentY(.9f);
        picButton.setAlignmentX(.9f);
        picButton.setName("PICTURE_ID_" + new Random().nextInt());
        Glyph.pane.insertComponent(picButton);
        Glyph.pane.requestFocusInWindow();

    }

    private File choosePictureFile() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPG & GIF Images", "png", "jpg", "gif");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(Glyph.frame) == JFileChooser.APPROVE_OPTION) {

            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }
}

class removeImage implements photoCanvas {
    static final String ELEM = AbstractDocument.ElementNameAttribute;
    static final String COMP = StyleConstants.ComponentElementName;
    String pictureButtonName__;

    @Override
    public void image() {
        StyledDocument doc = (DefaultStyledDocument) Glyph.pane.getDocument();
        ElementIterator iterator = new ElementIterator(doc);
        Element element;

        while ((element = iterator.next()) != null) {

            AttributeSet attrs = element.getAttributes();

            if (attrs.containsAttribute(ELEM, COMP)) {
                try {
                    doc.remove(element.getStartOffset(), 1); // length = 1
                } catch (BadLocationException ex_) {

                    throw new RuntimeException(ex_);
                }

            }
        }

        Glyph.pane.requestFocusInWindow();
        pictureButtonName__ = null;
    }
}

