package 실습;
import java.util.Scanner;
public class B04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double m2_area;
		double pyung_area;

		System.out.println("아파트의 분양 면적(제곱미터)을 입력하시오.");
		m2_area=scan.nextDouble();
		pyung_area=m2_area/3.305;
		System.out.printf("아파트의 평형은 %.1f이고,\n",pyung_area);
		if(pyung_area>=30) {
			System.out.println("30평 이상이므로 큰 아파트 입니다.");
		}else {
			System.out.println("30평 미만이므로 작은 아파트 입니다.");
		}
	}

}
