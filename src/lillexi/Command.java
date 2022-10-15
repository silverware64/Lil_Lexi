package lillexi;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Command {
    public abstract void execute(Window window) throws IOException;
}

class QuitCommand extends Command {

    public void execute(Window window) {
        window.dispose();
    }
}

class NewFileCommand extends Command {

    public void execute(Window window) {
        Window.glyphs = new ArrayList<>();
        Window.cursor_position = 0;
        Window.glyphs.add(new CursorGlyph(window));
        window.redraw();
    }
}

class RedoCommand extends Command {
    public void execute(Window window) {
        Window.undo_list = Window.glyphs;
        Window.glyphs = Window.redo_list;
        window.redraw();
    }
}

class UndoCommand extends Command {
    public void execute(Window window) {
        Window.redo_list = Window.glyphs;
        Window.glyphs = Window.undo_list;
        window.redraw();
    }
}

class InsertImageCommand extends Command {
    public void execute(Window window) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPG & GIF Images", "png", "jpg", "gif");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
            Window.glyphs.add(new ImageGlyph(window, chooser.getSelectedFile().toString()));
            window.redraw();
        }
    }
}

class InsertRectangleCommand extends Command {

    public void execute(Window window) {
        Window.glyphs.add(new RectangleGlyph(window, "src/lillexi/rectangle.png"));
        window.redraw();
    }
}

class BoldCommand extends Command {
    public void execute(Window window) {
        Window.selected_style = Font.BOLD;
    }
}

class ItalicsCommand extends Command {
    public void execute(Window window) {
        Window.selected_style = Font.ITALIC;
    }
}

class PlainCommand extends Command {
    public void execute(Window window) {
        Window.selected_style = Font.PLAIN;
    }
}

class DialogCommand extends Command {
    public void execute(Window window) {
        Window.selected_font = Font.DIALOG;
    }
}

class SanSerifCommand extends Command {
    public void execute(Window window) {
        Window.selected_font = Font.SANS_SERIF;
    }
}
