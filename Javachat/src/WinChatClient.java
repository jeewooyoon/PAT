import java.awt.*;		
import java.awt.event.*;		
import java.net.*;		
import java.io.*;		
public class WinChatClient extends Frame implements ActionListener{		
	private TextField idTF = null;	
	private TextField input = null;	
	private TextArea display1 = null;	
	private TextArea display2 = null;	
	private TextArea display3 = null;	
		
	private CardLayout cardLayout = null;	
	private BufferedReader br = null;	
	private PrintWriter pw = null;	
	private Socket sock = null;	
	public WinChatClient(String ip){	
		super("채팅 클라이언트");
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		Panel loginPanel = new Panel();
		loginPanel.setLayout(new BorderLayout());
		loginPanel.add("North", new Label("아이디를 입력하신후 엔터를 입력하여 주세요."));
		idTF = new TextField(20);
		idTF.addActionListener(this);
		Panel c = new Panel();
		c.add(idTF);
		loginPanel.add("Center", c);
		add("login", loginPanel);
		Panel main = new Panel();
		main.setLayout(new GridLayout(2,2));
		input = new TextField();
		input.addActionListener(this);
		display1 = new TextArea();//그리드레이아웃으로 화면설정
		display1.setEditable(false);
		display2 = new TextArea();
		display2.setEditable(false);
		display3 = new TextArea();
		display3.setEditable(false);
		
		
		main.add( display1);
		main.add( display2);
		main.add( input);
		main.add( display3);
		setSize(100, 80);
		setVisible(true);
		add("main", main);	
		try{	
			sock = new Socket(ip, 10001);
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		}catch(Exception ex){	
			System.out.println("서버와 접속시 오류가 발생하였습니다.");
			System.out.println(ex);
			System.exit(1);
		}	
		setSize(500, 500);	
		cardLayout.show(this, "login");	
		addWindowListener(new WindowAdapter(){	
			public void windowClosing(WindowEvent e){
				pw.println("/quit");	
				pw.flush();	
				try{	
					sock.close();
				}catch(Exception ex){}	
				System.out.println("종료합니다.");	
				System.exit(0);	
			}		
		});			
		setVisible(true);			
	}				
					
					
	public static void main(String[] args) {				
		if(args.length != 1){			
			System.out.println("사용법 : java WinChatClient ip");		
			System.exit(1);	
		}		
		new WinChatClient(args[0]);		
	}			
				
public void actionPerformed(ActionEvent e) {			
	if(e.getSource() == idTF){		
		String id = idTF.getText();	
		if(id == null || id.trim().equals("")){	
			System.out.println("아이디를 다시 입력하여 주세.");
			return;
		}	
		pw.println(id.trim());	
		pw.flush();	
		WinInputThread wit = new WinInputThread(sock, br);	
		wit.start();	
		cardLayout.show(this, "main");		
		input.requestFocus();		
	}else if(e.getSource() == input){			
		String msg = input.getText();		
		pw.println(msg);		
		pw.flush();		
		if(msg.equals("/quit")){		
			try{	
				sock.close();
			}catch(Exception ex){}	
			System.out.println("종료합니다.");	
			System.exit(1);	
		}		
		input.setText("");		
		input.requestFocus();		
	}			
} // actionPerformed				
					
					
	class WinInputThread extends Thread{				
		private Socket sock = null;			
		private BufferedReader br = null;			
		public WinInputThread(Socket sock, BufferedReader br){			
			this.sock = sock;		
			this.br = br;		
		}			
		public void run(){			
			
			try{
				
				String line = null;	
				while((line = br.readLine()) != null){	
					if(line.indexOf("&")==0) {//우측상단에 유저리스트 띄우기
						display2.setText("");
						String userlist[] = line.substring(1).split("#");
						for(int i=0;i<userlist.length;i++) {
							display2.append(userlist[i]+"\n");
						}
					}else if(line.indexOf("*")==0) {//우측하단에 스팸리스트 띄우기
						display3.setText("");
						String spamlist[] = line.substring(1).split("%");
						for(int i=0;i<spamlist.length;i++) {
							display3.append(spamlist[i]+"\n");
						}
						
					}else {
						display1.append(line + "\n");
						
					}
					
				}
				
				
				
			}catch(Exception ex){			
			}finally{			
				try{		
					if(br != null)	
						br.close();
				}catch(Exception ex){}		
				try{		
					if(sock != null)	
						sock.close();
				}catch(Exception ex){}		
			}			
		} // InputThread				
	} // WinInputThread end					
} // WinChat Client class						
						
