//한양대학교 에리카캠퍼스 컴퓨터공학과 14학번
//2014038122 윤지우
public class Score {
	int num;
	String date;
	int home_num;
	int away_num;
	int home_score;
	int away_score;
	Score(int num, int home_num, int away_num, int home_score, int away_score, String date) {
		this.num=num;
		this.home_num=home_num;
		this.home_score=home_score;
		this.away_num=away_num;
		this.away_score=away_score;
		this.date=date;
	}
	public void change_score(int n1, int n2) {
		this.home_score=n1;
		this.away_score=n2;
	}//점수 수정 메소드
	

}
