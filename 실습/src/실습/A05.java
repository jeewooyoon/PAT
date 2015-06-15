package 실습;
import java.util.Scanner;
public class A05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int days;
		int seconds;

		System.out.println("날 수를 입력하세요.");
		days=scan.nextInt();
		seconds=days*24*60*60;
		System.out.println("날 수에 해당되는 시간은 모두 "+seconds+"초입니다.");

	}

}
