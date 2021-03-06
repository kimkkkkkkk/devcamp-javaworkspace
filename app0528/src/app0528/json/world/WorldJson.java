package app0528.json.world;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class WorldJson extends JFrame{
	JButton bt;
	JPanel p_south;
	Canvas can;
	JScrollPane scroll;
	FileReader reader;
	URL url;
	
	public WorldJson() {
		
		//생성
		bt = new JButton("Load");
		p_south = new JPanel();
		can = new Canvas(){
			
		};
		scroll = new JScrollPane();
		
		//스타일
		p_south.setPreferredSize(new Dimension(600,400));
		bt.setPreferredSize(new Dimension(200,25));
		can.setPreferredSize(new Dimension(570,310));
		can.setBackground(Color.RED);
		
		//조립
		p_south.add(bt);
		add(scroll);
		p_south.add(can);
		add(p_south, BorderLayout.NORTH);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		
		setBounds(400,0,700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void load() {
		try {
			url = this.getClass().getClassLoader().getResource("https://gist.githubusercontent.com/keeguon/2310008/raw/bdc2ce1c1e3f28f9cab5b4393c7549f38361be4e/countries.json");
			URI uri = url.toURI();
			File file = new File(uri);
			reader = new FileReader(file);
			System.out.println("스트림 생성 성공");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new WorldJson();
	}

}
