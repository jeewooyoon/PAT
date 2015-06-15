package scoreGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.StyleContext.SmallAttributeSet;


public class TextForm extends JPanel {
	//TextField를 위한 배열선언 
	static String [] team_name={"삼성", "두산", "롯데", "SK", "한화", "넥센", "LG", "KIA", "NC", "KT"};
	private JTextField[] fields;
	
	// TextForm 생성자 메소드
	public TextForm(String[] labels, int[] widths) {
		super(new BorderLayout());
		//label(date,home,away,home_score,away_score)를 위한 panel 생성  
		JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
		//TextField(입력필드)를 위한 Panel 생성 
		JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
		//왼쪽 정렬로 label panel 추가 
		add(labelPanel, BorderLayout.WEST);
		//가운데에 정렬로 field panel 추가 
		add(fieldPanel, BorderLayout.CENTER);
		//fileds 배열 크기 할당 
		fields = new JTextField[labels.length];
		//반복문사용하여 label이랑 값 입력 받기위한 textfield 추가 
		for (int i = 0; i < labels.length; i += 1) {
			fields[i] = new JTextField();
			if (i < widths.length)
				fields[i].setColumns(widths[i]);
			JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
			lab.setLabelFor(fields[i]);
			labelPanel.add(lab);
			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p.add(fields[i]);
			fieldPanel.add(p);
		}
	}

	//textfields에서 사용자가 입력한 값을 받아오기위한 함수  
	public String getText(int i) {
		return (fields[i].getText());
	}

	public static void main(String[] args) {
		ArrayList<Score> sl = new ArrayList<Score>();
		String[] team_names = { "삼성", "두산", "롯데", "SK", "한화", "넥센", "LG",
				"KIA", "NC", "KT" };
		int[] no_team_plays = new int[10];
		int[] no_team_wins = new int[10];
		int[] no_team_loses = new int[10];
		int[] no_team_draws = new int[10];
		double[] no_team_ratios = new double[10];
		ScoreManager sm = new ScoreManager(sl, team_names, no_team_plays,
				no_team_wins, no_team_loses, no_team_draws, no_team_ratios);
		//labels 배열 
		String[] labels = { "date", "home", "away", "home_score", "away_score" };
		//textfield의 크기를 위한 배열 
		int[] widths = { 15, 10, 10, 5, 5 };

		//위의 labels와 width를 가지고 textform 생성 
		final TextForm form = new TextForm(labels, widths);
		
		//JButton (add button) 생성  
		JButton submit = new JButton("add");

		//add button에 대한  action event listener 추가 
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				String date = form.getText(0);
				String home_team = form.getText(1);
				String away_team = form.getText(2);
				int home_score = Integer.parseInt(form.getText(3));
				int away_score = Integer.parseInt(form.getText(4));
				
				Score a = new Score(sm.get_sl().size()+1, date, sm.get_team_number(home_team), sm.get_team_number(away_team), home_score, away_score);
				
				sm.get_sl().add(a);
				System.out.println(" date : " + form.getText(0)
						+ "\n home team: " + form.getText(1)
						+ "\n away_team : " + form.getText(2)
						+ "\n home score: " + form.getText(3)
						+ "\n away_score : " + form.getText(4));
			}
		});
		//JButton (open  button) 생성
		//위와 마찬가지로 action event listener 추가 
		JButton open = new JButton("open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				System.out.println("open button");
				BufferedReader br = null;
				try {

					String sCurrentLine;
					br = new BufferedReader(new FileReader("/Users/JEEWOOYOON/scoredata.txt"));
					while ((sCurrentLine = br.readLine()) != null) {
						String[] info = sCurrentLine.split(" ");
						int h_score = Integer.parseInt(info[2]);
						int a_score = Integer.parseInt(info[4]);
						Score a = new Score(sm.get_sl().size() + 1, info[0],
								sm.get_team_number(info[1]),
								sm.get_team_number(info[5]), h_score, a_score);
						sm.add_score(a);
						
					}
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			}
		});
		// JButton (save button) 생성
		// action event listener 추가 
		JButton save = new JButton("save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				int cnt=0;
				System.out.println("save button");
				try {
					String sr = "";
					PrintWriter bw = new PrintWriter(new FileWriter("/Users/JEEWOOYOON/scoredata2.txt"));
					while (cnt<sm.get_sl().size()) {
						sr = sm.get_sl().get(cnt).play_date_+"\t"+sm.get_team_name(sm.sl_.get(cnt).home_no_)+"\t"+sm.sl_.get(cnt).home_score_+"\t:\t"+sm.sl_.get(cnt).away_score_+"\t"+sm.get_team_name(sm.sl_.get(cnt).away_no_);
						bw.println(sr);
						cnt++;
					}
					bw.close();
				} catch (IOException e3) {
					System.out.println(e3);
					e3.printStackTrace();
				}
				//try {
					
				//} catch (IOException e1) {
					// TODO Auto-generated catch block
			//		e1.printStackTrace();
				//}
				
			}
		});
		//GUI packing과 버튼 추가
		JFrame f = new JFrame("Text Form Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(form, BorderLayout.NORTH);
		JPanel p = new JPanel();
		p.add(open);
		p.add(submit);
		p.add(save);
		f.getContentPane().add(p, BorderLayout.SOUTH);
		f.pack();
		f.setSize(300, 300);
		f.setVisible(true);
	}
}