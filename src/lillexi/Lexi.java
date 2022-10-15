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

    static int cursor_position;
    static JMenuItem  quit, newfile, san_serif, dialog, bold, plain, italic,
            insertimg, insertrec, undo, redo;


    static int selected_size = 12;
    static String selected_font = Font.DIALOG;

    static int selected_style = Font.PLAIN;

    static List<Glyph> glyphs, undo_list,redo_list;


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

        cursor_position =0;

        glyphs = new ArrayList<>();
        redo_list = new ArrayList<>();
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

        if(e.getKeyCode() == 8) {
            if (cursor_position > 0) {
                undo_list = new ArrayList<>(glyphs);
                glyphs.remove(cursor_position - 1);
                cursor_position--;
                this.redraw();
            }
            this.redraw();
        }else if(e.getKeyCode() == 37) {
            if (cursor_position > 0) {
                Glyph temp = glyphs.get(cursor_position);
                glyphs.set(cursor_position,new CursorGlyph(this));
                glyphs.set(cursor_position+1,temp);
                cursor_position--;
                this.redraw();
            }
        } else if (e.getKeyCode() == 39) {
            if(cursor_position < this.glyphs.size()){
                Glyph temp = glyphs.get(cursor_position);
                glyphs.set(cursor_position,new CursorGlyph(this));
                glyphs.set(cursor_position+1,temp);
                cursor_position++;
                this.redraw();
            }
        } else {
            CharacterGlyph g = new CharacterGlyph(this, Character.toString(e.getKeyChar()));
            undo_list = new ArrayList<>(glyphs);
            glyphs.add(g);
            cursor_position++;
            this.redraw();
        }
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
