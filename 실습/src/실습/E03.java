package 실습;
import java.util.Scanner;
public class E03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int height;
		int i,j;
		
		System.out.print("이등변 삼각형의 높이를 입력하시오.");
		height = scan.nextInt();
		
		for(i=0;i<height;i++) {
			for(j=1;j<=height*2;j++) {
				if(j==height || (j>=height-i && j<=height+i)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
