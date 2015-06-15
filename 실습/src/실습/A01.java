package 실습;
import java.util.Scanner;
public class A01 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int birth_year;
		int age;
		System.out.println("태어난 년도를 입력하시오.");
		birth_year=scan.nextInt();
		age=2014-birth_year+1;		
		System.out.println("당신의 나이는"+age+"살 입니다.");
	}

}
