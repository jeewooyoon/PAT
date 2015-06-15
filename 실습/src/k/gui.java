package k;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class North extends JPanel {
	public North() {
		setLayout(new FlowLayout());
		add(new JButton("open"));
		add(new JButton("read"));
		add(new JButton("close"));
		setSize(300, 200);
		setBackground(Color.LIGHT_GRAY);
		setVisible(true);
	}
}

class Center extends JPanel {
	public Center() {
		setLayout(new BorderLayout());
		add(new JLabel("                        aa"), BorderLayout.NORTH);
		add(new JLabel("               love"), BorderLayout.CENTER);
		add(new JLabel("java"), BorderLayout.SOUTH);
		setSize(300, 200);
		setVisible(true);
	}
}

public class gui {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Container cn = jf.getContentPane();
		
		cn.add(new North(), BorderLayout.NORTH);
		cn.add(new Center(), BorderLayout.CENTER);
		
		jf.setPreferredSize(new Dimension(500,300));
		
		jf.pack();
		jf.setVisible(true);
		
		
	}

}
