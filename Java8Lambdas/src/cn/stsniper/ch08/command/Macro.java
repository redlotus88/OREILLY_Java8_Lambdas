package cn.stsniper.ch08.command;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Macro.
 * Ex8-5 包含操作序列的宏，可按顺序执行操作
 *
 * @author W.Dragon
 * @since 2016-1-30 22:44:24
 */
public class Macro {
	
	private final List<Action> actions;
	
	public Macro() {
		actions = new ArrayList<>();
	}
	
	public void record(Action action) {
		actions.add(action);
	}
	
	public void run() {
		actions.forEach(Action::perform);
	}
}
