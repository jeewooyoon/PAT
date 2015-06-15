package 시험공부;
import java.util.Scanner;
public class H08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;
		String split[];
		String findStr;
		String rePlaceStr;
		int i;
		
		while(true) {
			System.out.println("문자열을 입력하시오.");
			input = scan.nextLine();
			System.out.println("찾을 문자열을 입력하시오.");
			findStr = scan.nextLine();
			System.out.println("바꿀 문자열을 입력하시오.");
			rePlaceStr = scan.nextLine();
			
			System.out.println(input.replace(findStr,rePlaceStr));
			split = input.split(findStr);
			System.out.println(split.length-1);
		}
		

	}

}
