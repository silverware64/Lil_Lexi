import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

interface BaseComposite {
	Font courier20 = new Font("Courier", Font.BOLD, 20);
	Font courier36 = new Font("Helvetica", Font.BOLD, 36);
}

class Base implements BaseComposite {
	JFrame frame;
	JPanel north, editPane, status, image, tools, menu, east, west, padding_bottom;
	JPanel editarea2;


	public Base() {
		frame = new JFrame("Document Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public JPanel addComposite() {
		// Creating required JPanels and JLabels and setting text colors
		north = new JPanel(new BorderLayout(5, 5));
		editPane = new JPanel();
		status = new JPanel(new BorderLayout(5, 5));
		image = new JPanel(new FlowLayout());
		tools = new JPanel(new BorderLayout(5, 5));
		east = new JPanel();
		west = new JPanel();
		menu = new JPanel(new BorderLayout(5, 5));
		padding_bottom = new JPanel();

		// Adding JPanel, JLabels to the JFrame with the default Border Layout
		frame.add(north, BorderLayout.NORTH);
		frame.add(editPane, BorderLayout.CENTER);
		frame.add(status, BorderLayout.SOUTH);
		frame.add(east, BorderLayout.EAST);
		frame.add(west, BorderLayout.WEST);
		north.add(image, BorderLayout.NORTH);
		north.add(menu, BorderLayout.SOUTH);
		menu.add(tools, BorderLayout.CENTER);

		// Setting the layout of the 'tools' JPanel
		tools.setLayout(new BoxLayout(tools, BoxLayout.X_AXIS));

		// Setting preferred size of each component
		image.setPreferredSize(new Dimension(500, 100));
		tools.setPreferredSize(new Dimension(500, 100));
		editPane.setPreferredSize(new Dimension(800, 800));
		east.setPreferredSize(new Dimension(200, 100));
		west.setPreferredSize(new Dimension(200, 100));

		// Setting opacity of each component
		padding_bottom.setOpaque(false);
		menu.setOpaque(false);
		tools.setOpaque(false);
		east.setOpaque(false);
		west.setOpaque(false);
		status.setOpaque(false);
		image.setOpaque(false);
		editPane.setOpaque(false);
		north.setOpaque(false);

		return tools;
	}

	public JPanel addLeaf() {
		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		menubar.add(file);
		editarea2 = new JPanel();
		editarea2.setPreferredSize(new Dimension(600, 600));
		editarea2.setBackground(Color.white);
		JScrollPane scroll = new JScrollPane(editarea2);

		JMenuItem open = new JMenuItem("Open");
		file.add(open);
		open.addActionListener(ae -> {

		});

		JMenuItem neww = new JMenuItem("New");
		file.add(neww);
		neww.addActionListener(ae -> {

		});

		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		save.addActionListener(ae -> {

		});

		JMenuItem saveas = new JMenuItem("Save As");
		file.add(saveas);
		saveas.addActionListener(ae -> save());
		JMenuItem quit = new JMenuItem("Quit");
		file.add(quit);
		quit.addActionListener(ae -> frame.dispose());

		JMenu edit = new JMenu("Edit");
		menubar.add(edit);

		JMenuItem undo = new JMenuItem("Undo");
		edit.add(undo);
		undo.addActionListener(ae -> {
		});
		JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());

		cut.setText("Cut");
		edit.add(cut);
		JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());

		copy.setText("Copy");
		edit.add(copy);
		JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());

		paste.setText("Paste");
		edit.add(paste);
		JRootPane root = image.getRootPane();
		root.setJMenuBar(menubar);
		JRootPane root2 = editPane.getRootPane();
		root2.getContentPane().add(scroll);
		editPane.setVisible(true);
		return editarea2;
	}

	// Method to perform the save as operation on the text
	public void save() {

	}
}

	public class LilLexiUI {

		private Base base;

		public void start() {
			// Instantiating the Base class in the Composite Design Pattern
			 this.base = new Base();

			// Collecting objects of JPanel & JTextPane
			JPanel p = base.addComposite();
			JPanel t = base.addLeaf();
		}

		public void update() {
			base.frame.pack();
		}
	}
