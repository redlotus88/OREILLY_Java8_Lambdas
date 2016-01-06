package cn.stsniper.ch02;

import javax.swing.JButton;

public class Ex07FinalVariable {
	
	public static void main(String[] args) {
		
		JButton button = new JButton("Test");
		
		// Equals to final String name = getUserName(); if name used in Lambda.
		String name = getUserName();
		
		// not compile, can't modify variable name, because it is final.
//		name = formatUserName(name);
		
		button.addActionListener(event -> System.out.println("hi " + name));
	}

	private static String formatUserName(String name) {
		return "new name";
	}

	private static String getUserName() {
		return "name";
	}
}
