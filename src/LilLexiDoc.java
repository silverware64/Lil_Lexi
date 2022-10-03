/**
 * Lil Lexi Document Model
 *
 */
import java.util.List;
import java.util.ArrayList;

/**
 * LilLexiDoc
 */
public class LilLexiDoc {
	private LilLexiUI window;
	private List<Glyph> glyphs;
	private int curr_index;
	private int max_index;
	/**
	 * Ctor
	 */
	public LilLexiDoc() {
		glyphs = new ArrayList<Glyph>();
		max_index = 0;
		curr_index = max_index;
	}

	public void setWindow(LilLexiUI window) {
		this.window = window;
	}

	public int getIndex() {
		return curr_index;
	}

	/**
	 * add a glyph
	 */
	public void add(char c) {
		glyphs.add(new CharGlyph(Character.toString(c)));
		window.write();
		window.update();
		max_index++;
		curr_index++;
	}

	public void left(){
		if (curr_index > 0){
			curr_index--;
		}
	}

	public void right(){
		if (curr_index < max_index){
			curr_index++;
		}
	}

	public void remove(){
		window.delete();
		glyphs.remove(curr_index-1);
		curr_index--;
		max_index--;
	}

	/**
	 * gets
	 */
	public List<Glyph> getGlyphs(){return glyphs;}
}
/**
 * Glyph
 */
