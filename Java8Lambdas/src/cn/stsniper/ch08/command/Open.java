package cn.stsniper.ch08.command;

/**
 * The Class Open.
 *
 * @author W.Dragon
 * @since 2016-1-30 22:42:41
 */
public class Open implements Action {

	private final Editor editor;
	
	public Open(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		editor.open();
	}

}
