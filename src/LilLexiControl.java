/**
 * Controller
 */
public class LilLexiControl {
	private LilLexiDoc currentDoc;

	/**
	 * LilLexiControl
	 */
	public LilLexiControl( LilLexiDoc doc ) {
		this.currentDoc = doc;
	}

	/**
	 * quitEditor  user quits
	 */
	void  quitEditor() {
		System.exit(0);
	}
}





