package 실습;
import java.util.Scanner;
public class B01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int birth_year;
		int age;

		System.out.println("태어난 년도를 입력하세요.");
		birth_year=scan.nextInt();
		age=2014-birth_year+1;
		if(age>=20) {
			System.out.println("미성년자가 아닙니다.");
		}else {
			System.out.println("미성년자 입니다.");
		}

	}

}
