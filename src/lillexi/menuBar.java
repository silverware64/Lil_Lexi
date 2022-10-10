package lillexi;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lillexi.Glyph.menuBar;
import static lillexi.Glyph.*;

public class menuBar implements ActionListener {

    menuBar() {
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        Glyph.file = new JMenu(" File");

        Glyph.tools = new JMenu("     Tools");

        Glyph.load = new JMenuItem("Load File");
        Glyph.save = new JMenuItem("Save File");
        Glyph.print = new JMenuItem("Print File");
        Glyph.Quit = new JMenuItem("Quit");
        Glyph.imgopt = new JMenu("     Image");

        Glyph.fontopt = new JMenu("     Font");
        Glyph.fontsize = new JMenuItem("Font Size");
        Glyph.backgroundcolor = new JMenuItem("Background Color");
        Glyph.newfile = new JMenuItem("New ");
        Glyph.fontcolor = new JMenuItem("Font Color");
        Glyph.fontstyle = new JMenuItem("Font Style");
        Glyph.fontface = new JMenuItem("Font Face");

        Glyph.removeimg = new JMenuItem("Remove Image");
        Glyph.insertimg = new JMenuItem("Insert Image");
        Glyph.copyall = new JMenuItem("Copy All");
        Glyph.paste = new JMenuItem("Paste");
        Glyph.cut = new JMenuItem("Cut");
        Glyph.copy = new JMenuItem("Copy");

        Glyph.options = new JMenu("    Options");
        Glyph.undo = new JMenuItem("Undo");
        Glyph.redo = new JMenuItem("Redo");

        Glyph.load.addActionListener(this);
        Glyph.save.addActionListener(this);
        Glyph.Quit.addActionListener(this);

        Glyph.fontsize.addActionListener(this);
        Glyph.backgroundcolor.addActionListener(this);
        Glyph.fontcolor.addActionListener(this);
        Glyph.fontstyle.addActionListener(this);
        Glyph.fontface.addActionListener(this);

        Glyph.removeimg.addActionListener(this);
        Glyph.insertimg.addActionListener(this);

        Glyph.tools.addActionListener(this);
        Glyph.print.addActionListener(this);
        Glyph.newfile.addActionListener(this);
        Glyph.cut.addActionListener(this);
        Glyph.copy.addActionListener(this);
        Glyph.copyall.addActionListener(this);
        Glyph.paste.addActionListener(this);

        Glyph.undo.addActionListener(new UndoActionListener(UndoActionListener.UndoActionType.UNDO));
        Glyph.redo.addActionListener(new UndoActionListener(UndoActionListener.UndoActionType.REDO));

        Glyph.menuBar.add(Glyph.file);
        Glyph.file.add(Glyph.load);
        Glyph.file.add(Glyph.save);
        Glyph.file.add(Glyph.print);
        Glyph.file.add(Glyph.newfile);
        Glyph.file.add(Glyph.Quit);

        Glyph.menuBar.add(Glyph.fontopt);
        Glyph.fontopt.add(Glyph.fontcolor);
        Glyph.fontopt.add(Glyph.fontstyle);
        Glyph.fontopt.add(Glyph.fontface);
        Glyph.fontopt.add(Glyph.fontsize);
        Glyph.fontopt.add(Glyph.backgroundcolor);

        Glyph.menuBar.add(Glyph.imgopt);
        Glyph.imgopt.add(Glyph.insertimg);
        Glyph.imgopt.add(Glyph.removeimg);

        Glyph.menuBar.add(Glyph.tools);
        Glyph.tools.add(Glyph.cut);
        Glyph.tools.add(Glyph.copy);
        Glyph.tools.add(Glyph.copyall);
        Glyph.tools.add(Glyph.paste);

        Glyph.menuBar.add(Glyph.options);
        Glyph.options.add(Glyph.undo);
        Glyph.options.add(Glyph.redo);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        choosemenu = e.getSource();
        Singleton object = Singleton.getInstance();
        if (choosemenu == Glyph.save) {
            menuBarClass menubarclass = new menuBarClass("File");
        }
        if (choosemenu == Glyph.load) {
            menuBarClass menubarclass = new menuBarClass("File");
        }
        if (choosemenu == Glyph.print) {
            menuBarClass menubarclass = new menuBarClass("File");
        }
        if (choosemenu == Glyph.Quit) {
            menuBarClass menubarclass = new menuBarClass("File");
        }


        // Strategy design pattern (strategy.java)
        if (choosemenu == Glyph.insertimg) {
            strategy strategy = new strategy("Insert Image", c);
        }
        if (choosemenu == Glyph.removeimg) {
            strategy strategy = new strategy("Remove Image", c);
        }


        // Decorator design pattern (decorator.java)
        if (choosemenu == Glyph.fontstyle) {
            dp = new DecoratorPattern();
        }

        if (choosemenu == Glyph.fontsize || choosemenu == Glyph.backgroundcolor ||
                choosemenu == Glyph.fontcolor || choosemenu == Glyph.fontface) {
            FactoryMaker fm = new FactoryMaker();
            FactoryMaker.getFactory(choosemenu);
        }


        if (choosemenu == Glyph.fontstyle) {
            dp = new DecoratorPattern();
        }

        // Singleton design pattern (singleton.java)
        if (choosemenu == Glyph.cut) {

            object.cut();
        }
        if (choosemenu == Glyph.copy) {
            object.copy();

        }
        if (choosemenu == Glyph.copyall) {
            object.copyAll();
        }
        if (choosemenu == Glyph.paste) {
            object.paste();
        }
        if (choosemenu == Glyph.newfile) {
            try {
                prototype p32 = (prototype) Lexi.p.clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(menuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}


class UndoActionListener implements ActionListener {
    static UndoManager undoMgr__;
    private final UndoActionType undoActionType;

    public UndoActionListener(UndoActionType type) {

        undoActionType = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (undoActionType) {

            case UNDO:
                if (!undoMgr__.canUndo()) {

                    Glyph.pane.requestFocusInWindow();
                    return; // no edits to undo
                }

                undoMgr__.undo();
                break;

            case REDO:
                if (!undoMgr__.canRedo()) {

                    Glyph.pane.requestFocusInWindow();
                    return; // no edits to redo
                }

                undoMgr__.redo();
        }

        Glyph.pane.requestFocusInWindow();
    }

    enum UndoActionType {UNDO, REDO}
}