package app0513.album;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ThumbPanel extends JPanel implements MouseListener{
	Toolkit kit;
	Image image;
	int width =60;
	int height=60;
	XCanvas can; // 필요하면 부품으로 보유하면 된다.. has a 관계
	
	//생성자
	public ThumbPanel(String filename,XCanvas can) {
		this.setPreferredSize(new Dimension(60,60));
		kit = Toolkit.getDefaultToolkit(); // new 할 수 없다!!
		image = kit.getImage(filename);
		this.can = can; // 넘겨받은 캔버스 주소값을 멤버변수에 보관해놓자!
		
		this.addMouseListener(this); //패널인 나 자신과 리스너인 나 자신을 연결
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, width,height, this); // x,y,width,height, observer
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("XCanvas에 전달할 이미지는 "+image);
		can.setImage(image);//XCanvas가 가진 setImage() 메서드 호출
		can.repaint(); //캔버스 다시 그리기
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
