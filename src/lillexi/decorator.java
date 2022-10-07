package lillexi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface abstractDecorator{
    void format();
}

class DecoratorPattern implements abstractDecorator, ActionListener{
    DecoratorPattern(){
        Edit.fontframe = new JFrame();
        Edit.label = new JLabel("Select Font Style");
        String fonts[] = {"Bold", "Italics", "Plain"};
        Edit.combobox = new JComboBox(fonts);
        Edit.fontframe.setBounds(200, 200, 200,250);
        Edit.label.setBounds(0, 0, 150, 50);
        Edit.combobox.setBounds(0, 50, 200,50);  
        Edit.button1 = new JButton("Set Font Style");
        Edit.button1.setBounds(0, 100, 200,30);
        Edit.fontframe.add(Edit.label);
        Edit.fontframe.add(Edit.combobox);
        Edit.fontframe.add(Edit.button1);
        Edit.button1.addActionListener(this);
        Edit.fontframe.setLayout(null);
        Edit.fontframe.setVisible(true);
        Edit.fontframe.setResizable(false);
    }
    @Override
    public void format(){
        Edit.selectedFont = Edit.combobox.getSelectedItem().toString().toUpperCase();
        Font selectedFontObj = new Font(Edit.selectedFont, Font.PLAIN, (int) Edit.textSize);
        Edit.pane.setFont(selectedFontObj);
        Edit.fontframe.dispose();
        switch(Edit.selectedFont){
            case "BOLD":{
                bold b1 = new bold();
                b1.format();
                break;
            }
            case "PLAIN":{
                plain p1 = new plain();
                p1.format();
                break;
            }
            case "ITALICS":{
                italic i1 = new italic();
                i1.format();
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Edit.dp.format();
        Edit.fontframe.setVisible(false);
    }
}

class bold implements abstractDecorator{
    @Override
    public void format(){
        Font font = new Font(Edit.selectedFont, Font.BOLD, (int) Edit.textSize);
        Edit.pane.setFont(font);
    }
}

class italic implements abstractDecorator{
    @Override
    public void format(){
        Font font = new Font(Edit.selectedFont, Font.ITALIC, (int) Edit.textSize);
        Edit.pane.setFont(font);
    }
}

class plain implements abstractDecorator{
    @Override
    public void format(){
        Font font = new Font(Edit.selectedFont, Font.PLAIN, (int) Edit.textSize);
        Edit.pane.setFont(font);
    }
}

