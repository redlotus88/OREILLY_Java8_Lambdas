package cn.stsniper.ch04;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;


/**
 * The Class Part8_Optional.
 *
 * @author W.Dragon
 * @since 2016-1-11 21:34:09
 */
public class Part8_Optional {
	
	@Test
	public void ex4_22() {
		Optional<String> a = Optional.of("a");
		Assert.assertEquals("a", a.get());
	}
	
	@Test
	public void ex4_23() {
		Optional<String> a = Optional.of("a");
		Optional emptyOptional = Optional.empty();
		Optional alsoEmpty = Optional.ofNullable(null);
		
		Assert.assertFalse(emptyOptional.isPresent());
		
		Assert.assertTrue(a.isPresent());
	}
	
	@Test
	public void ex4_24() {
		Optional<Object> emptyOptional = Optional.empty();
		Assert.assertEquals("b", emptyOptional.orElse("b"));
		Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));
	}
}
