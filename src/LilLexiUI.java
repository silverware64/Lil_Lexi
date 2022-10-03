import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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


	}

	public JPanel addComposite() {
		// Creating required JPanels and JLabels and setting text colors
		editPane = new JPanel();
		status = new JPanel(new BorderLayout(5, 5));
		image = new JPanel(new FlowLayout());
		tools = new JPanel(new BorderLayout(5, 5));
		east = new JPanel();
		west = new JPanel();
		padding_bottom = new JPanel();

		// Adding JPanel, JLabels to the JFrame with the default Border Layout
		frame.add(editPane, BorderLayout.CENTER);
		frame.add(east, BorderLayout.EAST);
		frame.add(west, BorderLayout.WEST);
		frame.add(image, BorderLayout.NORTH);
		east.add(new Scrollbar());

		// Setting the layout of the 'tools' JPanel

		// Setting preferred size of each component
		image.setPreferredSize(new Dimension(500, 100));
		editPane.setSize(new Dimension(800, 800));
		editPane.setBackground(Color.white);
		east.setPreferredSize(new Dimension(200, 800));
		west.setPreferredSize(new Dimension(200, 100));

		// Setting opacity of each component
		padding_bottom.setOpaque(false);
		east.setOpaque(true);
		west.setOpaque(false);
		image.setOpaque(false);
		editPane.setVisible(true);


		return editPane;
	}

	public void addLeaf() {
		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		menubar.add(file);
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

		JMenuItem left = new JMenuItem(new DefaultEditorKit.InsertContentAction());
		left.setText("Align Left");
		edit.add(left);


		JMenu symbol = new JMenu("Symbol");
		menubar.add(symbol);


		JRootPane root = image.getRootPane();
		root.setJMenuBar(menubar);
		JRootPane root2 = editPane.getRootPane();
	}



	// Method to perform the save as operation on the text
	public void save() {

	}
}

	public class LilLexiUI {

		private Base base;
		private JPanel p;
		private LilLexiDoc doc;

		public void start() {
			// Instantiating the Base class in the Composite Design Pattern
			 this.base = new Base();

			// Collecting objects of JPanel & JTextPane
			p = base.addComposite();
			base.addLeaf();
			base.frame.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					doc.add(e.getKeyChar());
				}
			});

		}

		public void setDoc(LilLexiDoc doc) {
			this.doc = doc;
		}

		public void update() {
			p.removeAll();
			List<Glyph> list = doc.getGlyphs();
			for (Glyph g: list) {
				p.add(new Label(g.getContent()));
			}
			base.frame.pack();
		}

	}
