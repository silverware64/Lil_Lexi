package lillexi;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

class Singleton
{
private static Singleton o =new Singleton();
    private Singleton()
    {}
    
   public static Singleton getInstance(){
      return o;
   } 
    
void cut()
{
    Edit.pane.cut();
}

void copy()
{
    Edit.pane.copy();
}

void copyAll()
{
    String text = Edit.pane.getText().toString();
    Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = defaultToolkit.getSystemClipboard();
    clipboard.setContents(new StringSelection(text), null);
}

void paste()
{
    Edit.pane.paste();
   }
}

