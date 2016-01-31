package cn.stsniper.ch07;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;


/**
 * The Class Part2_UseLambdaInTest.
 *
 * @author W.Dragon
 * @since 2016-1-30 20:03:48
 */
public class Part2_UseLambdaInTest {
	
	// Ex7-8
	public static List<String> allToUpperCase(List<String> words) {
		return words.stream()
					.map(string -> string.toUpperCase())
					.collect(Collectors.<String> toList());
	}
	
	// Ex7-9
	@Test
	public void multipleWordsToUpperCase() {
		List<String> input = asList("a", "b", "hello");
		List<String> result = Part2_UseLambdaInTest.allToUpperCase(input);
		assertEquals(asList("A", "B", "HELLO"), result);
	}
	
	// Ex7-10 将列表中元素的第一个字母转换成大写
	public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
		return words.stream()
					.map(value -> {
						char firstChar = Character.toUpperCase(value.charAt(0));
						return firstChar + value.substring(1);
					})
					.collect(Collectors.<String>toList());
	}
	
	// Ex7-11 测试字符串包含两个字符的情况，第一个字母被转换成大写
	@Test
	public void twoLetterStringConvertedToUppercaseLambdas() {
		List<String> input = asList("ab");
		List<String> result = Part2_UseLambdaInTest.elementFirstToUpperCaseLambdas(input);
		assertEquals(asList("Ab"), result);
	}
	
	// Ex7-12 将首字母转换为大写，应用到所有列表元素
	public static List<String> elementFirstToUpperCase(List<String> words) {
		return words.stream()
					.map(Part2_UseLambdaInTest::firstToUppercase)
					.collect(Collectors.<String>toList());
	}
	
	public static String firstToUppercase(String value) {
		char firstChar = Character.toUpperCase(value.charAt(0));
		return firstChar + value.substring(1);
	}
	
	// Ex7-13 测试单独的方法
	@Test
	public void twoLetterStringConvertedToUpperCase() {
		String input = "ab";
		String result = Part2_UseLambdaInTest.firstToUppercase(input);
		assertEquals("Ab", result);
	}
}
