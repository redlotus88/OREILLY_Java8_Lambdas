package cn.stsniper.ch08.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Moon.
 *
 * @author W.Dragon
 * @since 2016-2-12 14:06:50
 */
public class Moon {
	
	private final List<LandingObserver> observers = new ArrayList<>();
	
	public void land(String name) {
		for (LandingObserver observer : observers) {
			observer.observeLanding(name);
		}
	}
	
	public void startSpying(LandingObserver observer) {
		observers.add(observer);
	}
	
}
