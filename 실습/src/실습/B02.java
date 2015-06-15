package 실습;
import java.util.Scanner;
public class B02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double input_degree;
		String kind;
		double output_degree;

		System.out.println("온도를 입력하세요.");
		input_degree=scan.nextDouble();
		System.out.println("입력하신 온도가 섭씨온도이면 C를, 화씨온도이면 F를 입력하세요");
		kind=scan.next();
		if(kind.equals("C")) {
			output_degree=input_degree*1.8+32;
		}else {
			output_degree=(input_degree-32)/1.8;
		}
		System.out.println("변환된 온도는 "+output_degree+"입니다.");


	}

}
