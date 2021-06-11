package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	private ChatClientA chatClientA;
	private ChatClientB chatClientB;

	public ChatClientC() { //ChatClientA chatA
				
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(24);
		
		//스타일, 레이아웃
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(Color.PINK);
		
		//조립
		add(scroll);
		add(t_input);
	
		//이벤트 연결
		t_input.addKeyListener(this);
		
		//보여주기
		setBounds(600, 100+400, 300, 400);;
		setVisible(true);
		
	
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			showText();
		}
		
	}
	
//	//setter
	public void setChatClientA(ChatClientA chatClientA) {
		this.chatClientA = chatClientA;
	}

	public void setChatClientB(ChatClientB chatClientB) {
		this.chatClientB = chatClientB;
	}
	

	
	
	
	public void showText() {
		String msg = t_input.getText();
		//this.area.append(msg+"\n");
		area.append(msg+"\n");
		//area2.append(msg+"\n");
		
		chatClientA.area.append(msg+"\n");
		chatClientB.area.append(msg+"\n");
		
		//cb.area.append(msg+"\n");
		
		t_input.setText("");
		
		
	}


}
