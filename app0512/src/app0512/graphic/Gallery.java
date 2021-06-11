package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gallery extends JFrame implements ActionListener{
	//커스터마이징 할 필요가 있으니, JPanel의 코드를 수정하자
	GalleryDetail galleryDetail; // 상세이미지 그려질 패널
	JPanel p_south;
	JButton bt_prev;
	JButton bt_next;
	
	//갤러리에 사용할 데이터 즉 배열을 준비하자!!
	String dir ="C:/korea202102_javaworkspace/app0512/res/dog";
	String[] arr = {"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg"};
	
	Toolkit kit; // 추상클래스여서 new가 안됨
	Image[] image = new Image[arr.length]; // 배열생성
	int index=3; // 이미지 배열의 접근용 index
	
	public Gallery() {
		
		//생성
		 galleryDetail = new GalleryDetail();
		 p_south = new JPanel();
		 bt_prev = new JButton("이전 사진");
		 bt_next = new JButton("다음 사진");
		 kit=Toolkit.getDefaultToolkit(); // 인스턴스 얻기!! new 하지 않고도 자바에서 준비된 메서드
		
		 for(int i=0;i<arr.length;i++) {			 
			 	image[i]=kit.getImage(dir+"/"+arr[i]);
		 }
		 
		 //이미지가 생성되었으므로, 0번째 즉 첫번째 이미지를
		 //디폴트로 그려지게 하자!!
		 galleryDetail.setImage(image[index]);
		 
		//스타일, 레이아웃
		 galleryDetail.setBackground(Color.BLUE);
		
		//조립
		add(galleryDetail); // center 영역에 부착
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add( p_south, BorderLayout.SOUTH);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//보여주기
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		//하나의 actionPerformed메서드에서 여러 컴포넌트 즉 이벤트 소스를 구분해야 한다.
		if(e.getSource()==bt_prev) {
			if(index>0) {
				index--;
			}else {
				JOptionPane.showMessageDialog(this, "이전 이미지가 없습니다");
			}
		}else if(e.getSource()== bt_next) {
			if(index<arr.length-1) {
				index++; // 그 다음 이미지를 접근하기 위해 index 1 증가			
			}else {
				JOptionPane.showConfirmDialog(this, "다음 이미지가 없습니다");
			}
		}
		System.out.println("index ="+index);
		
		//상세보기 객체에 변경된 이미지 보내주기
		galleryDetail.setImage(image[index]);
		galleryDetail.repaint(); // 다시 그리기 요청
	}

	public static void main(String[] args) {
		new Gallery();
	}

}
