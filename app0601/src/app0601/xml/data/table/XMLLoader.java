package app0601.xml.data.table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class XMLLoader{
	
	HttpURLConnection conn;
    public static void main(String[] args) throws IOException {
    	String key="pSiRfGJUY%2FMFyuT3qdKbQlvrm2L1HFYPYNIoXZzy%2BYpfxS9ccfpKY0Lxu9gfXTAkmObBiPZxWlrWsvW8%2BWYtmg%3D%3D\\r\\n";
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/DataLabService/metcoRegnVisitrDDList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("인증키 (URL - Encode)", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("startYmd","UTF-8") + "=" + URLEncoder.encode("20210513", "UTF-8")); /*조회시작연월일(yyyymmdd)*/
        urlBuilder.append("&" + URLEncoder.encode("endYmd","UTF-8") + "=" + URLEncoder.encode("20210513", "UTF-8")); /*조회종료연월일(yyyymmdd)*/
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
    public InputStream loadFromStream(String keyword) throws IOException{
    	String key="pSiRfGJUY%2FMFyuT3qdKbQlvrm2L1HFYPYNIoXZzy%2BYpfxS9ccfpKY0Lxu9gfXTAkmObBiPZxWlrWsvW8%2BWYtmg%3D%3D\\r\\n";
    	 StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/DataLabService/metcoRegnVisitrDDList"); /*URL*/
         urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="); /*Service Key*/
         urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("인증키 (URL - Encode)", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
         urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
         urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
         urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
         urlBuilder.append("&" + URLEncoder.encode("startYmd","UTF-8") + "=" + URLEncoder.encode("20210513", "UTF-8")); /*조회시작연월일(yyyymmdd)*/
         urlBuilder.append("&" + URLEncoder.encode("endYmd","UTF-8") + "=" + URLEncoder.encode("20210513", "UTF-8")); /*조회종료연월일(yyyymmdd)*/
         URL url = new URL(urlBuilder.toString());
          conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.setRequestProperty("Content-type", "application/json");
         System.out.println("Response code: " + conn.getResponseCode());
         return conn.getInputStream();
    }
    public void close() {
		if(conn!=null) {
			conn.disconnect();
		}
	}
}