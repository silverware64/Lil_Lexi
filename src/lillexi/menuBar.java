package lillexi;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lillexi.Edit.menuBar;
import static lillexi.Edit.*;

public class menuBar implements ActionListener {

    menuBar() {
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        Edit.file = new JMenu(" File");

        Edit.tools = new JMenu("     Tools");

        Edit.load = new JMenuItem("Load File");
        Edit.save = new JMenuItem("Save File");
        Edit.print = new JMenuItem("Print File");
        Edit.Quit = new JMenuItem("Quit");
        Edit.imgopt = new JMenu("     Image");

        Edit.fontopt = new JMenu("     Font");
        Edit.fontsize = new JMenuItem("Font Size");
        Edit.backgroundcolor = new JMenuItem("Background Color");
        Edit.newfile = new JMenuItem("New ");
        Edit.fontcolor = new JMenuItem("Font Color");
        Edit.fontstyle = new JMenuItem("Font Style");
        Edit.fontface = new JMenuItem("Font Face");

        Edit.removeimg = new JMenuItem("Remove Image");
        Edit.insertimg = new JMenuItem("Insert Image");
        Edit.copyall = new JMenuItem("Copy All");
        Edit.paste = new JMenuItem("Paste");
        Edit.cut = new JMenuItem("Cut");
        Edit.copy = new JMenuItem("Copy");

        Edit.options = new JMenu("    Options");
        Edit.undo = new JMenuItem("Undo");
        Edit.redo = new JMenuItem("Redo");

        Edit.load.addActionListener(this);
        Edit.save.addActionListener(this);
        Edit.Quit.addActionListener(this);

        Edit.fontsize.addActionListener(this);
        Edit.backgroundcolor.addActionListener(this);
        Edit.fontcolor.addActionListener(this);
        Edit.fontstyle.addActionListener(this);
        Edit.fontface.addActionListener(this);

        Edit.removeimg.addActionListener(this);
        Edit.insertimg.addActionListener(this);

        Edit.tools.addActionListener(this);
        Edit.print.addActionListener(this);
        Edit.newfile.addActionListener(this);
        Edit.cut.addActionListener(this);
        Edit.copy.addActionListener(this);
        Edit.copyall.addActionListener(this);
        Edit.paste.addActionListener(this);

        Edit.undo.addActionListener(new UndoActionListener(UndoActionListener.UndoActionType.UNDO));
        Edit.redo.addActionListener(new UndoActionListener(UndoActionListener.UndoActionType.REDO));

        Edit.menuBar.add(Edit.file);
        Edit.file.add(Edit.load);
        Edit.file.add(Edit.save);
        Edit.file.add(Edit.print);
        Edit.file.add(Edit.newfile);
        Edit.file.add(Edit.Quit);

        Edit.menuBar.add(Edit.fontopt);
        Edit.fontopt.add(Edit.fontcolor);
        Edit.fontopt.add(Edit.fontstyle);
        Edit.fontopt.add(Edit.fontface);
        Edit.fontopt.add(Edit.fontsize);
        Edit.fontopt.add(Edit.backgroundcolor);

        Edit.menuBar.add(Edit.imgopt);
        Edit.imgopt.add(Edit.insertimg);
        Edit.imgopt.add(Edit.removeimg);

        Edit.menuBar.add(Edit.tools);
        Edit.tools.add(Edit.cut);
        Edit.tools.add(Edit.copy);
        Edit.tools.add(Edit.copyall);
        Edit.tools.add(Edit.paste);

        Edit.menuBar.add(Edit.options);
        Edit.options.add(Edit.undo);
        Edit.options.add(Edit.redo);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        choosemenu = e.getSource();
        Singleton object = Singleton.getInstance();
        if (choosemenu == Edit.save) {
            menuBarClass menubarclass = new menuBarClass("File");
        }
        if (choosemenu == Edit.load) {
            menuBarClass menubarclass = new menuBarClass("File");
        }
        if (choosemenu == Edit.print) {
            menuBarClass menubarclass = new menuBarClass("File");
        }
        if (choosemenu == Edit.Quit) {
            menuBarClass menubarclass = new menuBarClass("File");
        }


        // Strategy design pattern (strategy.java)
        if (choosemenu == Edit.insertimg) {
            strategy strategy = new strategy("Insert Image", c);
        }
        if (choosemenu == Edit.removeimg) {
            strategy strategy = new strategy("Remove Image", c);
        }


        // Decorator design pattern (decorator.java)
        if (choosemenu == Edit.fontstyle) {
            dp = new DecoratorPattern();
        }

        if (choosemenu == Edit.fontsize || choosemenu == Edit.backgroundcolor ||
                choosemenu == Edit.fontcolor || choosemenu == Edit.fontface) {
            FactoryMaker fm = new FactoryMaker();
            FactoryMaker.getFactory(choosemenu);
        }


        if (choosemenu == Edit.fontstyle) {
            dp = new DecoratorPattern();
        }

        // Singleton design pattern (singleton.java)
        if (choosemenu == Edit.cut) {

            object.cut();
        }
        if (choosemenu == Edit.copy) {
            object.copy();

        }
        if (choosemenu == Edit.copyall) {
            object.copyAll();
        }
        if (choosemenu == Edit.paste) {
            object.paste();
        }
        if (choosemenu == Edit.newfile) {
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

                    Edit.pane.requestFocusInWindow();
                    return; // no edits to undo
                }

                undoMgr__.undo();
                break;

            case REDO:
                if (!undoMgr__.canRedo()) {

                    Edit.pane.requestFocusInWindow();
                    return; // no edits to redo
                }

                undoMgr__.redo();
        }

        Edit.pane.requestFocusInWindow();
    }

    enum UndoActionType {UNDO, REDO}
}