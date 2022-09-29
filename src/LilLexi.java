/**
 * Lil Lexi Document Editor
 * 
 */

public class LilLexi
{
	static private LilLexiDoc currentDoc = null;

	public static void main(String args[])
	{
		LilLexiUI window = new LilLexiUI();
		window.start();
		window.update();

	}
}


