package cn.stsniper.ch08.observer;

/**
 * The Class Aliens.
 *
 * @author W.Dragon
 * @since 2016-2-12 14:08:25
 */
public class Aliens implements LandingObserver {
	
	@Override
	public void observeLanding(String name) {
		if (name.contains("Apollo")) {
			System.out.println("They're distracted, lets invade earth!");
		}
	}
}
