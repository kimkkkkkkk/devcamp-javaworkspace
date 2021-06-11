package sojeong.so;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import JavaProject.tour.TourApp;





 
public class back extends JFrame {
	
	
    JScrollPane scrollPane;
    ImageIcon icon;
    JMenuBar bar;
	JMenu[] menu;
	String[] menu_title= {"place","room","transport","community"};
	JMenuItem[][] itemArray;
	String[][] item_title={{"intro","food"},{"hotel","others"},{"rentcar","subway"},{"chat","customer"}};
	//ShowAction showaction;
	String text ="왜 안되는 거야!!!!";
	JFrame frame = new JFrame();
	Container contentPane = frame.getContentPane();
	//JPanel p_center;
	
    public back() {
    
         
         
        icon = new ImageIcon("C:\\korea202102_javaworkspace\\javaproject\\res\\airplan.jpg");
  
        bar=new JMenuBar();
		menu=new JMenu[4];
		itemArray=new JMenuItem[4][2];
       
		
		
		
		for(int i=0;i<menu_title.length;i++) {
			menu[i]=new JMenu(menu_title[i]);
			bar.add(menu[i]);
		}
		
		for(int a=0;a<item_title.length;a++) {
			for(int j=0;j<item_title[a].length;j++) {
				
				itemArray[a][j]=new JMenuItem(item_title[a][j]);
				menu[a].add(itemArray[a][j]);
				//itemArray[a][j].addActionListener(new ShowAction());	
		}
		}
		setJMenuBar(bar); //프레임에 메뉴 부착!!
        
        //배경 Panel 생성후 컨텐츠페인으로 지정      
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
            	
                g.drawImage(icon.getImage(), 0, 0, 1300,500, null);
              
               // setOpaque(false); //그림을 표시하게 설정,투명하게 조절
               // super.paintComponent(g);
            }
        };
        JLabel label = new JLabel("<HTML><body style='text-align:center;'>YOURS TO EXPLORE <br><br>더 넓은 세상을 경험하고, 잊지 못할 순간을 예약하세요</body></HTML>"); 
        label.setHorizontalAlignment(JLabel.CENTER);
       
        background.add(label);
      
       //JLabel title = new JLabel("YOURS TO EXPLORE" , SwingConstants.CENTER);
       //JLabel content = new JLabel("더 넓은 세상을 경험하고, 잊지 못할 순간을 예약하세요",SwingConstants.CENTER);
       //title.setHorizontalAlignment(JLabel.CENTER);
       JButton button = new JButton("Intro");
       JButton button2 = new JButton("LogOut");
       JButton button3 = new JButton("Review");
        
       background.add(button, BorderLayout.CENTER); 
       
       
       //add(background);
        //dd(title); 
        //frame.add(content); 
        background.add(button);
        background.add(button2);
        background.add(button3);
        
        contentPane.add(background);
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        
        //title.setFont(new Font("Serif", Font.BOLD, 40));
       // title.setForeground(Color.WHITE);
        //content.setFont(new Font("Serif", Font.BOLD, 30));
       // content.setForeground(Color.WHITE);
        
        label.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,100,1300,500);
        setVisible(true);
        setLayout(null);
    }
    

 
    public static void main(String[] args) {
    	new back();
      
    }
}
