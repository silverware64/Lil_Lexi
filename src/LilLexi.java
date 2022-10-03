import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Lil Lexi Document Editor
 *
 */

public class LilLexi {
	static private LilLexiDoc currentDoc;
	static private LilLexiUI window;
	public static void main(String args[])	{
		window = new LilLexiUI();
		currentDoc = new LilLexiDoc();
		window.setDoc(currentDoc);
		currentDoc.setWindow(window);
		window.start(); // Works with Tobin's Windows system
		window.update();


		//window.toString(); // Works with Nicholas' Mac system
	}


}


