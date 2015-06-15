package 실습;
import java.util.Scanner;
public class B09 {

	public static void main(String[] args) {
		double height,weight;
		
		double bmi;
		Scanner scan = new Scanner(System.in);
		System.out.println("신장(cm)을 입력하시오");
		height=scan.nextInt();
		height=height/100.0;
		System.out.println("체중(kg)을 입력하시오");
		weight=scan.nextInt();
		bmi=weight/(height*height);
		System.out.println(height*height);
		if(bmi>=25) {
			System.out.println("당신은 비만이십니다");
		}else {
			System.out.println("당신은 비만이 아니군요");
		}

	}

}
