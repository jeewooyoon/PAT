package 시험공부;
import java.util.*;
public class H06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number[] = new int[5];
		int pow_value[][] = new int[5][5];
		int max = 0,min=707347971;
		int i,j;
		int max_a = 0,max_b = 0,min_a = 0,min_b = 0;
		
		System.out.println("2에서 9사이의 숫자 5개를 입력하시오.");
		for(i=0;i<5;i++) {
			number[i]=scan.nextInt();
		}
		for(i=0;i<5;i++) {
			for(j=0;j<5;j++) {
				pow_value[i][j]=(int) Math.pow(number[i],number[j]);
				if(pow_value[i][j]>max&&i!=j) {
					max=pow_value[i][j];
					max_a=number[i];
					max_b=number[j];
				}
				if(pow_value[i][j]<min&&i!=j) {
					min=pow_value[i][j];
					min_a=number[i];
					min_b=number[j];
				}
			}
		}
		System.out.println("입력하신 5개의 수로 제곱수를 만들면");
		System.out.println("가장 큰 수는 "+max_a+"의"+max_b+"승인"+max+"이다.");
		System.out.println("가장 작은 수는 "+min_a+"의"+min_b+"승인"+min+"이다.");
		
	}

}
