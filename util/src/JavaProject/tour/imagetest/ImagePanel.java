package JavaProject.tour.imagetest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import util.ImageManager;

//사실상 윈도우는 껍데기에 불과하고, 모든 게임은 이 패널에서 그려질 것이다!!
public class ImagePanel extends JPanel{
	TourApp tourApp; // 게임루프 즉 심장을 뛰게 할 게임 운영 쓰레드
	
	public static final int  WIDTH=1300;
	public static final int  HELGHT=500;
	ImageManager imageManager= new ImageManager();
	Image bgImg; // 배경이미지
	
	public ImagePanel() {
		
		setPreferredSize(new Dimension(WIDTH, HELGHT));
		
		
		createBg();
		
	}
	
	//배경 생성
	public void createBg() {
		ImageIcon icon = imageManager.getScaledIcon("C:\\korea202102_javaworkspace\\javaproject\\res\\airplan.jpg", WIDTH, HELGHT);
		bgImg = icon.getImage(); // 배경 이미지 얻기!
	}
	
	//주인공 생성
	
	}

