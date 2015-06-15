//한양대학교 에리카캠퍼스 컴퓨터공학과 14학번
//2014038122 윤지
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//2014038122 윤지우
import java.util.*;

public class ScoreManager {
	Scanner scan = new Scanner(System.in);
	String [] team_name={"삼성", "두산", "롯데", "SK", "한화", "넥센", "LG", "KIA", "NC", "KT"};
	int [] team_game_cnt = {0,0,0,0,0,0,0,0,0,0};
	int [] team_game_win = {0,0,0,0,0,0,0,0,0,0};
	int [] team_game_lose = {0,0,0,0,0,0,0,0,0,0};
	int [] team_game_draw = {0,0,0,0,0,0,0,0,0,0};
	int [] team_game_point = {0,0,0,0,0,0,0,0,0,0};
	int [][] home_scores = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
	int [][] away_scores = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
	double [] team_rate ={0,0,0,0,0,0,0,0,0,0}; 
	static int cnt=0;
	
	ArrayList<Score> al= new ArrayList<Score>();
	public ScoreManager() {
		// TODO Auto-generated constructor stub
	}
	public void addScore() {
		System.out.println("1)직접입력 2)데이터입력");
		int sl = scan.nextInt();
		if(sl==1) {
			cnt++;
			System.out.println("경기결과를 등록합니다.");
			System.out.println("경기일자를 입력하시오(ex:20140511)");
			String date = scan.next();
			System.out.println("경기팀 1)삼성, 2)두산, 3)롯데, 4)SK, 5)한화, 6)넥센, 7)LG, 8)KIA, 9)NC, 10)KT 중 두 팀을 선택하시오.");
			int team1,team2;
			while(true) {
				System.out.println("첫번째 경기팀 번호");
				team1 = scan.nextInt();
				if(team1>=1&&team1<=10) {
					break;
				}
				System.out.println("잘못입력하셨습니다. 다시입력.");
			}
			while(true) {
				System.out.println("두 번째 경기팀 번호");
				team2 = scan.nextInt();
				if(team2>=1&&team2<=10) {
					break;
				}
				System.out.println("잘못입력하셨습니다. 다시입력.");
			}
			System.out.println("첫번째 경기팀 점수");
			int team1_score = scan.nextInt();
			System.out.println("두번째 경기팀 점수");
			int team2_score = scan.nextInt();
			team_game_cnt[team1-1]++;
			team_game_cnt[team2-1]++;
			if(team1_score>team2_score) {
				team_game_win[team1-1]++;
				team_game_lose[team2-1]++;
				team_game_point[team1-1]+=3;
				team_rate[team1-1]=(double)(team_game_win[team1-1])/(double)(team_game_cnt[team1-1]);
				team_rate[team2-1]=(double)(team_game_win[team2-1])/(double)(team_game_cnt[team2-1]);
				home_scores[0][team1-1]++;
				away_scores[2][team2-1]++;
			}else if(team1_score<team2_score) {
				team_game_win[team2-1]++;
				team_game_lose[team1-1]++;
				team_game_point[team2-1]+=3;
				team_rate[team1-1]=(double)(team_game_win[team1-1])/(double)(team_game_cnt[team1-1]);
				team_rate[team2-1]=(double)(team_game_win[team2-1])/(double)(team_game_cnt[team2-1]);
				away_scores[0][team2-1]++;
				home_scores[2][team1-1]++;
			
			}else if(team1_score==team2_score) {
				team_game_draw[team1-1]++;
				team_game_draw[team2-1]++;	
				team_game_point[team1-1]+=1;
				team_game_point[team2-1]+=1;
				team_rate[team1-1]=(double)(team_game_win[team1-1])/(double)(team_game_cnt[team1-1]);
				team_rate[team2-1]=(double)(team_game_win[team2-1])/(double)(team_game_cnt[team2-1]);
				home_scores[1][team1-1]++;
				away_scores[1][team2-1]++;
			
			}
			
			al.add(new Score(cnt, team1, team2, team1_score, team2_score, date));
		}else if(sl==2) {
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("scoredata.txt"));
				String temp = null;
				try {
					while((temp = br.readLine())!=null) {
						cnt++;
						String[] data = temp.split(" ");
						String date=data[0];
						int team1 = 0,team2 = 0;
						for(int i=0;i<team_name.length;i++) {
							if(team_name[i].equals(data[1])) {
								team1 = i+1;
							}
							if(team_name[i].equals(data[5])) {
								team2 = i+1;
							}
						}
						int team1_score = Integer.parseInt(data[2]);
						int team2_score = Integer.parseInt(data[4]);
						team_game_cnt[team1-1]++;
						team_game_cnt[team2-1]++;
						if(team1_score>team2_score) {
							team_game_win[team1-1]++;
							team_game_lose[team2-1]++;
							team_game_point[team1-1]+=3;
							team_rate[team1-1]=(double)(team_game_win[team1-1])/(double)(team_game_cnt[team1-1]);
							team_rate[team2-1]=(double)(team_game_win[team2-1])/(double)(team_game_cnt[team2-1]);
							home_scores[0][team1-1]++;
							away_scores[2][team2-1]++;
						
						}else if(team1_score<team2_score) {
							team_game_win[team2-1]++;
							team_game_lose[team1-1]++;
							team_game_point[team2-1]+=3;
							team_rate[team1-1]=(double)(team_game_win[team1-1])/(double)(team_game_cnt[team1-1]);
							team_rate[team2-1]=(double)(team_game_win[team2-1])/(double)(team_game_cnt[team2-1]);
							away_scores[0][team2-1]++;
							home_scores[2][team1-1]++;
						
						}else if(team1_score==team2_score) {
							team_game_draw[team1-1]++;
							team_game_draw[team2-1]++;	
							team_game_point[team1-1]+=1;
							team_game_point[team2-1]+=1;
							team_rate[team1-1]=(double)(team_game_win[team1-1])/(double)(team_game_cnt[team1-1]);
							team_rate[team2-1]=(double)(team_game_win[team2-1])/(double)(team_game_cnt[team2-1]);
							home_scores[1][team1-1]++;
							away_scores[1][team2-1]++;
						
						}
						al.add(new Score(cnt, team1, team2, team1_score, team2_score, date));
						
						
					}
					br.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void modifyScore() {
		System.out.println("스코어를 수정하겠습니다.");
		System.out.println("경기번호를 입력하세요.");
		int n = scan.nextInt();
		System.out.println(n+"번 경기의 점수를 수정하겠습니다.");
		System.out.println("첫 번째 팀인 "+team_name[al.get(n-1).home_num-1]+" 팀의 점수를 입력하세요.");
		int score1 = scan.nextInt();
		System.out.println("두 번째 팀인 "+team_name[al.get(n-1).away_num-1]+" 팀의 점수를 입력하세요.");
		int score2 = scan.nextInt();
		if(al.get(n-1).home_score>al.get(n-1).away_score) {
			team_game_win[al.get(n-1).home_num-1]--;
			team_game_lose[al.get(n-1).away_num-1]--;
			team_game_point[al.get(n-1).home_num-1]-=3;
			
		}else if(al.get(n-1).home_score<al.get(n-1).away_score) {
			team_game_win[al.get(n-1).away_num-1]--;
			team_game_lose[al.get(n-1).home_num-1]--;
			team_game_point[al.get(n-1).away_num-1]-=3;
		
		}else if(al.get(n-1).home_score==al.get(n-1).away_score) {
			team_game_draw[al.get(n-1).home_num-1]--;
			team_game_draw[al.get(n-1).away_num-1]--;
			team_game_point[al.get(n-1).home_num-1]-=1;
			team_game_point[al.get(n-1).away_num-1]-=1;
		}
		al.get(n-1).change_score(score1, score2);
		if(score1>score2) {
			team_game_win[al.get(n-1).home_num-1]++;
			team_game_lose[al.get(n-1).away_num-1]++;
			team_game_point[al.get(n-1).home_num-1]+=3;
			team_rate[al.get(n-1).home_num-1]=(double)(team_game_win[al.get(n-1).home_num-1])/(double)(team_game_cnt[al.get(n-1).home_num-1]);
			team_rate[al.get(n-1).away_num-1]=(double)(team_game_win[al.get(n-1).away_num-1])/(double)(team_game_cnt[al.get(n-1).away_num-1]);
			
		}else if(score1<score2) {
			team_game_win[al.get(n-1).away_num-1]++;
			team_game_lose[al.get(n-1).home_num-1]++;
			team_game_point[al.get(n-1).away_num-1]+=3;
			team_rate[al.get(n-1).home_num-1]=(double)(team_game_win[al.get(n-1).home_num-1])/(double)(team_game_cnt[al.get(n-1).home_num-1]);
			team_rate[al.get(n-1).away_num-1]=(double)(team_game_win[al.get(n-1).away_num-1])/(double)(team_game_cnt[al.get(n-1).away_num-1]);
			
		}else if(score1==score2) {
			team_game_draw[al.get(n-1).home_num-1]++;
			team_game_draw[al.get(n-1).away_num-1]++;
			team_game_point[al.get(n-1).home_num-1]+=1;
			team_game_point[al.get(n-1).away_num-1]+=1;
			team_rate[al.get(n-1).home_num-1]=(double)(team_game_win[al.get(n-1).home_num-1])/(double)(team_game_cnt[al.get(n-1).home_num-1]);
			team_rate[al.get(n-1).away_num-1]=(double)(team_game_win[al.get(n-1).away_num-1])/(double)(team_game_cnt[al.get(n-1).away_num-1]);
			
		}
		
		
	}
	public void findScores(int no) {
		System.out.println("번호\t\t날짜\t홈팀\t어웨이팀");
		for(int i=0;i<al.size();i++) {
			if(no==al.get(i).home_num||no==al.get(i).away_num){
			System.out.println(al.get(i).num+"\t\t"+al.get(i).date+"\t"+team_name[al.get(i).home_num-1]+" "+al.get(i).home_score+":"+al.get(i).away_score+" "+team_name[al.get(i).away_num-1]);
			}
		}
		System.out.printf("%d승 %d무 %d패, 승점 %d 승률 %.2f\n",team_game_win[no-1],team_game_draw[no-1],team_game_lose[no-1],team_game_point[no-1],team_rate[no-1]*100);
	}
	public void findScores(String name) {
		int w = 0;
		for(int i=0;i<10;i++) {
			if(name.equals(team_name[i])) {
				w = i;
				break;
			}
		}
		for(int i=0;i<al.size();i++) {
			if(w+1==al.get(i).home_num||w+1==al.get(i).away_num){
			System.out.println(al.get(i).num+"\t\t"+al.get(i).date+"\t"+team_name[al.get(i).home_num-1]+" "+al.get(i).home_score+":"+al.get(i).away_score+" "+team_name[al.get(i).away_num-1]);
			}
		}
		System.out.printf("%d승 %d무 %d패, 승점 %d 승률 %.2f\n",team_game_win[w],team_game_draw[w],team_game_lose[w],team_game_point[w],team_rate[w]*100);
		
	}
	public void textScore() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("Scoredata1.txt",false));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw.write("팀이름\t승리\t무승부\t패배\t승률\t홈경기성적\t어웨이경기성적\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int j=0;j<10;j++) {
			
				try {
					String rate = String.format("%.3f", team_rate[j]);						
					bw.write(team_name[j]+"\t"+team_game_win[j]+"\t"+team_game_draw[j]+"\t"+team_game_lose[j]+"\t"+rate+"\t"+home_scores[0][j]+"-"+home_scores[1][j]+"-"+home_scores[2][j]+"\t"+away_scores[0][j]+"-"+away_scores[1][j]+"-"+away_scores[2][j]+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		}
			
	
		int win=0;
		int lose=0;
		int draw=0;
		int total_win=0;
		int total_lose=0;
		int total_draw=0;
		try {
			bw.write("\t삼성\t두산\t롯데\tSK\t한화\t넥센\tLG\tKIA\tNC\tKT\t합계\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int k=0;k<10;k++) {
			try {
				bw.write(team_name[k]+"\t");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int j=0;j<10;j++) {
				if(j!=k) {
					for(int i=0;i<al.size();i++) {
						if((al.get(i).home_num==k+1&&al.get(i).away_num==j+1)) {
							if(al.get(i).home_score>al.get(i).away_score) {
								win++;
								
							}else if(al.get(i).home_score<al.get(i).away_score) {
								lose++;
							}else if(al.get(i).home_score==al.get(i).away_score) {
								draw++;
							}
						}else if((al.get(i).home_num==j+1&&al.get(i).away_num==k+1)) {
							if(al.get(i).home_score<al.get(i).away_score) {
								win++;
							}else if(al.get(i).home_score>al.get(i).away_score) {
								lose++;
							}else if(al.get(i).home_score==al.get(i).away_score) {
								draw++;
							}
						}
					}
					total_win+=win;
					total_lose+=lose;
					total_draw+=draw;
					try {
						bw.write(win+"-"+draw+"-"+lose+"\t");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					win=0;
					lose=0;
					draw=0;
				}else {
					try {
						bw.write("x-x-x\t");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					win=0;
					lose=0;
					draw=0;
				}
				
			}
			try {
				bw.write(total_win+"-"+total_draw+"-"+total_lose+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			total_win=0;
			total_lose=0;
			total_draw=0;
			
		}

		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void listScores() {
		System.out.println("번호\t\t날짜\t\t홈팀\t어웨이팀");
		
		for (int i=0;i<al.size();i++) {
			System.out.println(al.get(i).num+"\t\t"+al.get(i).date+"\t"+team_name[al.get(i).home_num-1]+" "+al.get(i).home_score+":"+al.get(i).away_score+" "+team_name[al.get(i).away_num-1]);
		}
	}
	public void viewResult() {
		System.out.println("팀이름\t승리\t무승부\t패배\t승률");
		int max=0;
		int maxnum=0;
		for(int i=0;i<10;i++) {
			System.out.println(team_name[i]+"\t"+team_game_win[i]+"\t"+team_game_draw[i]+"\t"+team_game_lose[i]+"\t"+team_game_point[i]);
			if(max<team_game_point[i]) {
				max=team_game_point[i];
				maxnum=i;
			}
		}
		System.out.println("가장 승점이 높은 팀은 "+team_name[maxnum]+"입니다.");
		
	}
	public void viewMatchScore() {
		int win=0;
		int lose=0;
		int draw=0;
		int f,s;
		System.out.println("비교할 두팀을 선택하시오.");
		while(true) {
			System.out.println("비교주체 팀번호.");
			f = scan.nextInt();
			if(f>=1&&f<=10) {
				break;
			}
			System.out.println("잘못입력하셨습니다. 다시입력.");
		}
		while(true) {
			System.out.println("비교객체 팀번호.");
			s = scan.nextInt();
			if(s>=1&&s<=10) {
				break;
			}
			System.out.println("잘못입력하셨습니다. 다시입력.");
		}
		for(int i=0;i<al.size();i++) {
			if((al.get(i).home_num==f&&al.get(i).away_num==s)) {
				if(al.get(i).home_score>al.get(i).away_score) {
					win++;
				}else if(al.get(i).home_score<al.get(i).away_score) {
					lose++;
				}else if(al.get(i).home_score==al.get(i).away_score) {
					draw++;
				}
			}else if((al.get(i).home_num==s&&al.get(i).away_num==f)) {
				if(al.get(i).home_score<al.get(i).away_score) {
					win++;
				}else if(al.get(i).home_score>al.get(i).away_score) {
					lose++;
				}else if(al.get(i).home_score==al.get(i).away_score) {
					draw++;
				}
			}
		}
		System.out.println(team_name[f-1]+"의"+team_name[s-1]+"에 대한 상대전적"+win+"승 "+draw+"무 "+lose+"패 ");
	}
	public void start() {
		
		while(true) {
			System.out.println("1)스코어등록 2)스코어수정 3) 전체스코어출력 4)스코어검색 5) 경기통계 6)상대전적 7)텍스트출력 8)종료");
			System.out.println("번호를 선택해라.");
			int sel = scan.nextInt();
			if(sel==1) {
				addScore();
			}else if(sel==2) {
				modifyScore();
			}else if(sel==3) {
				listScores();
			}else if(sel==4) {
				System.out.println("1) 번호로 찾기 2) 팀이름으로 찾기");
				int selection = scan.nextInt();
				if(selection==1) {
					int nb;
					while(true) {
						System.out.println("팀번호 입력해라.");
						nb = scan.nextInt();
						if(nb>=1&&nb<=10) {
							break;
						}
						System.out.println("잘못입력하셨습니다. 다시입력.");
					}
					findScores(nb);
				}else if(selection==2) {
					String nb;
					int q=0;
					while(true) {
						System.out.println("팀이름 입력해라.");
						nb = scan.next();
						for(int j=0;j<10;j++) {
							if(team_name[j].equals(nb)) {
								q=1;
							}
						}
						if(q==1) {
							break;
						}
						System.out.println("잘못입력하셨습니다. 다시입력.");
					}
					findScores(nb);
				}
			}else if(sel==5) {
				viewResult();
			}else if(sel==6) {
				viewMatchScore();
			}else if(sel==7) {
				textScore();
			}else if(sel==8) {
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		ScoreManager m = new ScoreManager();
		m.start();
	}

}
