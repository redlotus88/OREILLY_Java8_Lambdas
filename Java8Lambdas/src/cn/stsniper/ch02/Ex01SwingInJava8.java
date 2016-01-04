package cn.stsniper.ch02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex01SwingInJava8 {
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Swing in java 8!");
		jFrame.setLayout(new FlowLayout());
		jFrame.setBounds(200, 200, 200, 200);
	
		JButton jButton1 = new JButton("Click Me!");
		
		//Before java 8, how we add a action listener for button:
//		jButton1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(System.out.println("button clicked"));
//			}
//		});
		
		//After java 8, how we add a action listener for button:
		jButton1.addActionListener(actionEvent -> System.out.println("button clicked"));
		
		jFrame.add(jButton1);
		
		jFrame.setVisible(true);
	}
}
