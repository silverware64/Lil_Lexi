package lillexi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

interface Photocanvas{
   void imageop();
}

public class Strategy {
    Photocanvas o;
    public Strategy(String s){
       InsertImage i = new InsertImage();
       i.imageop();
    }
    public Strategy(String s,Canvas c){
        switch(s){
            case "Insert Image": 
                o = new InsertImage();   
                break;
            case "Remove Image":  
                o = new RemoveImage();
                break; 
        }
        o.imageop();
   }
}
class InsertImage implements Photocanvas{

    @Override
    public void imageop() {
        File pictureFile = choosePictureFile();
			
			if (pictureFile == null) {
			
				Edit.pane.requestFocusInWindow();
				return;
			}
			
			ImageIcon icon = new ImageIcon(pictureFile.toString());			
			JButton picButton = new JButton(icon);
			picButton.setBorder(new LineBorder(Color.WHITE));
			picButton.setMargin(new Insets(0,0,0,0));
			picButton.setAlignmentY(.9f);
			picButton.setAlignmentX(.9f);
	                picButton.setName("PICTURE_ID_" + new Random().nextInt());
			Edit.pane.insertComponent(picButton);
			Edit.pane.requestFocusInWindow();
        
    }
        private File choosePictureFile() {
		
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
								"PNG, JPG & GIF Images", "png", "jpg", "gif");
			chooser.setFileFilter(filter);
			
			if (chooser.showOpenDialog(Edit.frame) == JFileChooser.APPROVE_OPTION) {
			
				return chooser.getSelectedFile();
			}
			else {
				return null;
			}
		}
}

class RemoveImage implements Photocanvas{
     String pictureButtonName__;
    static final String ELEM = AbstractDocument.ElementNameAttribute;
    static final String COMP = StyleConstants.ComponentElementName;
   @Override
    public void imageop() {
      StyledDocument doc = (DefaultStyledDocument)Edit.pane.getDocument();
			ElementIterator iterator = new ElementIterator(doc);
			Element element;
			
			while ((element = iterator.next()) != null) {
			
				AttributeSet attrs = element.getAttributes();
			
				if (attrs.containsAttribute(ELEM, COMP)) {
                                    try {
							doc.remove(element.getStartOffset(), 1); // length = 1
						}
						catch (BadLocationException ex_) {
			
							throw new RuntimeException(ex_);
						}
					
				}
			}
	
			Edit.pane.requestFocusInWindow();
			pictureButtonName__ = null;
    }
}

