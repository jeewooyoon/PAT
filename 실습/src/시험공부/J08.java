package 시험공부;
import java.util.*;
public class J08 {
	int Ackermann(int i, int j) {
		if(i==0&&j>=0) {
			return j+1;
		}else if(i>0&&j==0) {
			return Ackermann(i-1, 1);
		}else {
			return Ackermann(i-1, Ackermann(i, j-1));
		}
	}
	public static void main(String[] args) {
		J08 j1 = new J08();
		int i,j;
		for(i=0;i<=3;i++) {
			for(j=0;j<=3;j++) {
				System.out.println(j1.Ackermann(i,j));
			}
		}
	}

}
