package 실습;
import java.time.chrono.MinguoChronology;
import java.util.Scanner;
public class J02 {
	static double num[] = new double[10];
	double Max(double num[]) {
		double max=0.0;
		for(int i=0;i<10;i++) {
			if(num[i]>max) {
				max=num[i];
			}
			
		}
		return max;
		
	}
	double Min(double num[]) {
		double min=10.0;
		for(int i=0;i<10;i++) {
			if(num[i]<min) {
				min=num[i];
			}
			
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		J02 J = new J02();
		int i;
		double score=0;
		for(i=0;i<10;i++) {
			System.out.println((i+1)+"번 심사점수를 입력하시오.");
			num[i]=scan.nextDouble();
		}
		for(i=0;i<10;i++) {
			if(num[i]==J.Min(num)||num[i]==J.Max(num)) {
				;
			}else {
				score+=num[i];
			}
		}
		System.out.printf("가장 큰 점수와 가장 작은 점수를 제외한 8개의 점수에 대한 평균은 %.1f입니다.",score/8.0);
		
	}

}
