package 실습;
import java.util.Scanner;
public class F02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double score[] = new double[10];
		double max=0.0;
		double min=10.0;
		double total=0.0;
		double average=0.0;
		int i;
		
		for(i=0;i<10;i++) {
			System.out.print((i+1)+"번 심사점수를 입력하세요.");
			score[i]=scan.nextDouble();
			if(max<score[i]) {
				max=score[i];
			}
			if(min>score[i]) {
				min=score[i];
			}
		}
		
		for(i=0;i<10;i++) {
			if(score[i]==max || score[i]==min) {
				score[i]=0;
			}
			total+=score[i];
		}
		average=total/8.0;
		System.out.printf("8개의 점수에 대한 평균은 %.1f 입니다.\n",average);

	}

}
