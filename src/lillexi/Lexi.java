package lillexi;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

class Window extends JFrame implements KeyListener {
    static JPanel panel;
    static Container cp;

    static JScrollPane scrollpane;
    static JMenuBar menuBar;
    static JMenu file, edit, style, symbol;

    static JLabel cursor;
    static JMenuItem  quit, newfile, san_serif, dialog, bold, plain, italic,
            insertimg, insertrec, undo, redo;


    static int selected_size = 12;
    static int selected_glyph;

    static int page_height;
    static String selected_font = Font.DIALOG;

    static int selected_style;
    static List<Glyph> glyphs;


    Window() throws BadLocationException {
        this.setTitle("LIL LEXI EDITOR");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(Color.white);
        panel.setMaximumSize(new Dimension(600,500));
        getContentPane().add(panel);
        scrollpane = new JScrollPane(panel);
        getContentPane().add(scrollpane,BorderLayout.CENTER);



        Menu menu = new Menu(this);
        menu.draw(0,0);
        menuBar.setVisible(true);
        this.setJMenuBar(menu.getContent());

        this.setMinimumSize(new Dimension(1100,600));

        this.setVisible(true);

        this.cursor = new JLabel("|");
        cursor.setForeground(Color.BLUE);
        cursor.setBounds(0,0,5,10);
        this.add(cursor);
        this.panel.add(cursor);

        page_height = 750;

        selected_glyph =0;

        glyphs = new ArrayList<>();
        addKeyListener(this);
        this.pack();

    }

    public void redraw(){
        this.panel.removeAll();
        int x = 0;
        int y = 0;
        for (int i = 0; i < this.glyphs.size(); i++) {
            x += glyphs.get(i).getWidth();
            glyphs.get(i).draw(x%600,x/600);
        }
        this.pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Rectangle bounds_c = this.cursor.getBounds();

        if(e.getKeyCode() == 8) {
            this.cursor.setBounds(bounds_c.x+bounds_c.width,bounds_c.y,5,15);
        }else if(e.getKeyCode() == 37) {
            if (selected_glyph > 0) {
                int shift = this.glyphs.get(selected_glyph).getWidth();
                this.cursor.setBounds(bounds_c.x-shift,bounds_c.y,5,15);
                selected_glyph--;
            }
        } else if (e.getKeyCode() == 39) {
            if(selected_glyph < this.glyphs.size()){
                int shift = this.glyphs.get(selected_glyph).getWidth();
                this.cursor.setBounds(bounds_c.x+shift,bounds_c.y,5,15);
                selected_glyph++;
            }
        } else {
            CharacterGlyph g = new CharacterGlyph(this, Character.toString(e.getKeyChar()));
            glyphs.add(g);
            this.redraw();
        }
        if(bounds_c.x >= this.panel.getBounds().width){
            this.cursor.setBounds(0,bounds_c.y+20,5,15);
            if(bounds_c.y > this.page_height){
                this.page_height+=750;
                JLabel line_break = new JLabel("[END PAGE]----------------------------------------------------------------");
                line_break.setBounds(0,bounds_c.y+20,800,20);
                this.add(line_break);
                this.panel.add(line_break);
                this.cursor.setBounds(0,bounds_c.y+40,20,20);
            }
        }
        this.pack();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public Font getCurrentFont(){
        return new Font(this.selected_font, this.selected_style, this.selected_size);
    }


}

public class Lexi {

    static Window w;

    @SuppressWarnings({"UseSpecificCatch", "Convert2Lambda"})

    public static void main(String[] args) throws BadLocationException {
        w = new Window();
    }

}
