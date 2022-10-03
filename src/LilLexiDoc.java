/**
 * Lil Lexi Document Model
 *
 */
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

/**
 * LilLexiDoc
 */
public class LilLexiDoc {
	private LilLexiUI window;
	private List<Glyph> glyphs;

	/**
	 * Ctor
	 */
	public LilLexiDoc() {
		glyphs = new ArrayList<Glyph>();
	}

	public void setWindow(LilLexiUI window) {
		this.window = window;
	}

	/**
	 * add a glyph
	 */
	public void add(char c) {
		glyphs.add(new CharGlyph(Character.toString(c)));
		window.update();
	}

	/**
	 * gets
	 */
	public List<Glyph> getGlyphs(){return glyphs;}
}
/**
 * Glyph
 */
