package app0510.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

//버튼을 눌렀을때 해당 이벤트를 청취하는 ActionListener 재 정의
public class GugudanEvent implements ActionListener{
	JTextField t_input; // 멤버변수, 가비지컬렉터가 인스턴스를 죽이기 전까지 쓸 수 있음
	
	//생성자
	public GugudanEvent(JTextField t_input) {
		System.out.println("이벤트 클래스 생성시 넘겨받은 t_input은"+t_input);
		this.t_input=t_input;
	}
	
	public void callMe(int x) {
		System.out.println("넘겨받은 x는 "+x);
	}
	
	public void callMe(String y) {
		System.out.println("y는 "+y);
	}
	
	public void callMe(JButton bt) {
		System.out.println("bt는 "+bt);
	}
	
	public void callMe(JTextField t_input) {
		this.t_input=t_input;
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		//나 아닌 다른 클래스에 존재하는 TextField 값에 무엇이
		//들어있는지 알아맞추기!!
		//t_input 값 가져오기
		printDan();
	}
	
	
	public void printDan() {
		//js var v = document.getElementById("t_input).value;
		//자바에서 TextField 값 얻기...
		String dan = t_input.getText();
		System.out.println("당신이 입력한 단은 "+dan+"단 입니다");
		//"5" --> 5
		/* 자바스크립트 에서는 문자열을 정수로 변환하기 위해 parseInt() 함수를 지원한다..
		 * 자바 언어도, 이와 동일한 기능을 지원하는데, 단지 API 가 약간 틀린다 
		 * 즉 자바에서는 문자열인 String형 즉 객체자료형을 기본자료형으로 변경한다는 것 자체가 불가능하다 
		 * Dog(객체자료형) --> 7(기본자료형) 불가
		 * 7(기본자료형) --> Dog(객체자료형) 불가
		 * 
		 * 아래와 같이 String형에 대해서는 (특별) 기본자료형을 기본자료형과 */
		
		String x="8";
		int d = Integer.parseInt(dan); // "8" 쌍
		
		for(int i=1;i<=9;i++) {
			System.out.println("5*"+i+"="+(5*i));
		}
		
	}
}
