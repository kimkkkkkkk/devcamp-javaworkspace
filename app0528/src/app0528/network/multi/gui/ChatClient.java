package app0528.network.multi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JPanel p_north;
	JTextField t_ip;
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	Socket socket; // 서버와의 통신을 위한 대화용 소켓
	ClientMsgThread msgThread;
	
	
	public ChatClient() {
		p_north = new JPanel();
		t_ip = new JTextField("192.168.219.102",10);
		t_port = new JTextField(5);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(20);
		bt_send = new JButton("send");
		
		//조립 
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south, BorderLayout.SOUTH);
		
		//이벤트 
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
				
			}
		});
		
		bt_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg=t_input.getText();
				msgThread.send(msg);
				t_input.setText(""); // 입력값 초기화
			}
		});
		
		//엔터쳤을때도 메시지 보낵;ㅣ
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String msg=t_input.getText();
					msgThread.send(msg);
					t_input.setText(""); // 입력값 초기화
				}
			}
		});
		
		//보이기 
		setVisible(true);
		setBounds(200, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void connect() {
		String ip=t_ip.getText();
		int port = Integer.parseInt(t_port.getText());
		
		try {
			socket = new Socket(ip,port); // 접속 시도!~
			
			//클라이언트 전용 대화 쓰레드 생성
			msgThread = new ClientMsgThread(this);
			msgThread.start(); //run()메서드 호출 -->listen() 청취가동 무한루프 시작!!
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatClient();

	}

}