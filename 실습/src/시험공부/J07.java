package 시험공부;
import java.util.*;
public class J07 {
	int poweroftwo(int n) {
		if(n==0) {
			return 1;
		}else {
			return 2*poweroftwo(n-1);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		J07 j = new J07();
		int ans;
		while(true) {
			System.out.print("숫자를 입력.");
			ans=scan.nextInt();
			if(ans==0) {
				break;
			}
			System.out.println("2의 "+ans+"승은 :"+j.poweroftwo(ans));
		}
	}
}
