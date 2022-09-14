package lillexi;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.BadLocationException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Prototype implements Cloneable {
   
   Prototype(){
       try {
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GUI Error");
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Window window = new Window();
                } catch (BadLocationException ex) {
                    Logger.getLogger(Prototype.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
}
  @Override
	public Object clone() throws CloneNotSupportedException{
		return new Prototype();	
	}
}

