package app0513.paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{

	boolean flag = false;
	
	public MyCanvas() {
		this.addMouseListener(this); // 캔버스와 리스너 연결
		this.addMouseMotionListener(this); // 캔버스와 마우스 모션 리스너 연결
	}
	
	public void paint(Graphics g) {
		if(flag) {
		g.fillOval(100, 100, 2, 2); // 채워진 원 즉 점을 그린다!!
		}
	}
	public void mouseMoved(MouseEvent e) {
		 //간접적으로 paint() 메서드를 호출하게 된다.
		//flag=true;
	}
	
	public void mouseDragged(MouseEvent e) {
		//System.out.println("mouseDragged");
		repaint();
	}
	
	//마우스를 눌렀다가 뗄때는 그림 그리기 불가...
	public void mouseReleased(MouseEvent e) {
		//System.out.println("mouseReleased 호출");
		//flag=false;
	}
	
	//마우스를 누르면, 이때부터 그림그리기 가능..
	public void mousePressed(MouseEvent e) {
		//System.out.println("mousePressed 호출");
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

}
