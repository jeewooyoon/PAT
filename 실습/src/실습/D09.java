package 실습;
import java.util.Scanner;
public class D09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i;
		int dan=1;
		while(dan<2||dan>9) {
			System.out.println("출력하고 싶은 구구단의 수를 입력.");
			dan = scan.nextInt();
			if(dan<2||dan>9){
				System.out.println("잘못 입력.");
			}
		}
		for(i=1;i<=9;i++) {
			System.out.println(dan+"x"+i+"="+dan*i);
		}
		

	}

}
