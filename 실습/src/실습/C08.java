package 실습;
import java.util.Scanner;
public class C08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요.");
		int n1 = scan.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		int n2 = scan.nextInt();
		System.out.println("세번째 숫자를 입력하세요.");
		int n3 = scan.nextInt();
		int big,small;
		if(n1>n2) {
			if(n2>n3) {
				big=n1; small=n3;
			}else {
				if(n1>n3) {
					big=n1; small=n2;
				}else {
					big=n3; small=n2;
				}
			}
		}else {
			if(n2<n3) {
				big=n3; small=n1;
			}else {
				if(n1<n3) {
					big=n2; small=n1;
				}else {
					big=n2; small=n3; 
				}
			}
		}
		System.out.println("가장 큰 수는 "+big+"이고 가장 작은 수는 "+small+"이다.");

	}

}
