package 실습;
import java.util.Scanner;
public class A03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int width;
		int height;
		int area;

		System.out.println("직사각형의 가로 크기를 입력하시오.");
		width=scan.nextInt();
		System.out.println("직사각형의 세로 크기를 입력하시오.");
		height=scan.nextInt();
		area=width*height;

		System.out.println("직사각형의 넓이는 "+area+"입니다.");

	}

}
