package JavaProject.tour.imagetest;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ButtonCenter extends JFrame {
	ButtonCenter(String title) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton jb = new JButton("Ok", new ImageIcon("C:\\korea202102_javaworkspace\\javaproject\\res\\lo.jpg"));
    jb.setHorizontalAlignment(SwingConstants.LEFT);
    jb.setMnemonic('O');

    getContentPane().add(jb, BorderLayout.CENTER);

    jb = new JButton("<html><i>Cancel</i></html>");
    jb.setVerticalAlignment(SwingConstants.BOTTOM);

    jb.setDefaultCapable(true);

    getContentPane().add(jb, BorderLayout.EAST);

    getRootPane().setDefaultButton(jb);

    setSize(1300, 500);
    setVisible(true);
  }

  public static void main(String[] args) {
    new ButtonCenter("Button Demo");
  }
}
