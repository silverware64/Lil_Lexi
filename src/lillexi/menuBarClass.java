package lillexi;

import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lillexi.Edit.pane;

interface Menu {
    void getMenu(Object choosemenu);
}

public class menuBarClass {
    Menu menu;

    menuBarClass(String data) {
        if (data.equals("File")) {
            menu = new File1();
        }
        if (Edit.choosemenu == Edit.save) {
            menu.getMenu(Edit.choosemenu);
        } else if (Edit.choosemenu == Edit.load) {
            menu.getMenu(Edit.choosemenu);
        } else if (Edit.choosemenu == Edit.print) {
            menu.getMenu(Edit.choosemenu);
        } else if (Edit.choosemenu == Edit.Quit) {
            menu.getMenu(Edit.choosemenu);
        } else if (Edit.choosemenu == Edit.about) {
            menu.getMenu(Edit.choosemenu);
        }
    }
}

class File1 implements Menu {
    File1() {
    }

    @Override
    public void getMenu(Object choosemenu) {
        if (choosemenu == Edit.save) {
            Save save = new Save();
        } else if (choosemenu == Edit.load) {
            Load load = new Load();
        } else if (choosemenu == Edit.print) {
            Print print = new Print();
        } else if (choosemenu == Edit.Quit) {
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
                Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
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
            Edit.pane.print();
        } catch (Exception evt) {
            JOptionPane.showMessageDialog(Edit.frame, evt.getMessage());
        }
    }
}

class Quit extends File1 {
    Quit() {
        Edit.frame.dispose();
    }
}
