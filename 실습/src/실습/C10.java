package 실습;
import java.util.Scanner;
public class C10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1,n2;
		int result;
		System.out.println("숫자1을 입력하시오.");
		n1 = scan.nextInt();
		System.out.println("숫자2 입력하시오.");
		n2 = scan.nextInt();
		System.out.println("연산기호문자('+','-','*','/'중에 하나를 입력.)");
		String operator = scan.next();
		if(operator.equals("+")) {
			result = n1+n2;
		}else if(operator.equals("-")) {
			result = n1-n2;
		}else if(operator.equals("*")) {
			result = n1*n2;
		}else {
			result = n1/n2;
		}
		System.out.println("계산식의 결과 값은"+result+"입니다.");
	}
}
