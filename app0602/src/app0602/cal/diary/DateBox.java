package app0602.cal.diary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//날짜 한개를 표현할 박스 (여기서 요일을 담당할 것임)
public class DateBox extends JPanel{
	int width;
	int height;
	String day;
	Color color;
	Image img;
	
	public DateBox(String day,Color color, int width, int height) {
		this.day=day;
		this.color =color;
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
	}
	
	public void paint(Graphics g) { // 배경색 칠하고 글씨색상 주기
		g.setColor(color);// 그래픽 객체의 물감이 회색이다!!
		g.fillRect(0, 0, width, height); // 채워진 사각형
		
		
		g.setColor(Color.WHITE); // 물감을 흰색으로 교체
		g.drawString(day, 10, 20);
		
		//조건에 따라 아이콘을 그리고, 안그리고를 결정짓게 하자!!
		if(img!=null) { //즉 null이 아닌 경우 그리자!!
			g.drawImage(null, 0,0,70,65,this);
		}
	}
}
