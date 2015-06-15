package 실습;
import java.util.Scanner;
public class B06 {

	public static void main(String[] args) {
		int kor,eng,math;
		int total;
		double average;
		Scanner scan = new Scanner(System.in);

		System.out.println("국어 점수를 입력하시오.");
		kor=scan.nextInt();
		System.out.println("영어 점수를 입력하시오.");
		eng=scan.nextInt();
		System.out.println("수학 점수를 입력하시오.");
		math=scan.nextInt();
		total=kor+eng+math;
		average=total/3.0;
		System.out.println("입력하신 점수의 총점은 "+total+"이고,");
		System.out.printf("평균은 %.1f 입니다.\n",average);
		if(kor>=90) {
			System.out.println("국어 점수가 우수합니다.");
		}if(eng>=90) {
			System.out.println("영어 점수가 우수합니다.");
		}if(math>=90) {
			System.out.println("수학 점수가 우수합니다.");
		}
	}

}
