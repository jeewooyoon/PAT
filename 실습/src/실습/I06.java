package 실습;
import java.util.Scanner;
import java.util.Random;
public class I06 {
	byte GetRandom() {
		Random rand = new Random();
		int r = rand.nextInt(100)+1;
		System.out.println("생성된 임의의 숫자는 "+r+" 입니다.");
		if(r>=70) {
			return 0;
		}else if(70>r&&r>=40) {
			return 1;
		}else {
			return 2;
		}
		
	}
	public static void main(String[] args) {
		int i;
		int arr[] = new int[3];
		arr[0]=0;
		arr[1]=0;
		arr[2]=0;
		I06 I = new I06();
		System.out.println("");
		for(i=0;i<10;i++) {
			int r=I.GetRandom();
			if(r==0) {
				arr[0]+=1; 
			}else if(r==1) {
				arr[1]+=1;
			}else {
				arr[2]+=1;
			}
		}
		System.out.println("1. 대(70이상) : "+arr[0]+"회 생성.");
		System.out.println("2. 대(40이상 70미만) : "+arr[1]+"회 생성.");
		System.out.println("3. 대(40미만) : "+arr[2]+"회 생성.");
	}

}
