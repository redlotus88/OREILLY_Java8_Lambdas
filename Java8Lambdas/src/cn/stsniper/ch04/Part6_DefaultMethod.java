package cn.stsniper.ch04;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class Part6_DefaultMethod.
 * 
 * @author W.Dragon
 * @since 2016-1-10 22:35:05
 * @version 0.0.1-SNAPSHOT
 */
public class Part6_DefaultMethod {
	
	// Ex4-12
	@Test
	public void parentDefaultUsed() {
		Parent parent = new ParentImpl();
		parent.welcome();
		Assert.assertEquals("Parent: Hi!", parent.getLastMessage());
	}
	
	// Ex4-14
	@Test
	public void childOverrideDefault() {
		Child child = new ChildImpl();
		child.welcome();
		Assert.assertEquals("Child: Hi!", child.getLastMessage());
	}
	
	// Ex4-16
	@Test
	public void concreteBeatsDefault() {
		Parent parent = new OverridingParent();
		parent.welcome();
		Assert.assertEquals("Class Parent: Hi!", parent.getLastMessage());
	}
	
	// Ex4-18
	@Test
	public void concreteBeatsCloserDefault() {
		Child child = new OverridingChild();
		child.welcome();
		Assert.assertEquals("Class Parent: Hi!", child.getLastMessage());
	}
}

// Ex4-11
interface Parent {
	void message(String body);
	
	default void welcome() {
		message("Parent: Hi!");
	}
	
	String getLastMessage();
}

// Ex4-13
interface Child extends Parent {
	
	@Override
	default void welcome() {
		message("Child: Hi!");
	}
}

class ParentImpl implements Parent {

	private String body;
	
	@Override
	public void message(String body) {
		this.body = body;
	}

	@Override
	public String getLastMessage() {
		return body;
	}
}

class ChildImpl extends ParentImpl implements Child {
	
}

// Ex4-15
class OverridingParent extends ParentImpl {
	
	@Override
	public void welcome() {
		message("Class Parent: Hi!");
	}
}

// Ex4-17
class OverridingChild extends OverridingParent implements Child {
}