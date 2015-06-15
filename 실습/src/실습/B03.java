package 실습;
import java.util.Scanner;
public class B03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int width,height;
		int area;

		System.out.println("직사각형의 가로 크기를 입력하시오.");
		width=scan.nextInt();
		System.out.println("직사각형의 세로 크기를 입력하시오.");
		height=scan.nextInt();
		area=width*height;
		System.out.println("직사각형의 크기는 "+area+"이고,");
		if(width==height) {
			System.out.println("정사각형 입니다.");
		}else {
			System.out.println("정사각형이 아닙니다.");
		}


	}

}
