package cn.stsniper.ch02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The Class Part3_UseValueButNotVariable.
 * 
 * @author W.Dragon
 * @since 2016-1-9 16:51:50
 * @version 0.0.1-SNAPSHOT
 */
public class Part3_UseValueButNotVariable {
	
	public static void main(String[] args) {
		JButton button = new JButton("Test");
		//Ex2-4
		final String[] array = { "hello", "world" };
		
		//Ex2-5
		//Equals to final String name = getUserName(); if name used in Lambda.
		String name = getUserName();
		//not compile, can't modify variable name, because it is final.
		//Ex2-7
//		name = formatUserName(name);
		
		//Use final variable in anonymous inner class
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("hi " + name);
			}
		});
		
		//Ex2-6
		button.addActionListener(event -> System.out.println("hi " + name));
	}

	private static String formatUserName(String name) {
		return "new name";
	}

	private static String getUserName() {
		return "name";
	}
}
