package lillexi;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/*
Date: 14 Oct 2022
Author: Nicholas Bell
Purpose: The purpose of the Command class is the backend stuff after a user clicks on a command in the menu bar.
 */
public abstract class Command {
    public abstract void execute(Window window) throws IOException;
}

// This class executes the Quit Command that is inherited from the Command class.
class QuitCommand extends Command {
    public void execute(Window window) {
        window.dispose();
    }
}

// This class executes the New File Command that is inherited from the Command class.
class NewFileCommand extends Command {
    public void execute(Window window) {
        window.newFile();
        window.redraw();
    }
}

// This class executes the Redo Command that is inherited from the Command class.
class RedoCommand extends Command {
    public void execute(Window window) {
        Window.setRedo( Window.getGlyphs());
        Window.Redo();
        window.redraw();
    }
}

// This class executes the Undo Command that is inherited from the Command class.
class UndoCommand extends Command {
    public void execute(Window window) {
        Window.setUndo(window.getGlyphs());
        Window.Undo();
        window.redraw();
    }
}

// This class executes the Insert Image that is inherited from the Command class.
class InsertImageCommand extends Command {
    public void execute(Window window) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPG & GIF Images", "png", "jpg", "gif");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
            Window.addGlyph(new ImageGlyph(window, chooser.getSelectedFile().toString()));
            window.redraw();
        }
    }
}

// This class executes the Insert Rectangle Command that is inherited from the Command class.
class InsertRectangleCommand extends Command {

    public void execute(Window window) {
        Window.addGlyph(new RectangleGlyph(window, "src/lillexi/rectangle.png"));
        window.redraw();
    }
}

// This class executes the Bold Command that is inherited from the Command class.
// It makes the character glyphs bold.
class BoldCommand extends Command {
    public void execute(Window window) {
        Window.selected_style = Font.BOLD;
    }
}

// This class executes the Italics Command that is inherited from the Command class.
// It makes the character glyphs italics.
class ItalicsCommand extends Command {
    public void execute(Window window) {
        Window.selected_style = Font.ITALIC;
    }
}

// This class executes the Italics Command that is inherited from the Command class.
// It makes the character glyphs plain.
class PlainCommand extends Command {
    public void execute(Window window) {
        Window.selected_style = Font.PLAIN;
    }
}

// This class executes the Dialog Command that is inherited from the Command class.
class DialogCommand extends Command {
    public void execute(Window window) {
        Window.selected_font = Font.DIALOG;
    }
}
// This class executes the San Serif Command that is inherited from the Command class.
// When the user selects San Serif, the text should show as San Serif.
class SanSerifCommand extends Command {
    public void execute(Window window) {
        Window.selected_font = Font.SANS_SERIF;
    }
}
class Font1Command extends Command {
    public void execute(Window window) {
        Window.selected_size = 12;
    }
}

class Font2Command extends Command {
    public void execute(Window window) {
        Window.selected_size = 16;
    }
}

class Font3Command extends Command {
    public void execute(Window window) {
        Window.selected_size = 20;
    }
}