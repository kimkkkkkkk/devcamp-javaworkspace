package app0526.thread.ex4;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//모든~~ 게임에 등장하는 객체가 가질 수 있는 보편적 요소들을 보유할 최상위 객체 선언
public abstract class GameObject {
	GamePanel gamePanel;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Image img;
	
	public GameObject(GamePanel gamePanel, String path,int x, int y, int width, int height, int velX, int velY) {
		this.gamePanel=gamePanel;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.velX=velX;
		this.velY=velY;
		
		ImageIcon icon=this.gamePanel.imageManager.getScaledIcon(path, width, height);
		img=icon.getImage();
	}
	//채워놓지도 말아야 하며, 채워넣을 수도 없다!!
	//장래의 자식이 누군진 몰라도, 그 자식이 완성하도록 미완성 상태로 놓자
	public abstract void tick();// 불안전한 메서드 추상메서드
	public abstract void render(Graphics g); // 여기서의 g는 모든 게임 오브젝트 그려질 jpanel의 paint메서드의 것
	
}
