package app0602.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamStudy {

	
	public static void main(String[] args) {
		//System.out.print("야호~"); // 어디로 출력되나?? 표준스트림으로 처리됨
		
		//키보드를 통해 데이터를 입력받아보자!!
		//키보드는 콤퓨터가 켜질떄 os가 인식함
		//FileInputStream fis = new~~ 파일 스트림은 생성 시점을 개발자가 정할 수 있는 스트림이다!
		//하지만, 키보드, 모니터, 바코드 스캐너, 프린터기 등등은 하드웨어를 시스템인 OS가 관리하므로,
		//컴퓨터를 켜는 순간부터 이미 스트림은 존재하게 된다... 따라서  new가 아닌, 시스템인 OS로 부터 얻을 수
		//있고, 자바에서 이 OS인 시스템을 접근할때 사용되는 객체가 바로 System이다!!
		
		//여기서 들어오게 되는 데이터는 키보드 or 바코드스캐너 등등 입력도구라면 모든 가능!!
		//즉 지금 동작시킨 하드웨어에 의해 데이터가 들어와 진다!!
		InputStream is = System.in; //1. 키보드로 읽어들인 것을
		
		//현재 is는 바이트기반 스트림이므로, 1 byte 씩 처리할 수 있다.
		int data=-1;
		
		try {
			data=is.read();
			System.out.println((char)data); //2. 모니터로 출력하자
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}