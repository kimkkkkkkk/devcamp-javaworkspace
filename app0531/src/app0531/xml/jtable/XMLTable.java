package app0531.xml.jtable;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLTable extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	
	public XMLTable() {
		table = new JTable();
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		setSize(600,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		loadXML();
	}
	
	public void loadXML() {
		SAXParserFactory factory= SAXParserFactory.newInstance(); //팩토리의 인스턴스 얻기
		try {
			URL url = this.getClass().getClassLoader().getResource("Pets.xml");
			URI uri = url.toURI();
			SAXParser saxParser=factory.newSAXParser();//파서생성
			PetHandler handler=null;
			//지정한파일을 파싱해라 핸들러로
			saxParser.parse(new File(uri), handler=new PetHandler());
			System.out.println("파싱을 종료합니다.");
			//JTable의 모델 데이터와 파싱한 결과와의 매칭은 파싱전? 파싱한 후?
			
			PetModel model = new PetModel();
			model.data=handler.petList;
			table.setModel(model); // 바로 이 순간부터 JTable은 TableModel의
			//메서드를 호출하게 된다~?? 왜 ? 그래야 표를 구성하니까
			
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new XMLTable();
	}
		
}
