package app0602.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//키보드로부터, 문자를 입력받아 모니터에 출력하되, 한글이 꺠지지 않아야 하고,
//한줄씩 입력	받아, 한줄씩 출력하시오!!
public class BufferTest {
	public static void main(String[] args) {
		
		InputStream is = System.in;
		//문자기반 스트림으로 변환
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffr = new BufferedReader(reader);
		String data=null;
		
		
	}
}
