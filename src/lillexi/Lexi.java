package lillexi;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

class Window extends JFrame implements KeyListener {
    static JPanel panel;
    static Container cp;

    static JScrollPane scrollpane;
    static JMenuBar menuBar;
    static JMenu file, edit, style, symbol;

    static int cursor_position;
    static JMenuItem  quit, newfile, san_serif, dialog, bold, plain, italic,
            insertimg, insertrec, undo, redo, font1, font2, font3, spellcheck;


    static int selected_size = 12;
    static String selected_font = Font.DIALOG;

    static int selected_style = Font.PLAIN;
    static Set<String> dictionary;

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

        this.setMinimumSize(new Dimension(1500,1000));

        this.setVisible(true);

        cursor_position =0;

        glyphs = new ArrayList<>();
        glyphs.add(new CursorGlyph(this));
        redo_list = new ArrayList<>();
        undo_list = new ArrayList<>();
        addKeyListener(this);
        this.pack();
        Scanner s = null;
        try {
            s = new Scanner(new File("src/wordlist.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        dictionary = new HashSet<>();
        while (s.hasNext()) {
            dictionary.add(s.nextLine());
        }
    }

    public boolean inDictionary(String s){
        return dictionary.contains(s);
    }

    public void redraw(){
        this.panel.removeAll();
        int x = 0;
        int y = 0;
        for (int i = 0; i < this.glyphs.size(); i++) {
            x += glyphs.get(i).getWidth();
            glyphs.get(i).draw(x%600+10,x/600*20);
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
                Glyph temp = glyphs.get(cursor_position-1);
                glyphs.set(cursor_position-1,new CursorGlyph(this));
                glyphs.set(cursor_position,temp);
                cursor_position--;
                this.redraw();
            }
        } else if (e.getKeyCode() == 39) {
            if(cursor_position < this.glyphs.size()-1){
                Glyph temp = glyphs.get(cursor_position+1);
                glyphs.set(cursor_position+1,new CursorGlyph(this));
                glyphs.set(cursor_position,temp);
                cursor_position++;
                this.redraw();
            }
        } else {
            CharacterGlyph g = new CharacterGlyph(this, Character.toString(e.getKeyChar()));
            this.undo_list = new ArrayList<>(glyphs);
            cursor_position++;
            glyphs.add(cursor_position-1,g);
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
