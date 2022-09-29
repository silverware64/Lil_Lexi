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
public class LilLexiDoc 
{
	private LilLexiUI ui;
	private List<Glyph> glyphs;
	
	/**
	 * Ctor
	 */
	public LilLexiDoc() 
	{
		glyphs = new ArrayList<Glyph>();
	}
	
	/**
	 * setUI
	 */
	public void setUI(LilLexiUI ui) {this.ui = ui;}

	/**
	 * add a char
	 */
	public void add(String s, JEditorPane window)
	{
		glyphs.add(new CharGlyph(window,s));
		ui.updateUI();
	}
	
	/**
	 * gets
	 */
	public List<Glyph> getGlyphs(){return glyphs;}
}




/**
 * Glyph
 */






