package 실습;
import java.util.Scanner;
public class B05 {

	public static void main(String[] args) {
		int days;
		int seconds;
		int m_count;
		Scanner scan = new Scanner(System.in);

		System.out.println("날수를 입력하세요.");
		days=scan.nextInt();
		seconds=days*24*60*60;
		System.out.println("날수에 해당하는 기간은 모두 "+seconds+"초 입니다.");
		m_count=seconds/1000000;
		System.out.println("100만 초가 모두 "+m_count+"번이나 포함됩니다.");

	}

}
