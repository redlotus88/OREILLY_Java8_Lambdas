package cn.stsniper.ch03.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class Question6.
 * 计算一个字符串中小写字母的个数
 */
public class Question6 {
	
	@Test
	public void test() {
		String test = "I'm Dragon.W. Nice to meet you.";
		Assert.assertEquals(18, countLowercaseLetters(test));
	}
	
	// Question 7
    public static int countLowercaseLetters(String string) {
        return (int) string.chars().filter(ch -> Character.isLowerCase(ch)).count();
    }
}
