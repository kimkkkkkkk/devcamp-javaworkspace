package app0526.thread.ex1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class CounterProgress extends JFrame{
	JLabel la;
	JProgressBar bar;
	JButton bt;
	JButton bt_man; //프로그래스바를 수동으로 증가시킬 버튼
	int count=0;
	int n=0;
	Thread t1; // 카운터를 증가시킬 쓰레드(내부익명 클래스??? -> 다시 영상 돌려보기)
	Thread t2;
	boolean flag = true;
	
	public CounterProgress() {
		la= new JLabel(Integer.toString(count));
		bar = new JProgressBar();
		bt = new JButton("Start !!");
		bt_man = new JButton("바 증가");
		
		
		
		//style& Layout
		this.setLayout(new FlowLayout());
		la.setFont(new Font("Verdana", Font.BOLD,60));
		bar.setPreferredSize(new Dimension(260,40));
		
		//조립
		add(la);
		add(bar);
		add(bt);
		add(bt_man);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,100,300,200);
	
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCount(); // 메인실행부가 호출함 1
			}
		});
		
		bt_man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBar();
			}
		});
	}
	
	public void addCount() { //호출받음 2
		t1 = new Thread() { //t1의 머리카락 하나 뽑음 3
			public void run() { 
				while(true) { 
					count++; //멤버변수 내것 처럼 쓰기
					la.setText(Integer.toString(count));
				}
			}
		};
		t1.start(); //jvm에게 맡기자!! 더 이상 관여 x // t1이 얘를 호출 4 
		System.out.println("카운터를 증가시킵니다."); //  얘를 만남5
	}
	
	public void addBar() {
		t2 = new Thread() {		
			public void run() {
				while(flag) { // 스레드를  죽이기 위해선 true 는 핵심 제어 대상 그래서 변수로 줘야함
					n++;
					bar.setValue(n);
					if(n>90)flag=false;
					try {
						Thread.sleep(10); // 바가 빠르게 늘고 있는데 보여지지는 않음 그래서
						// 10/1000 초 동안 non-runnable에 가있다가, 이 지정한 시간이 지나면 다시 복귀해 (휴가 다녀와)
						// 100% 까지 찬게 보임 시각적으로 보이지는 않지만 무한루프 돌 고 있음 그래서 n>100을 줘야함
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	}
	
	
	public static void main(String[] args) {
		new CounterProgress();
	}

}
