package cn.stsniper.ch04;

/**
 * The Class Part7_MultipleInheritance.
 * 
 * @author W.Dragon
 * @since 2016-1-10 23:14:23
 * @version 0.0.1-SNAPSHOT
 */
public class Part7_MultipleInheritance {
	
}

// Ex4-19
interface Jukebox {
	
	default String rock() {
		return "... all over the world!";
	}
}

// Ex4-20
interface Carriage {
	default String rock() {
		return "... from side to side";
	}
}

class MusicalCarriage implements Carriage, Jukebox {

	// 增强的super语法
	@Override
	public String rock() {
		return Carriage.super.rock();
	}
	
}
