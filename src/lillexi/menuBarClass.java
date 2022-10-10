package lillexi;

import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lillexi.Glyph.pane;

interface Menu {
    void getMenu(Object choosemenu);
}

public class menuBarClass {
    Menu menu;

    menuBarClass(String data) {
        if (data.equals("File")) {
            menu = new File1();
        }
        if (Glyph.choosemenu == Glyph.save) {
            menu.getMenu(Glyph.choosemenu);
        } else if (Glyph.choosemenu == Glyph.load) {
            menu.getMenu(Glyph.choosemenu);
        } else if (Glyph.choosemenu == Glyph.print) {
            menu.getMenu(Glyph.choosemenu);
        } else if (Glyph.choosemenu == Glyph.Quit) {
            menu.getMenu(Glyph.choosemenu);
        } else if (Glyph.choosemenu == Glyph.about) {
            menu.getMenu(Glyph.choosemenu);
        }
    }
}

class File1 implements Menu {
    File1() {
    }

    @Override
    public void getMenu(Object choosemenu) {
        if (choosemenu == Glyph.save) {
            Save save = new Save();
        } else if (choosemenu == Glyph.load) {
            Load load = new Load();
        } else if (choosemenu == Glyph.print) {
            Print print = new Print();
        } else if (choosemenu == Glyph.Quit) {
            Quit quit = new Quit();
        }
    }
}

class Load extends File1 {
    Load() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String result = "", c;
            try {
                File file1 = fileChooser.getSelectedFile();
                System.out.println("File Loaded");
                FileReader read = new FileReader(file1);
                BufferedReader reader = new BufferedReader(read);
                while ((c = reader.readLine()) != null) {
                    result = result + c + "\r\n";
                }
                read.close();
                pane.setText(result);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Glyph.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Glyph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

final class Save extends File1 {
    Save() {
        saveMap();
    }

    public void saveMap() {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Users"));
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                try (FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".doc")) {
                    fw.write(pane.getText());
                }
            } catch (IOException ex) {
            }
        }
    }
}

class Print extends File1 {
    Print() {
        try {
            Glyph.pane.print();
        } catch (Exception evt) {
            JOptionPane.showMessageDialog(Glyph.frame, evt.getMessage());
        }
    }
}

class Quit extends File1 {
    Quit() {
        Glyph.frame.dispose();
    }
}
