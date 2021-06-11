package app0603.email;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//메일을 주고 받으려면, 원래 메일 서버가 있어야 한다..
//하지만 , 금일수업은 이미 무료로 제공되는 구글의 메일 서버를 이용해본다!!
//메일 보내는 프로토콜 : SMTP, 받는 프로토콜: POP
public class MailSendApp extends JFrame{
	JTextField t_receiver;
	JTextField t_sender;
	JTextField t_title;
	JTextArea area;
	JButton bt;
	Properties props; // key- value 쌍으로 데이터를 처리하는
	
	public MailSendApp() {
		t_receiver = new JTextField(25);
		t_sender = new JTextField("kgsz1104@gmail.com",25);
		t_title = new JTextField(25);
		bt = new JButton("메일 발송");
		area = new JTextArea();
		
		setLayout(new FlowLayout());
		area.setPreferredSize(new Dimension(280,150));
		
		add(t_receiver);
		add(t_sender);
		add(t_title);
		add(area);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMail();
				
			}
		});
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void sendMail() {
		props = new Properties(); // Map 유형 중 하나!!
		props.put("mail.smtp.host","smtp.gmail.com"); //smtp 서버 주소 작성
		props.put("mail.smtp.port","465"); //smtp 서버 포트 번호
		props.put("mail.smtp.auth","true"); //권한 true
		props.put("mail.smtp.ssl.trust","smtp.gmail.com"); //SSL사용시
		
		//세션객체 생성 (java mail api에 Session 이라는 객체가 있다)
		Session session = Session.getDefaultInstance(props, new Authenticator() { //뒤에 오는건 내부익명
			//구글 개인설정에서 생성된 앱비밀번호를 메일에서 사용할 수 있다!
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kgsz1104@gmail.com","jajvluhczlhwauww");
			}
		
		}); 
		
		//메시지 구성 (메일로 보낼 내용 등 구성)
		MimeMessage message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(t_sender.getText())); // 발신자 정보
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(t_receiver.getText())); // 받는자 주소
			message.setSubject(t_title.getText()); // 메일 주소
			message.setContent(area.getText(), "text/html;charset=utf8"); //HTML을 지원하는 내용일 경우 인코딩 지정하자
			Transport.send(message); // 구성된 메시지 객체를 이용하여 전송시작!!
			JOptionPane.showMessageDialog(this, "메일 발송 성공");
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new MailSendApp();
	}
	
	
}
