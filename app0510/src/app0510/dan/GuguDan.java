package app0510.dan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app0510.event.GugudanEvent;

public class GuguDan extends JFrame{

	JTextField t_input; //주소값을 갖고 있다 printDan..이 접근하려면..
	JButton bt;
	
	public GuguDan() {
		
		//생성
		t_input = new JTextField(20);
		bt = new JButton("출력");
		
		
		//조립
		this.setLayout(new FlowLayout());
		add(t_input);
		add(bt);
		
		//버튼과 리스너 연결
		GugudanEvent ge=null;
		bt.addActionListener(new GugudanEvent(t_input));
		
		ge.callMe(3); //call by value : 값에 의한 호출
		ge.callMe("korea"); // call by reference
		ge.callMe(bt); // call by reference
		ge.callMe(t_input);
		
		
		//보여주기
		setSize(250, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GuguDan();
	}
}
