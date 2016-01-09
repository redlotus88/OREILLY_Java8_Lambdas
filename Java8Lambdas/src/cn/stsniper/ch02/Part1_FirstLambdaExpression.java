package cn.stsniper.ch02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The Class Part1_FirstLambdaExpression.
 * 
 * @author W.Dragon
 * @since 2016-1-9 16:50:35
 * @version 0.0.1-SNAPSHOT
 */
public class Part1_FirstLambdaExpression { 
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Swing in java 8!");
		jFrame.setLayout(new FlowLayout());
		jFrame.setBounds(200, 200, 200, 200);
	
		JButton jButton1 = new JButton("Click Me!");

		//Ex2-1
		//Before java 8, how we add a action listener for button:
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked");
			}
		});
		
		//Ex2-2
		//After java 8, how we add a action listener for button:
		jButton1.addActionListener(actionEvent -> System.out.println("button clicked"));
		
		jFrame.add(jButton1);
		
		jFrame.setVisible(true);
	}
}
