package L;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Random {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Container cn = jf.getContentPane();
		cn.add(new rand(), BorderLayout.CENTER);
		jf.setPreferredSize(new Dimension(300,300));
		
		jf.pack();
		jf.setVisible(true);

	}

}

class rand extends JLabel {
	public rand() {
		setLayout(new BorderLayout());
		int x = (int)(Math.random()*200)+50;
		int y = (int)(Math.random()*200)+50;
		JLabel r = new JLabel();
		
		r.setOpaque(true);
		r.setBackground(Color.BLUE);
		r.setLocation(x,y);
		r.setSize(10, 10);
		
		setVisible(true);
	}
	
}
