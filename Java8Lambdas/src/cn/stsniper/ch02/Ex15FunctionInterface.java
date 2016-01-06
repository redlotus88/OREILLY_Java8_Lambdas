package cn.stsniper.ch02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JButton;

public class Ex15FunctionInterface {
	public static void main(String[] args) {
		//1-b 计算器程序中，会用Function<T, R>接口表示什么样的Lambda表达式
		Calculator.main(args);
		
		//1-c 哪些表达式有效的实现了Function<Long, Long>?
		Function<Long, Long> incre = x -> x + 1;
		//Compile Error
		//Function<Long, Long> incre1 = (x, y) -> x + 1;
		//Compile Error
		//Function<Long, Long> incre2 = x -> x == 1;
		
		//2-a ThreadLocal中接受一个Lambda表达式，并产生一个新的ThreadLocal对象。
		ThreadLocal<Object> t = ThreadLocal.withInitial(() -> new Object());
		
		//2-b DateFormatter是非线程安全的，使用构造函数创建一个线程安全的DateFormatter对象，并输出日期。
		ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH));
		String fmtStr = df.get().format(Calendar.getInstance().getTime());
		System.out.println(fmtStr);
		
		//3-a
		Runnable helloWorld = () -> System.out.println("Hello World!");
		
		JButton button = new JButton();
		button.addActionListener(event -> System.out.println(event.getActionCommand()));
		
		//Compile error, can't infer type.
//		check(x -> x > 5);
	}
	
	static boolean check(Predicate<Integer> predicate) {
		return false;
	}
	
	static boolean check(IntPred predicate) {
		return false;
	}
}

class Calculator {
	
	private static Function<Double, Double> sqrt = x -> Math.sqrt(x);  
	
	private static Function<Double, Double> abs = x -> Math.abs(x);
	
	public static void main(String[] args) {
		System.out.println(sqrt.apply(9d));
		System.out.println(abs.apply(-9d));
	}
}

interface IntPred {
	boolean test(Integer value);
}

