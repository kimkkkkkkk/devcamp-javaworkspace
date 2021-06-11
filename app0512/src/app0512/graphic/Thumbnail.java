package app0512.graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Thumbnail extends JPanel implements MouseListener{
	PhotoAlbum photoAlbum;
	Toolkit kit; // 이미지를 얻을 수 있는 클래스
	Image image; // 추상클래스이므로, new불가
	int width =50;
	int height=50;
	
	public Thumbnail(PhotoAlbum photoAlbum) {
		
		this.photoAlbum=photoAlbum;
		
		kit = Toolkit.getDefaultToolkit(); // static 메서드, 즉 클래스 소속 메서드
		image = kit.getImage("C:\\korea202102_javaworkspace\\app0512\\res\\mt1.jpg"); 
		image= image.getScaledInstance(100, 90, image.SCALE_SMOOTH);
		this.setPreferredSize(new Dimension(100,90));
	
		//현재 패널과 리스너와의 연결
		this.addMouseListener(this);
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0,width,height, this);
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("나 눌렀어?");
		photoAlbum.detailView.setImage(image);
		//DetailView가 보유한 setImage(image);
		
	}
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {

	}


	
	
}
