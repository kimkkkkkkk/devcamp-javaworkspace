package app0513.album;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//캔버스의 paint 메서드를 재정의하기 위한 클래스
public class XCanvas extends Canvas{
	Toolkit kit =Toolkit.getDefaultToolkit(); // 여기다가 선언한건 뭐죠? 멤버변수지만 인스턴스 변수
																//kit이 초기화되는 시점, new 할때 멤버 변수들이 초기화 메모리 올라갈때마다
																//값이 괄호 안에 들어간다.
	Image image;
	
	//스트링으로 경로를 넘겨받아서 이미지를 생성하자!!
	public void createImage(String path) {
		image = kit.getImage(path);
	}
	
	//썸네일 패널로부터 이미지를 전달받기 위해..
	public void setImage(Image image) {
		this.image = image;
		System.out.println("전달받은 이미지는"+image);
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, 600, 440, this);
	}

}
