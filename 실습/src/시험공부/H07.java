package 시험공부;
import java.util.*;
public class H07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;
		int i;
		while(true) {
			System.out.print("문자열을 입력하세요 (x:종료)");
			input = scan.next();
			if(input.equals("x")) {
				System.out.println("종료되었습니다.");
				break;
			}
			for(i=0;i<input.length();i++) {
				System.out.println(input.charAt(i));
			}
		}
	}

}
