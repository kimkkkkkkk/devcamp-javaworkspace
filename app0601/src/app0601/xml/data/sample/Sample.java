package app0601.xml.data.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Sample {

	// 여기서는 throws 메인메서드한테 예외를 전가시킬거야, try처리를 하는게 아니라 이 메인 메서드를 호출한 자한테 전가 시킬거야
	
	// try~catch : 예외를 개발자가 처리하겠다~~
	// throws : 개발자가 해당 예외를 처리하지 않고, 메서드 호출자에게 전가 시키겠다.
	// 아래의 코드에서 main메서드를 호출한 자는 jvm이므로, 혹여나 예외가 발생한다면 JVM에 의해 예외처리 결과가 출력!!
	public static void main(String[] args) throws IOException{ 
	        String key="c72%2BhD7zTWhz6SsEutd%2FfXh98TwziESTQdKKSxZRCLEe2txh7i3oy28SGelK4HDQZ3P2T4nSOfW0oxruxYHTgg%3D%3D";
		  	
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+key); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("searchWrd","UTF-8") + "=" + URLEncoder.encode("북한산", "UTF-8")); /*예:1) searchWrd = “북한산”일때 산명안에 “북한산”을 포함하는 “북한산”이 검색됨*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*발급받은서비스키증키*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	}

}
