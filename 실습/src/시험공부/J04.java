package 시험공부;
import java.util.*;
public class J04 {
	int CalcDate(int month, int day) {
		int dates=0;
		int monthdays [] = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=month-2;i>=0;i--) {
			dates+=monthdays[i];
		}
		dates+=day;
		
		return dates;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		J04 j = new J04();
		System.out.print("첫 번째 날짜를 입력.");
		int m1 = scan.nextInt();
		int d1 = scan.nextInt();
		System.out.print("두 번째 날짜를 입력.");
		int m2 = scan.nextInt();
		int d2 = scan.nextInt();
		System.out.println("두 날짜의 간격은 "+Math.abs(j.CalcDate(m2, d2)-j.CalcDate(m1, d1))+"일 입니다.");
		
	}

}
