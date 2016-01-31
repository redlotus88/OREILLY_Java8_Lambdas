package cn.stsniper.ch08.command;

/**
 * The Class Close.
 *
 * @author W.Dragon
 * @since 2016-1-30 22:43:48
 */
public class Close implements Action{

	private final Editor editor;
	
	public Close(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		editor.close();
	}

}
