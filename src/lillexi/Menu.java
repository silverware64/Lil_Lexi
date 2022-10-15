package lillexi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends Glyph{

    private JMenuBar content;

    public Menu(Window w){
        window = w;

    }

    public void draw(int x, int y) {
        content = new JMenuBar();
        window.menuBar = content;
        Edit edit = new Edit(window);
        window.menuBar.add(edit.getContent());
        Symbol symbol = new Symbol(window);
        window.menuBar.add(symbol.getContent());
        File file = new File(window);
        window.menuBar.add(symbol.getContent());
        Style style = new Style(window);
        window.menuBar.add(symbol.getContent());
        content.add(file.getContent());
        content.add(style.getContent());
        content.add(edit.getContent());
        content.add(symbol.getContent());
    }

    public JMenuBar getContent() {
        return content;
    }
}

class Symbol extends Glyph{

    private JMenu content;

    public Symbol(Window w){
        window = w;
        content = new JMenu("     Symbol");
        window.symbol = content;
        window.insertimg = new JMenuItem(new AbstractAction("Insert Image") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertImageCommand().execute(window);
            }
        });
        content.add(window.insertimg);

        window.symbol = content;
        window.insertrec = new JMenuItem(new AbstractAction("Insert Rectangle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertRectangleCommand().execute(window);
            }
        });
        content.add(window.insertrec);
    }
    public void draw(int x, int y) {

    }

    public JMenu getContent() {
        return content;
    }
}

class File extends Glyph {

    private JMenu content;

    public File(Window w) {
        window = w;
        content = new JMenu("     File");
        window.file = content;
        window.quit = new JMenuItem(new AbstractAction("Quit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuitCommand().execute(window);
            }
        });
        content.add(window.quit);
        window.newfile = new JMenuItem("New File");
        content.add(window.newfile);
    }
    public void draw(int x, int y){

    }

    public JMenu getContent() {
        return content;
    }
}

class Edit extends Glyph{
    private JMenu content;
    public Edit(Window w){
        window = w;
        content = new JMenu("    Edit");
        window.edit = content;
        content.add(window.edit);
        window.redo = new JMenuItem(new AbstractAction("Redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RedoCommand().execute(window);
            }
        });
        content.add(window.redo);
        window.undo = new JMenuItem(new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UndoCommand().execute(window);
            }
        });
        content.add(window.undo);

    }

    public void draw(int x, int y) {

    }

    public JMenu getContent() {
        return content;
    }
}

class Style extends Glyph{
    private JMenu content;
    public Style(Window w){
        this.window = w;
        window.style = new JMenu("     Style");

        content = window.style;
        window.dialog = new JMenuItem(new AbstractAction("Dialog") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCommand().execute(window);
            }
        });
        window.dialog.setFont(new Font(Font.DIALOG, Font.PLAIN,12));
        content.add(window.dialog);
        window.bold = new JMenuItem(new AbstractAction("Bold") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BoldCommand().execute(window);
            }
        });
        window.bold.setFont(new Font(Font.DIALOG, Font.BOLD,12));
        content.add(window.bold);
        window.italic = new JMenuItem(new AbstractAction("Italic") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ItalicsCommand().execute(window);
            }
        });
        window.italic.setFont(new Font(Font.DIALOG, Font.ITALIC,12));
        content.add(window.italic);
        window.plain = new JMenuItem(new AbstractAction("Plain") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlainCommand().execute(window);
            }
        });
        window.plain.setFont(new Font(Font.DIALOG, Font.PLAIN,12));
        content.add(window.plain);
        window.san_serif = new JMenuItem(new AbstractAction("Serif") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SanSerifCommand().execute(window);
            }
        });
        window.san_serif.setFont(new Font(Font.SERIF, Font.PLAIN,12));
        content.add(window.san_serif);

    }
    public void draw(int x, int y){
    }

    public JMenu getContent() {
        return content;
    }
}
