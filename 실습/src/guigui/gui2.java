package guigui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class gui2 {

	public static void main(String[] args) {
		
		JFrame jf =  new JFrame();
		Container cn = jf.getContentPane();
		
		cn.add(new GL(), BorderLayout.CENTER);
		jf.setPreferredSize(new Dimension(500,300));
		
		jf.pack();
		
		jf.setVisible(true);

	}

}

class GL extends JPanel {
	public GL() {
		setLayout(new GridLayout(4,4));
		
		setSize(300, 200);
		setVisible(true);
	}
}
