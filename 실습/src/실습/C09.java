package 실습;
import java.util.Scanner;
public class C09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tax;
		System.out.println("연봉을 숫자로 입력하세요 ");
		int income=scan.nextInt();
		if(income<10000000) {
			tax = (int) (income*0.095);
		}else if(income>=10000000&&income<40000000) {
			tax = (int)(income*0.19);
		}else if(income>=40000000&&income<80000000) {
			tax = (int)(income*0.28);
		}else {
			tax = (int)(income*0.37);
		}
		
		System.out.println("연봉금액에 대한 소득세는 "+tax+"원 입니다.");
	}

}
