package lillexi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.Random;

public abstract class Command {
    public abstract void execute(Window window);
}

class QuitCommand extends Command {

    public void execute(Window window){
        window.dispose();
    }
}

class RedoCommand extends Command{
    public void execute(Window window){}
}

class UndoCommand extends Command{
    public void execute(Window window){}
}

class InsertImageCommand extends Command {
    public void execute(Window window){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPG & GIF Images", "png", "jpg", "gif");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {

            new ImageGlyph(chooser.getSelectedFile().toString());
        }
    }
}

class InsertRectangleCommand extends Command{

    public void execute(Window window) {

    }
}

class BoldCommand extends Command {
    public void execute(Window window){
        window.selected_style = Font.BOLD;
    }
}

class ItalicsCommand extends Command {
    public void execute(Window window){
        window.selected_style = Font.ITALIC;
    }
}

class PlainCommand extends Command {
    public void execute(Window window){
        window.selected_style = Font.PLAIN;
    }
}

class DialogCommand extends Command {
    public void execute(Window window) {
        window.selected_font = Font.DIALOG;
    }
}
class SanSerifCommand extends Command {
    public void execute(Window window) {
        window.selected_font = Font.SANS_SERIF;
    }
}
