/*
 *AWT 자바의 GUI API를 대부분 지원하기는 하지만, 플랫폼(os)마다 디자인이 일관적이지
 * 


*/
package app0510.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	JButton bt; //인스턴스 변수 , has a 관계의 객체
	//int x=5; // 인스턴스 변수  얘는 static 에서 접근 못함 그래서 new를 한다
	
	//특히 has a 관계로 다른 객체를 보유할 경우, 개발자는 생성자를 적극활용하면 좋다!!
	//why? has a 란 부품을 보유한 관계이므로, 해당 본체가 태어날때 같이 생성되어야 하므로..
	public SwingTest() {
		//여기까지 생성
		bt =new JButton("나 버튼");
		
		//스타일
		this.setSize(new Dimension(300,400));
		//조립
		this.setLayout(new FlowLayout());
		this.add(bt);
		//보여주기
		this.setVisible(true);
	
		//스윙은 윈도우 창 닫기 버튼은 그냥 setVisible을 False로 두는 것 뿐이다.
		//아직 프로그램 즉, 프로세스는 살아있다..
		//해결책?? 1) 이벤트를 구현하는 법 2) 알맞는 메서드 호출
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}

}
