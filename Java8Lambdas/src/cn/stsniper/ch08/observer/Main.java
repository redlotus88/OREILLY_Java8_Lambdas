package cn.stsniper.ch08.observer;

/**
 * The Class Main.
 *
 * @author W.Dragon
 * @since 2016-2-12 14:13:23
 */
public class Main {
	
	public static void main(String[] args) {
		Moon moon = new Moon();
		// Ex8-19 使用类的方式构建用户代码
		moon.startSpying(new Nasa());
		moon.startSpying(new Aliens());
		
		moon.land("An asteroid");
		moon.land("Apollo 11");

		// Ex8-20 使用Lambda表达式构建用户代码
		moon.startSpying(name -> {
			if (name.contains("Apollo"))
				System.out.println("We made it!");
		});
		
		moon.startSpying(name -> {
			if (name.contains("Apollo"))
				System.out.println("They're distracted, lets invade earth!");
		});
		moon.land("An asteroid");
		moon.land("Apollo 11");
	}
}
