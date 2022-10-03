import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane(editPane);
	}

	public JPanel addComposite() {
		// Creating required JPanels and JLabels and setting text colors
		north = new JPanel(new BorderLayout(1, 1));
		editPane = new JPanel();
		status = new JPanel(new BorderLayout(1, 1));
		image = new JPanel(new FlowLayout());
		tools = new JPanel(new BorderLayout(1, 1));
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
		east.add(new Scrollbar(Scrollbar.VERTICAL, 0, 1, 800, 800));

		// Setting the layout of the 'tools' JPanel
		tools.setLayout(new BoxLayout(tools, BoxLayout.X_AXIS));

		// Setting preferred size of each component
		image.setPreferredSize(new Dimension(200, 100));
		editPane.setSize(new Dimension(850, 1100));
		east.setPreferredSize(new Dimension(10, 800));
		west.setPreferredSize(new Dimension(0, 800));

		// Setting opacity of each component
		padding_bottom.setOpaque(false);
		menu.setOpaque(false);
		east.setOpaque(true);
		west.setOpaque(false);
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
		open.addActionListener(ae -> {});

		JMenuItem neww = new JMenuItem("New");
		file.add(neww);
		neww.addActionListener(ae -> {});

		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		save.addActionListener(ae -> {});

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
		undo.addActionListener(ae -> {});

		JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
		cut.setText("Cut");
		edit.add(cut);

		JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
		copy.setText("Copy");
		edit.add(copy);

		JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
		paste.setText("Paste");
		edit.add(paste);

		JMenu style = new JMenu("Style");
		menubar.add(style);

		JMenuItem left = new JMenuItem("Align Left");
		style.add(left);
		left.addActionListener(ae -> {});

		JMenuItem center = new JMenuItem("Center");
		style.add(center);
		center.addActionListener(ae -> {});

		JMenuItem right = new JMenuItem("Align Right");
		style.add(right);
		right.addActionListener(ae -> {});
		style.add(new JSeparator());

		JMenuItem Courier = new JMenuItem("Courier");
		style.add(Courier);
		Courier.addActionListener(ae -> {});

		JMenuItem Helvetica = new JMenuItem("Helvetica");
		style.add(Helvetica);
		Helvetica.addActionListener(ae -> {});

		JMenuItem Arial = new JMenuItem("Arial");
		style.add(Arial);
		Arial.addActionListener(ae -> {
			getClass();
		});
		style.add(new JSeparator());

		JMenuItem fontSize1 = new JMenuItem("Font Size");
		style.add(fontSize1);
		fontSize1.addActionListener(ae -> {
		});

		JMenu symbol = new JMenu("Symbol");
		menubar.add(symbol);

		JMenuItem rectangle = new JMenu("Rectangle");
		symbol.add(rectangle);
		rectangle.addActionListener(ae -> {
			getClass();
		});

		JRootPane root = image.getRootPane();
		root.setJMenuBar(menubar);
		JRootPane root2 = editPane.getRootPane();
		root2.getContentPane().add(scroll);
		editPane.setVisible(true);
		return editarea2;
	}

	// Method to perform the save as operation on the text
	public void save() {}
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
