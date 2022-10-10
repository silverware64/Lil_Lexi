package lillexi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface abstractDecorator {
    void format();
}

class DecoratorPattern implements abstractDecorator, ActionListener {
    DecoratorPattern() {
        Glyph.fontframe = new JFrame();
        Glyph.label = new JLabel("Select Font Style");
        String[] fonts = {"Bold", "Italics", "Normal"};
        Glyph.combobox = new JComboBox(fonts);
        Glyph.fontframe.setBounds(200, 200, 200, 250);
        Glyph.label.setBounds(0, 0, 150, 50);
        Glyph.combobox.setBounds(0, 50, 200, 50);
        Glyph.button1 = new JButton("Set Font Style");
        Glyph.button1.setBounds(0, 100, 200, 30);
        Glyph.fontframe.add(Glyph.label);
        Glyph.fontframe.add(Glyph.combobox);
        Glyph.fontframe.add(Glyph.button1);
        Glyph.button1.addActionListener(this);
        Glyph.fontframe.setLayout(null);
        Glyph.fontframe.setVisible(true);
        Glyph.fontframe.setResizable(false);
    }

    @Override
    public void format() {
        Glyph.selectedFont = Glyph.combobox.getSelectedItem().toString().toUpperCase();
        Font selectedFontObj = new Font(Glyph.selectedFont, Font.PLAIN, (int) Glyph.textSize);
        Glyph.pane.setFont(selectedFontObj);
        Glyph.fontframe.dispose();
        switch (Glyph.selectedFont) {
            case "BOLD": {
                Bold b1 = new Bold();
                b1.format();
                break;
            }
            case "NORMAL": {
                Normal p1 = new Normal();
                p1.format();
                break;
            }
            case "ITALICS": {
                Italic i1 = new Italic();
                i1.format();
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Glyph.dp.format();
        Glyph.fontframe.setVisible(false);
    }
}

class Bold implements abstractDecorator {
    @Override
    public void format() {
        Font font = new Font(Glyph.selectedFont, Font.BOLD, (int) Glyph.textSize);
        Glyph.pane.setFont(font);
    }
}

class Italic implements abstractDecorator {
    @Override
    public void format() {
        Font font = new Font(Glyph.selectedFont, Font.ITALIC, (int) Glyph.textSize);
        Glyph.pane.setFont(font);
    }
}

class Normal implements abstractDecorator {
    @Override
    public void format() {
        Font font = new Font(Glyph.selectedFont, Font.PLAIN, (int) Glyph.textSize);
        Glyph.pane.setFont(font);
    }
}

