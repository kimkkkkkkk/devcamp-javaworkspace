package app0513.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoMain extends JFrame {
	JPanel p_north; //북쪽의 썸네일을 붙일 패널
	XCanvas can; //큰 이미지를 그릴 캔버스
	String dir ="C:/korea202102_javaworkspace/app0513/res/dog/";
	String[] pathArray= {"1.jpg", "2.jpg","3.jpg","4.jpeg","5.jpg","6.jpeg","7.jpg","8.jpeg","9.jpg","10.jpg"};
	ThumbPanel[] thumbArray=new ThumbPanel[pathArray.length];
	
	public PhotoMain() {
		//생성
		p_north = new JPanel();
		can = new XCanvas();
		
		
		//썸네일 생성
		for(int i=0;i<pathArray.length;i++) {
			thumbArray[i] = new ThumbPanel(dir+pathArray[i], can); // 생성
		}
		
		//스타일 & 레이아웃
		p_north.setBackground(Color.ORANGE);
		p_north.setPreferredSize(new Dimension(600,70));
		can.setBackground(Color.YELLOW);
		
		//조립 
		for(int i=0;i<thumbArray.length;i++) {			
			p_north.add(thumbArray[i]);
		}
		add(p_north,BorderLayout.NORTH);
		add(can);
		//리스너 연결
		
		
		//보이기
		can.createImage(dir+pathArray[0]); // 첫번째 이미지 보여주기
		
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//썸네일에 사용할 이미지 배열 생성
	public void initDate() {
		
	}
	
	public static void main(String[] args) {
		new PhotoMain();

	}

}
