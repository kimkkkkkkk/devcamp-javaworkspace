package app0601.json.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//다른 클라이언트의 메시지를 실시간
public class ClientMsgThread extends Thread{
 //thread를 상속받는 순간 독립적으로 움직일 수 있는 상태
	ChatClient chatClient;
	Socket socket;
	BufferedReader buffr; // 듣고
	BufferedWriter buffw; // 말하기
	boolean flag=true;
	
	public ClientMsgThread(Socket socket, ChatClient chatClient) {
		
		this.socket=socket;
		this.chatClient=chatClient;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		//듣고
		public void listen() {
			String msg=null;
			try {
				msg= buffr.readLine();
				chatClient.area.append(msg+"\n");//area에 로그 남기기 
			} catch (IOException e) {
				e.printStackTrace();
				flag=false; //쓰레드 dead 상태로 두기 
			}
		}
		
		//말하기
		public void send(String msg) {
			try {
				buffw.write(msg+"\n");
				buffw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//듣고,말하는 행위는 서버이기에 끝없이!!! 즉 쓰레드가 절대 죽으면 안됨 
		public void run() {
			while(flag) {
				listen();
			}
			//쓰레드 종료에 따른, 스르림 닫기
			if(buffw!=null) {
				try {
					buffw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
