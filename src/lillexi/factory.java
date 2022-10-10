package lillexi;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lillexi.Glyph.fontframe;

interface fontface1 {
    void getfontface();
}

interface color {
    void getfontcolor();
}

interface size {
    void getfontsize();
}

final class FontFace implements ActionListener, fontface1 {
    FontFace() {
        getfontface();
    }

    @Override
    public void getfontface() {
        fontframe = new JFrame();
        Glyph.label = new JLabel("Select Font Name");
        Glyph.button = new JButton("Select Font");
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Glyph.combobox = new JComboBox(fonts);
        Glyph.fontframe.setBounds(400, 400, 400, 300);
        Glyph.label.setBounds(0, 0, 150, 50);
        Glyph.combobox.setBounds(0, 50, 200, 50);
        Glyph.button.setBounds(0, 200, 100, 30);
        Glyph.fontframe.add(Glyph.label);
        Glyph.fontframe.add(Glyph.combobox);
        Glyph.fontframe.add(Glyph.button);
        Glyph.button.addActionListener(this);
        Glyph.fontframe.setLayout(null);
        Glyph.fontframe.setVisible(true);
        Glyph.fontframe.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Glyph.selectedFont = Glyph.combobox.getSelectedItem().toString();
        Font selectedFontObj = new Font(Glyph.selectedFont, Font.PLAIN, (int) Glyph.textSize);
        Glyph.pane.setFont(selectedFontObj);
        Glyph.fontframe.dispose();
    }
}

final class BackgroundColor implements color {

    BackgroundColor() {
        getfontcolor();
    }

    @Override
    public void getfontcolor() {
        Glyph.c1 = JColorChooser.showDialog(null, "Choose a Color", Glyph.pane.getBackground());

        if (Glyph.c1 != null)
            StyleConstants.setForeground(Glyph.style, Glyph.c1);
    }

}

final class FontColor implements color {
    FontColor() {
        getfontcolor();
    }

    @Override
    public void getfontcolor() {
        String s = Glyph.pane.getSelectedText();
        Glyph.doc = Glyph.pane.getStyledDocument();
        StyleConstants.setBackground(Glyph.attributeSet, Color.blue);
        Glyph.c1 = JColorChooser.showDialog(null, "Choose a Color", Glyph.pane.getBackground());
        if (Glyph.c1 != null)
            StyleConstants.setBackground(Glyph.attributeSet, Glyph.c1);
        try {
            Glyph.doc.insertString(Glyph.doc.getLength(), s, Glyph.attributeSet);
        } catch (BadLocationException ex) {
            Logger.getLogger(FontColor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

final class fontsize implements ActionListener, size {
    fontsize() {
        getfontsize();
    }

    @Override
    public void getfontsize() {
        Glyph.f3 = new JFrame();
        Glyph.size = new JLabel("Enter Size");
        Glyph.size1 = new JTextField();
        Glyph.f3.setBounds(200, 200, 300, 300);
        Glyph.set = new JButton("Set");
        Glyph.set.addActionListener(this);
        Glyph.size.setBounds(0, 0, 100, 50);
        Glyph.size1.setBounds(0, 50, 100, 50);
        Glyph.set.setBounds(0, 100, 100, 50);
        Glyph.f3.add(Glyph.size);
        Glyph.f3.add(Glyph.size1);
        Glyph.f3.add(Glyph.set);
        Glyph.f3.setLayout(null);
        Glyph.f3.setResizable(false);
        Glyph.f3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Glyph.textSize = Float.parseFloat(Glyph.size1.getText());
        Glyph.pane.setFont(Glyph.pane.getFont().deriveFont(Glyph.textSize));
        Glyph.f3.dispose();
    }
}


class FactoryMaker {
    static void getFactory(Object choice) {
        if (choice == Glyph.backgroundcolor) {
            color c = new BackgroundColor();
        }
        if (choice == Glyph.fontcolor) {
            color c = new FontColor();
        }
        if (choice == Glyph.fontsize) {
            size s = new fontsize();
        }
        if (choice == Glyph.fontface) {
            fontface1 c = new FontFace();
        }
    }
}
