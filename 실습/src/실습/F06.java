package 실습;
import java.util.Scanner;
public class F06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number[][]=new int [5][3];
		int newnum;
		int total=0;
		int i,j;
		
		for(i=0;i<5;i++) {
			for(j=0;j<3;j++) {
				System.out.print((i+1)+"0"+(j+1)+"호에 살고 있는 사람?");
				newnum = scan.nextInt();
				number[i][j]=newnum;
				total+=newnum;
			}
		}
		System.out.println("이 아파트에 살고있는 거주자는 모두"+total+"명 입니다.");

	}

}
