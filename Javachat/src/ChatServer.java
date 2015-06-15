import java.net.*;              
import java.io.*;               
import java.util.*;             
                 
public class ChatServer {               
                 
    public static void main(String[] args) {            
        try{        
            ServerSocket server = new ServerSocket(10001);  
            System.out.println("접속을 기다립니다.");   
            HashMap hm = new HashMap();
            HashSet<String> hs = new HashSet<String>(); //모두 같은 해쉬셋을 써야함.
            while(true){    
                Socket sock = server.accept();
                ChatThread chatthread = new ChatThread(sock, hm, hs);
                chatthread.start();
            } // while  
        }catch(Exception e){    
            System.out.println(e);
        }   
    } // main       
}           
             
class ChatThread extends Thread{            
    private Socket sock;        
    private String id;
    private BufferedReader br;      
    private HashMap hm;
    private HashSet<String> hs;
    private boolean initFlag = false;       
   
    public ChatThread(Socket sock, HashMap hm, HashSet hs){     
        this.sock = sock;   
        this.hm = hm;   
        this.hs = hs;
        try{    
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));   
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));  
            id = br.readLine(); 
            broadcast(id + "님이 접속하였습니다.");  
            System.out.println("접속한 사용자의 아이디는 " + id + "입니다."); 
            synchronized(hm){   
                hm.put(this.id, pw);
            }   
            people();//유저리스트
            spaming();//스팸리스트
            initFlag = true;    
        }catch(Exception ex){       
            System.out.println(ex); 
        }       
    } // 생성자            
    public void run(){          
        try{        
        	
            String line = null; 
            while((line = br.readLine()) != null){ 
            	if(line.equals("/quit"))    
                    break;
                else if(line.indexOf("/to ") == 0){  
                    sendmsg(line);
                }
                else if(line.equals("/list")) {
                	listmaker();
                }
                else if(line.indexOf("/addspam ")==0) {
                	int start = line.indexOf(" ") +1;            
                    String to = line.substring(start);
                    addspam(to);
                    spaming();
                }
                else if(line.equals("/listspam")) {
                	listspam();
                }
                
                else {
                	String spamword2=null;
                	String spamword = null;
                	int c=0;
                	Iterator<String> iter3 = hs.iterator();
                	while(iter3.hasNext()) {
                		spamword=iter3.next();
                		if(line.contains(spamword)) {
                			c++;
                			spamword2= spamword;
                			
                		}
                	}
                	if(c==0) {
                		TimeZone jst = TimeZone.getTimeZone ("JST");
                    	Calendar cal = Calendar.getInstance ( jst ); // 주어진 시간대에 맞게 현재 시각으로 초기화된 GregorianCalender 객체를 반환.// 또는 Calendar now = Calendar.getInstance(Locale.KOREA);
                    	if(cal.get(Calendar.HOUR_OF_DAY)>12) {
                    		int time = cal.get(Calendar.HOUR_OF_DAY)-12;
                    		broadcast("[ 오후"+time + "시 " +cal.get ( Calendar.MINUTE ) + "분 " + cal.get ( Calendar.SECOND ) + "초 "+"]"+id + " : " + line);
                    	}else {
                    		broadcast("[ 오전"+cal.get ( Calendar.HOUR_OF_DAY ) + "시 " +cal.get ( Calendar.MINUTE ) + "분 " + cal.get ( Calendar.SECOND ) + "초 "+"]"+id + " : " + line);
                    		
                    	}
                	}else {
                		synchronized(hm){  
                        	
                           
                                PrintWriter pw = (PrintWriter)hm.get(id);
                                pw.println("입력한 문자열에 금지어 ["+spamword2+"] 가 포함되어 전송하지 않았습니다. 조심하십시오.");
                                pw.flush();
                            
                    	}
                		
                	}
                	
                }
                	
                    
            }       
        }catch(Exception ex){           
            System.out.println(ex);     
        }finally{           
            synchronized(hm){       
                hm.remove(id);  
            }       
            people();
            broadcast(id + " 님이 접속 종료하였습니다.");      
            try{        
                if(sock != null)    
                    sock.close();
            }catch(Exception ex){}      
        }           
    } // run  
    public void addspam(String spam) {
    	
    	hs.add(spam);
    	synchronized(hm){  
        	Collection collection = hm.values();    
            Iterator iter = collection.iterator();  
            while(iter.hasNext()){  
                PrintWriter pw = (PrintWriter)iter.next();
                pw.println("금지어가 등록되었습니다. 금지어는 "+spam+"입니다.");
                pw.flush();
            }
    	}
    	
    	
    }//스팸추가명령어
    public void listspam() {
    	synchronized(hm){  
        	Collection collection = hm.values();    
            Iterator iter = collection.iterator();  
            while(iter.hasNext()){  
                PrintWriter pw = (PrintWriter)iter.next();
                int count=0;
                Iterator<String> iter2 = hs.iterator();
                pw.println("현재 추가된 금지어는 다음과 같습니다.");
                while(iter2.hasNext()) {
                	count++;
                	String key = iter2.next();
                	pw.println(count+"-"+key);
         
                }
                pw.println("총 "+count+"개 입니다.");
                pw.flush();
            }   
        }    
    }//스팸리스트명령어
    public void sendmsg(String msg){                
        int start = msg.indexOf(" ") +1;            
        int end = msg.indexOf(" ", start);          
        if(end != -1){          
            String to = msg.substring(start, end);      
            String msg2 = msg.substring(end+1);     
            Object obj = hm.get(to);        
            if(obj != null){        
                PrintWriter pw = (PrintWriter)obj;  
                pw.println(id + " 님이 다음의 귓속말을 보내셨습니다. :" + msg2);   
                pw.flush(); 
            } // if 
        }       
    } // sendmsg            
    public void broadcast(String msg){          
        synchronized(hm){       
            Collection collection = hm.values();    
            Iterator iter = collection.iterator();  
            while(iter.hasNext()){  
                PrintWriter pw = (PrintWriter)iter.next();
                pw.println(msg);
                pw.flush();
            }   
        }       
    } // broadcast
    public void listmaker(){          
        synchronized(hm){  
        	Collection collection = hm.values();    
            Iterator iter = collection.iterator();  
            while(iter.hasNext()){  
                PrintWriter pw = (PrintWriter)iter.next();
                int count=0;
                Set<String> keys = hm.keySet();
                Iterator<String> iter2 = keys.iterator();
                pw.println("[서버] 현재 사용자리스트는 다음과 같습니다.");
                while(iter2.hasNext()) {
                	count++;
                	String key = iter2.next();
                	pw.println(count+"-"+key);
         
                }
                pw.println("총 "+count+"명 입니다.");
                pw.flush();
            }   
        }       
    }//리스트명령어
    public void people() {
    	 synchronized(hm){  
         	 Collection collection = hm.keySet();    
             Iterator iter = collection.iterator();  
             String userlist = "&";
             while(iter.hasNext()){  
                 userlist += (String) iter.next() + "#";
             }   
             Collection collection1 = hm.values();    
             Iterator iter1 = collection1.iterator();  
             while(iter1.hasNext()){  
                 PrintWriter pw = (PrintWriter)iter1.next();
                 pw.println(userlist);
                 pw.flush();
             }   
             
         }
    }//유저리스트
    public void spaming() {
    	synchronized (hm) {
			Iterator iter = hs.iterator();
			String spamlist = "*";
			while(iter.hasNext()) {
				spamlist += (String) iter.next() + "%";
			}
			Collection collection1 = hm.values();    
            Iterator iter1 = collection1.iterator();  
            while(iter1.hasNext()){  
                PrintWriter pw = (PrintWriter)iter1.next();
                pw.println(spamlist);
                pw.flush();
            }   
    	}
    }
    //스팸리스트
}          