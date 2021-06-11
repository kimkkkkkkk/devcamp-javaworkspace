package JavaProject.tour.imagetest;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
 
public class TextText extends JFrame{
	

	public TextText() {
		JFrame frm = new JFrame("프로의 BLOG"); 
		frm.setBounds(120, 120, 1300, 500); //GUI의 위치와 사이즈 설정
	    frm.setLayout(new BorderLayout()); //BorderLayout은 동, 서, 남, 북으로 나뉘어 있는 레이아웃.
	    JLabel label = new JLabel("<HTML><body style='text-align:center;'>YOURS TO EXPLORE <br><br>더 넓은 세상을 경험하고, 잊지 못할 순간을 예약하세요</body></HTML>"); //텍스트를 보여줄 JLabel 생성
		
	    
	  
		label.setHorizontalAlignment(JLabel.CENTER); //JLabel 가운데 정렬
	       //JLabel 가운데 정렬
	        //label.setHorizontalAlignment(JLabel.RIGHT);
	        
	    frm.add(label);
	   
	    frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //X버튼 누를시 종료
	    frm.setVisible(true); //프레임 보여주기
		
	}
	
	
    public static void main(String[] args) {

       new TextText();
        
        
      
        
 


		
        
        //JLabel label2 = new JLabel(""); //텍스트를 보여줄 JLabel 생성
     
    }
 
}