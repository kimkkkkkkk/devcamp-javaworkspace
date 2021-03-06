package app0531.xml;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//파싱 대상이 되는 XML 문서의 모든 노드를 만날때마다, 개발자가 이벤트를 통해 정보를
//전달해주는 핸들러 객체 정의, 개발자는 핸들러가 발생시키는 이벤트에 따라 원하는 파싱 관련 작업을
//진행 할 수 있다..
public class MyHandler extends DefaultHandler { // xml을 분석해주는 분석 객체
	// 파싱을 진행하는 실행부가 지금 어느 태그를 지나치는지를 알 수 있는 표시 용도의 논리값을 선언
	// 표시값 변수 선언
	boolean isMembers;
	boolean isMember;
	boolean isName;
	boolean isAge;
	boolean isAddr;
	
	//vector의 제너릭타입은 멤버다.
	Vector <Member>memberList;
	Member member;
	
	// 각 노드를 만날떄마다 호출되는 메서드를 재정의해보자!!
	public void startDocument() throws SAXException {
		System.out.println("문서의 시작입니다");
	}
	//시작 태그 노드를 만날때 호출되는 메서드
	public void startElement(String uri, String name, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");
		
		if(tag.equals("members")) {
			isMembers=true; // 실행부가 members 태그를 지나갑니다..
			memberList = new Vector <Member>();
		}else if(tag.equals("member")) { // 한명의 회원의 시작~~ 따라서 VO를 준비하자!
			isMember=true; // 지나간다 표시
			member = new Member();
		}else if(tag.equals("name")) {
			isName=true; // 여기서는 지나간다만 표시 네임은 아래에 characters를 만나야 동작이되기 떄문
		}else if(tag.equals("age")) {
			isAge=true; // 지나간다 표시  <age>
		}else if(tag.equals("addr")) {
			isAddr=true; // 지나간다 표시 <addr>
		}
		
	}
	
	//시작 태그와 닫는 태그 사이의 텍스트 노드!!
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);
		System.out.print(data);
		
		if(isName) { //현재 실행부가 name 시작 태그를 막 지나친 상채라면..
			member.setName(data);  
		}else if(isAge) {
			member.setAge(Integer.parseInt(data)); // 32
		}else if(isAddr) {
			member.setAddr(data); // Boston
		}
	}

	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.print("</"+tag+">");
		
		if(tag.equals("name")){
			isName=false; // 닫는 태그를 만나면 다시 false로 돌려놓아얌함
		}else if(tag.equals("age")) {
			isAge=false; // 다시 돌려놓기 </age>
		}else if(tag.equals("addr")) {
			isAddr = false; // 다시 돌려놓기 </addr>  닫는 태그
		}else if(tag.equals("member")) {
			isMember=false;
			memberList.add(member); // 넣기 
		}else if(tag.equals("members")) {
			isMembers=false;
		}
	}
	
	public void endDocument() throws SAXException {
		System.out.println("문서의 끝입니다, 최종적으로 분석된 회원수는 "+memberList.size());
	
		//모든 회원 출력해보기
		for(Member obj : memberList) {
			System.out.println("회원이름:"+obj.getName()+", 나이:"+obj.getAge()+",주소:"+obj.getAddr());
		}
	}
}
