package JavaProject.tour.imagetest;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Border extends JFrame{

	
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton bt4;
	JButton bt5;
	public Border() {
		
		
		//setTitle("이미지 그리기 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		bt1 = new JButton("북");
		bt2 = new JButton("센터");
		bt3 = new JButton("남");
		bt4 = new JButton("동");
		bt5 = new JButton("서");
		
		
		bt1.setSize(50,50);
		bt2.setSize(50,50);
		bt3.setSize(50,50);
		bt4.setSize(50,50);
		bt5.setSize(50,50);
		
		add(bt1, BorderLayout.NORTH);
		add(bt2, BorderLayout.CENTER);
		add(bt3, BorderLayout.SOUTH);
		add(bt4, BorderLayout.EAST);
		add(bt5, BorderLayout.WEST);

		
		
		
		
		setBounds(0,0,1300,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		 new Border();

	}

}
