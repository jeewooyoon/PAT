package 실습;
import java.util.Scanner;
public class I02 {
	void PrintCharWithBlank(int blanks, int size, String ch) {
		int i,j;
		for(i=1;i<=size;i++) {
			for(j=1;j<=size+blanks;j++) {
				if(j>size+blanks-i) {
					System.out.print(ch);
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		I02 I = new I02();
		System.out.println("직각 삼각형을 그리는데 사용할 문자를 입력하세요.");
		String ch = scan.next();
		System.out.println("직각 삼각형의 높이와 왼쪽 여백의 크기를 입력하세요.");
		int size = scan.nextInt();
		int blanks = scan.nextInt();
		I.PrintCharWithBlank(blanks, size, ch);
	}

}
