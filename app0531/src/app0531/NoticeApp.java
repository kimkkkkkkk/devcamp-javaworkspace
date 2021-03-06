package app0531;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;



//공지게시판 구현하기
public class NoticeApp extends JFrame { // 귀는 귀인데 테이블 데이터가 변하는지 감지하겠다~
	//서쪽영역
	JPanel p_west;
	JTextField t_title;
	JTextField t_writer;
	JTextField t_content;
	JButton bt_regist;
	
	//센터영역
	JPanel p_center;
	JTable table;
	JScrollPane scroll;
	JPanel p_south;
	JButton bt_del;
	JButton bt_list; // 게시판 목록 버튼
	JButton bt_member; // 회원목록 버튼
	
	//데이터 베이스 관련
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	Connection con; // import sql꺼 갖고 오기 , mysql 말구
	NoticeModel model; //멤버변수로 보유
	
	public NoticeApp() {
		
		
		//생성
		p_west = new JPanel();
		t_title = new JTextField(16);
		t_writer = new JTextField(16);
		t_content = new JTextField(16);
		bt_regist = new JButton("등록");
		
		p_center = new JPanel();
		table = new JTable(); // TableModel 이용할 예정 .java로 뺴서 처리해보자, 따로 파일 뺴고 멤버변수 보유하기 위에
																			
		scroll = new JScrollPane(table);
		p_south = new JPanel();
		bt_del = new JButton("삭제");
		bt_list = new JButton("게시판목록");
		bt_member = new JButton("회원 목록");
		
		
		//스타일
		p_west.setPreferredSize(new Dimension(200,450));
		p_west.setBackground(Color.ORANGE);
		p_center.setLayout(new BorderLayout());
		
		//조립
		p_west.add(t_title);
		p_west.add(t_writer);
		p_west.add(t_content);
		p_west.add(bt_regist);
		add(p_west, BorderLayout.WEST);
		
		p_center.add(scroll);
		p_center.add(p_south, BorderLayout.SOUTH);
		p_south.add(bt_del);
		p_south.add(bt_list);
		p_south.add(bt_member);
		p_center.add(p_south, BorderLayout.SOUTH);
		add(p_center, BorderLayout.SOUTH);
		add(p_center);
		
		
		//이벤트
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로세스 종료
				release(con);
			}
		
		});
		
		//등록버튼 구현
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
				getList(); // 목록 가져오기
				table.updateUI();
			}
		});
		
		//게시판목록버튼 구현
		bt_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList(); // 목록 가져오기
				table.updateUI();
			}
		});
	
		//회원목록버튼 구현
		bt_member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMemberList(); // 목록 가져오기
				table.updateUI();
			}
		});
		
		setBounds(0,100,600,450);
		setVisible(true);
		
		//디자인이 모두 완성된 후에 connect() 부르기
		connect(); // 2) 디비 접속하기

	
	}
	
	//mysql 접속
	public void connect() {
		/*
		 * 1)드라이버 로드
		 * 2)접속
		 * 3)쿼리수행
		 * 4)접속 끊기
		 * */
		try {
			Class.forName("com.mysql.jdbc.Driver"); //1)드라이버 로드
			con=DriverManager.getConnection(url, user, password); //2) 접속
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				JOptionPane.showMessageDialog(this,"DB에 접속할 수 없습니다");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Create(=insert) Read(=select) Update Delete
	//등록
	public void regist() {
		String sql="insert into notice(title,writer,content) values(?,?,?)";
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, t_title.getText());
			pstmt.setString(2, t_writer.getText());
			pstmt.setString(3, t_content.getText());
			int result=pstmt.executeUpdate();
			if(result==1) {
				JOptionPane.showMessageDialog(this, "등록성공");
			}else {
				JOptionPane.showMessageDialog(this, "등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(pstmt);
		}
	}
	
	
	//목록
	public void getList() {
		String sql="select * from notice order by notice_id desc";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData meta; //컬럼 정보 등을 가져오기 위한 객체
		model = new NoticeModel();
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();// 쿼리수행 후 
			meta = rs.getMetaData(); // rs가 태어나야 메타정보를 얻을 수 있다!!
			
			//컬럼의수, 컬럼의 이름 구해서 모델에 적용해보기!
			//noticemodel에서 vector column이 기다리고 있어서 이것을 구하는 것임.
			int col_count = meta.getColumnCount(); // 컬럼수
			//meta.getColumnName; -> 이거 갖다대보면 0부터가 아니라 1부터 시작하라고 나와있음
			for(int i=1;i<=col_count;i++) {
				String name=meta.getColumnName(i);
				System.out.println(name);
				model.column.add(name); //모델객체가 보유한 벡터에 컬럼명 추가!!
			}
			
			while(rs.next()) { // 커서 한칸 전진  db 테이블상 목록줄? 건너띄고 시작하기 떄문
				Notice notice = new Notice();//게시물 한건을 담게될 VO 생성 empty 상태임
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setHit(rs.getInt("hit"));
				notice.setRegdate(rs.getString("regdate"));
				
				model.data.add(notice);//한건의 레코드를 담은 VO를 백터에 추가하자
			}
			//Model에 들어있는 메서드들은, Table에 해당 모데 적용시점에 호출되는 것을 알 수 있다.
			//이때 JTable 원하는 정보를 모델로부터 얻어간다!
			table.setModel(model); // JTable의 생성자에서 모델을 결정하는게 아니라, 생성된 모델중 원하는 모델을
											 // 테이블에 적용시키고 싶을때
			table.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(pstmt,rs);
		}
		
	}
	
	//수정
	
	//삭제
	
	//회원목록 가져오기
	public void getMemberList() {
		String sql="select * from member";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ResultSetMetaData meta = null;
		MemberModel memberModel = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			meta = rs.getMetaData();
			memberModel = new MemberModel();
			
			//컬럼 정보 채우기
			for(int i =1;i<meta.getColumnCount();i++) {
				String name = meta.getColumnName(i);
				memberModel.column.add(name); // 컬럼구성
			}
			
			//레코드 채우기
			while(rs.next()) {
				Member member = new Member(); //empty상태의 VO상태
				member.setMember_id(rs.getInt("member_id"));
				member.setUser_id(rs.getString("user_id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
				
				memberModel.data.add(member);
			}
			table.setModel(memberModel); // JTable에 모델 적용, 이 순간부터 JTable은 Model의
														 // 메서드 호출하여, 데이터를 채워나간다!!
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(pstmt, rs);
		}
	}
	
	
	public void release(Connection con) { //4)접속 끊기
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void release(PreparedStatement pstmt) { //4)접속 끊기
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void release(PreparedStatement pstmt, ResultSet rs) { //4)접속 끊기
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new NoticeApp();
	}

}

