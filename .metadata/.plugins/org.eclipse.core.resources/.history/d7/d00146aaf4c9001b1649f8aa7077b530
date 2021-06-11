package JavaProject.tour.imagetest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
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

import JavaProject.tour.LoginForm;
import JavaProject.tour.TourApp;

public class imagedDraw extends JFrame{
	
	JMenuBar bar;
	JMenu[] menu;
	String[] menu_title= {"place","room","transport","community"};
	JMenuItem[][] itemArray;
	String[][] item_title={{"intro","food"},{"hotel","others"},{"rentcar","subway"},{"chat","customer"}};
	LoginForm loginform;

	
	
	JScrollPane scrollPane;
	ImageIcon i = new ImageIcon("C:\\korea202102_javaworkspace\\javaproject\\res\\lo.jpg");
    Image im=i.getImage();
    //JPanel p_center;
    JButton list;
	JButton logout;
	JButton re;
	JPanel p_north;
	
    
    public imagedDraw() {
    	 //JFrame frm = new JFrame("프로의 BLOG"); 
        this.setTitle("Tour");
        
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
		setJMenuBar(bar);
		
		 JPanel p_north = new JPanel();
	      list = new JButton("<html><i>INTRO</i></html>");
	      logout = new JButton("<html><i>REVIEW</i></html>");
	      re = new JButton("<html><i>LOGOUT</i></html>");
	      
	      JButton view= new  JButton("<HTML><body><button style='text-align:center;'></button></body></HTML>");
	      
	   
	     
	      list.setHorizontalAlignment(JButton.CENTER);
	      list.setBounds(30, 170, 122, 30);
	      
//	      getContentPane().add(list, BorderLayout.CENTER);
//	      list = new JButton("<html><i>Cancel</i></html>");
//	      list.setVerticalAlignment(SwingConstants.CENTER);
//
//	      list.setDefaultCapable(true);
        
        MyPanel panel = new MyPanel();
        
        
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1300,500));
        p_north.setPreferredSize(new Dimension(35,35));
        
        panel.add(view);
        
        //p_north.add(panel);
        list.add(panel);
        p_north.add(list);
        p_north.add(logout);
        p_north.add(re);
   
          
        add(panel,BorderLayout.CENTER);
        add(p_north, BorderLayout.SOUTH);
        p_north.setBackground(Color.white);
        bar.setBackground(Color.white);

        list.setBackground(Color.orange);
        logout.setBackground(Color.orange);
        re.setBackground(Color.orange);

       
        
        //scrollPane = new JScrollPane(panel);
       
	    JLabel label = new JLabel("<HTML><body style='text-align:center;'>YOURS TO EXPLORE <br><br>더 넓은 세상을 경험하고, 잊지 못할 순간을 예약하세요</body></HTML>");
        //JButton bt1 = new JButton("<HTML><body style='text-align:center;'></body></HTML>");
	    label.setFont(new Font("Serif", Font.BOLD, 25));
	    label.setForeground(Color.WHITE);
	    label.setHorizontalAlignment(JLabel.CENTER); //JLabel 가운데 정렬
	    //JLabel 가운데 정렬
	    //label.setHorizontalAlignment(JLabel.RIGHT);
	        
	    panel.add(label);
	    
        
 
       
	    
        this.add(panel);
        setBounds(300,100,1300,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
       //setContentPane(scrollPane);
       
    }
    
    
    class MyPanel extends JPanel{
            
        public void paintComponent(Graphics g){
            //super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }

	public void logout() {
		dispose();
		new LoginForm();
	}



	public static void main(String[] args) {
		
		new imagedDraw();
	}
}
