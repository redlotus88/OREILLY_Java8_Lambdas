package cn.stsniper.ch08.command;

/**
 * The Class Save.
 * Ex8-3 保存操作代理给Editor方法
 *
 * @author W.Dragon
 * @since 2016-1-30 22:51:49
 */
public class Save implements Action {

	private final Editor editor;
	
	public Save(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		editor.save();
	}

}
