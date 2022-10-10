package lillexi;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.BadLocationException;
import java.util.logging.Level;
import java.util.logging.Logger;

class prototype implements Cloneable {

    prototype() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GUI Error");
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Glyph edit = new Glyph();
                } catch (BadLocationException ex) {
                    Logger.getLogger(prototype.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new prototype();
    }
}

