package lillexi;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

class Singleton {
    private static final Singleton o = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return o;
    }

    void cut() {
        Glyph.pane.cut();
    }

    void copy() {
        Glyph.pane.copy();
    }

    void copyAll() {
        String text = Glyph.pane.getText();
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = defaultToolkit.getSystemClipboard();
        clipboard.setContents(new StringSelection(text), null);
    }

    void paste() {
        Glyph.pane.paste();
    }
}

