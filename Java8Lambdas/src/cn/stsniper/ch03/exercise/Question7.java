package cn.stsniper.ch03.exercise;

import static cn.stsniper.ch03.exercise.Question6.countLowercaseLetters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class Question7.
 * 在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回Optional<String>对象。
 * 
 * @author W.Dragon
 * @since 2016-1-9 22:31:28
 * @version 0.0.1-SNAPSHOT
 */
public class Question7 {

	@Test
	public void test() {
		List<String> tests = Arrays.asList("Test", "Questions", "Class");
		
		Assert.assertFalse(mostLowercaseString(Collections.emptyList()).isPresent());
		Assert.assertEquals("Questions", mostLowercaseString(tests).get());
	}
	
	// Question 8
    public static Optional<String> mostLowercaseString(List<String> strings) {
    	return strings.stream().max((str1, str2) -> countLowercaseLetters(str1) - countLowercaseLetters(str2));
    }
    
    
}
