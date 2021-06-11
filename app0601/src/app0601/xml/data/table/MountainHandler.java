package app0601.xml.data.table;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	Vector<Mountain> mtList; // 산 VO를 여러개 담게될 컬렉션!!
	
	boolean isItems;
	boolean isItem;
	boolean isMntiadd;
	boolean isMntidetails;
	boolean isMntihigh;
	boolean isMnrilistno;
	boolean isMntiname;
	
	Mountain mt; // vo준비
	
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("items")) {
			isItems =true;
			mtList = new Vector<Mountain>();
		}else if(tag.equals("item")) {
			isItem = true;
			mt = new Mountain(); // empty 상태의 vo 생성
		}else if(tag.equals("mntiadd")) {
			isMntiadd =true;
		}else if(tag.equals("mntidetails")) {
			isMntidetails = true;
		}else if(tag.equals("mntihigh")) { // int
			isMntihigh = true;
		}else if(tag.equals("mnrilistno")) { //int
			isMnrilistno = true;
		}else if(tag.equals("mntiname")) {
			isMntiname =true;
		}
	}
	
	//캐릭터를 만나면 ..
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);
		if(isMntiadd) { // 주소를 지나가는 중이라면..
			mt.setMntiadd(data); // vo에 주소넣기
		}else if(isMntidetails) {
			mt.setMntidetails(data); // vo에 상세내용 넣기
		}else if(isMntihigh) {
			mt.setMntihigh(data); // vo에 산 높이 넣기
		}else if(isMnrilistno) {
			mt.setMntilistnol(Integer.parseInt(data)); // vo에 산의 번호 넣기
		}else if(isMntiname) {  // vo에 산의 이름 넣기
			mt.setMntiname(data);
		}
	}
	
	// 닫는 태그를 만나면..
	public void endElement(String uri, String localName, String tag) throws SAXException {
		
		if(tag.equals("mntiadd")) {
			isMntiadd =false;
		}else if(tag.equals("mntidetails")) {
			isMntidetails = false;
		}else if(tag.equals("mntihigh")) { // int
			isMntihigh =false;
		}else if(tag.equals("mnrilistno")) { //int
			isMnrilistno = false;
		}else if(tag.equals("mntiname")) {
			isMntiname =false;
		}else if(tag.equals("item")) {
			isItem = false;
			//리스트에 vo 추가
			mtList.add(mt);
		}else if(tag.equals("items")) {
			isItems = false;
		}
	
	}
	

	public void endDocument() throws SAXException {
		for(Mountain obj : mtList) {
			System.out.println(obj.getMntiadd()+","+obj.getMntidetails()+","
			+obj.getMntihigh()+","+obj.getMntilistnol()+","+obj.getMntiname());
		}
	}
}
