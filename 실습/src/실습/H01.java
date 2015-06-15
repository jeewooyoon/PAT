package 실습;
import java.util.Scanner;
import java.util.Random;
public class H01 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int rand_num=rand.nextInt(45)+1;
		int ans;
		int cnt=0;
		while(true) {
			System.out.println("1부터 100까지 숫자하나 맞춰봐라.");
			ans = scan.nextInt();
			cnt++;
			if(rand_num>ans) {
				System.out.println("좀 더 크다.");
			}else if(rand_num<ans) {
				System.out.println("좀 더 작다.");
			}else {
				break;
			}
		}
		System.out.println(cnt+"번만에 숫자를 맞췄습니다.");

	}

}
