package cn.stsniper.ch04;

import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class Part1_UseLambdaInCode.
 * 
 * @author W.Dragon
 * @since 2016-1-10 01:09:47
 * @version 0.0.1-SNAPSHOT
 */
public class Part1_UseLambdaInCode {
	
	static Logger logger = Logger.getLogger(Part1_UseLambdaInCode.class);
	
	@Before
	public void setUp() {
		initLog4j();
	}
	
	private void initLog4j() {
		PropertyConfigurator.configure("log4j.properties");
	}

	/**
	 * Ex4_1.
	 */
	@Test
	public void ex4_1() {
		logger.debug("Look at this: " + expensiveOperation());
	}
	
	@Test
	public void ex4_2() {
		debug(() -> "Look at this: " + expensiveOperation());
	}

	// Ex4-3
	private void debug(Supplier<String> message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message.get());
		}
	}

	private String expensiveOperation() {
		return "expensiveOperation";
	}
}
