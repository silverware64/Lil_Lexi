package lillexi;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lillexi.Edit.fontframe;

interface fontface1{
   abstract void getfontface();
}
interface color{
	public abstract void getfontcolor();
}
final class FontFace implements  ActionListener,fontface1{
    FontFace(){
        getfontface();
    }

    @Override
    public void getfontface() {
            fontframe = new JFrame();
            Edit.label = new JLabel("Select Font Name");
            Edit.button  = new JButton("Select Font");
            String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            Edit.combobox = new JComboBox(fonts);
            Edit.fontframe.setBounds(400, 400, 400, 300);
            Edit.label.setBounds(0, 0, 150, 50);
            Edit.combobox.setBounds(0, 50, 200,50);  
            Edit.button.setBounds(0, 200, 100,30);
            Edit.fontframe.add(Edit.label);
            Edit.fontframe.add(Edit.combobox);
            Edit.fontframe.add(Edit.button);
            Edit.button.addActionListener(this);
            Edit.fontframe.setLayout(null);
            Edit.fontframe.setVisible(true);
            Edit.fontframe.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Edit.selectedFont = Edit.combobox.getSelectedItem().toString();
        Font selectedFontObj = new Font(Edit.selectedFont, Font.PLAIN, (int) Edit.textSize);
        Edit.pane.setFont(selectedFontObj);
        Edit.fontframe.dispose();
    }
}

final class BackgroundColor implements color{
    
    BackgroundColor(){
        getfontcolor();
    }
    
    @Override
    public void getfontcolor() {
        Edit.c1 = JColorChooser.showDialog(null, "Choose a Color", Edit.pane.getBackground());
        
        if (Edit.c1 != null)
            StyleConstants.setForeground(Edit.style,Edit.c1);
    }
    
}
final class FontColor implements color{
    FontColor(){
        getfontcolor();
    } 
    @Override
    public void getfontcolor() {
        String s=Edit.pane.getSelectedText();
        Edit.doc = Edit.pane.getStyledDocument();  
            StyleConstants.setBackground(Edit.attributeSet, Color.blue);  
        Edit.c1 = JColorChooser.showDialog(null, "Choose a Color", Edit.pane.getBackground());
        if (Edit.c1 != null)
               StyleConstants.setBackground(Edit.attributeSet, Edit.c1); 
        try {  
            Edit.doc.insertString(Edit.doc.getLength(),s ,Edit.attributeSet);
        } catch (BadLocationException ex) {
            Logger.getLogger(FontColor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

interface size{
    public abstract void getfontsize();
}



final class fontsize implements ActionListener,size{
    fontsize(){
        getfontsize();
    }
    @Override
    public void getfontsize() {
        Edit.f3 = new JFrame();
        Edit.size = new JLabel("Enter Size");
        Edit.size1 = new JTextField();
        Edit.f3.setBounds(200,200,300,300);
        Edit.set = new JButton("Set");
        Edit.set.addActionListener(this);
        Edit.size.setBounds(0,0,100,50);
        Edit.size1.setBounds(0,50,100,50);
        Edit.set.setBounds(0,100,100,50);
        Edit.f3.add(Edit.size);
        Edit.f3.add(Edit.size1);
        Edit.f3.add(Edit.set);
        Edit.f3.setLayout(null);
        Edit.f3.setResizable(false);
        Edit.f3.setVisible(true);     
    } 
    @Override
    public void actionPerformed(ActionEvent ae) {
        Edit.textSize = Float.parseFloat(Edit.size1.getText());
        Edit.pane.setFont(Edit.pane.getFont().deriveFont(Edit.textSize));
        Edit.f3.dispose();
    }
}


class FactoryMaker{
    static void getFactory(Object choice){
        if(choice == Edit.backgroundcolor){
           color c = new BackgroundColor();
      }
        if(choice==Edit.fontcolor){
            color c = new FontColor();
        }
        if(choice==Edit.fontsize){
            size s = new fontsize();
        }
        if(choice==Edit.fontface){
            fontface1 c = new FontFace();
        }
    }
}
