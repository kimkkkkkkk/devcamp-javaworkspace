package app0528.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerMsgThread extends Thread{

	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ChatServer chatServer; // JTextArea area 대신에 JTextArea,vector 등 여러가지 서버측의
										// 자원을 접근할 것이기에.. 통째로 서버를 보유하자 
	boolean flag= true; // 현재 쓰레드를 동작제어할 수 있는 논리값 즉 false를 두는 순간. 이 쓰레드는 dead상태가 된다!!
								//내가 죽이고 싶을때 false를 주자
	
	public ServerMsgThread(Socket socket, ChatServer chatServer) {
		this.socket=socket;
		this.chatServer=chatServer;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고
	public void listen() {
		String msg =null;
		try {
			
			msg=buffr.readLine(); // 클라이언트가 보낸 메시지 듣기
			//서버에 접속한 모든 유저의 send(msg)호출!!
			for(int i=0;i<chatServer.clientList.size();i++) {
				//벡터의 각 요소에 들어있는 쓰레드 꺼내기!!!
				ServerMsgThread msgThread = chatServer.clientList.get(i);
				msgThread.send(msg);//듣자마자 다시 클라이언트에게 곧바로 보내기 
			}		
			chatServer.area.append(msg+"\n"); // 서버의 로그에 남기기
			} catch (IOException e) {
			e.printStackTrace();
			//대화 목록 수에서 제거!!
			chatServer.clientList.remove(this); // 내가 서버측의 상대방, 나간 사람과 매칭 되는 사람은 나 내가 원흉, 나를 죽이자 백터로부터
			chatServer.area.append("클라이언트 나갔음, 현재 접속자 "+chatServer.clientList.size() +"명\n");
			flag =false;
			
		}
	}
	
	//말하기
	public void send(String msg) {
		//버퍼처리된 스트림에서의 문자열의 끝을 표시할때는 \n (줄바꿈)을 이용한다.
		try {
			buffw.write(msg+"\n"); //메시지 보내기 , 역슬래시를 만날때 출력행위가 발생
			buffw.flush(); // 출력 하고 나서 화장실 물내려라
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고 말하기를 run으로 제어
	public void run() {
		while(flag) {
			listen(); // 끝없이 말하고 듣고
		}
	}
}
