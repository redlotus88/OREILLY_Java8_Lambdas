package cn.stsniper.ch08.observer;

/**
 * The Class Nasa.
 *
 * @author W.Dragon
 * @since 2016-2-12 14:10:00
 */
public class Nasa implements LandingObserver {

	@Override
	public void observeLanding(String name) {
		if (name.contains("Apollo")) {
			System.out.println("We made it!");
		}
	}

}
