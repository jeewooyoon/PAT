package 실습;
import java.util.Scanner;
public class H09 {

	public static void main(String[] args) {
		  Scanner s = new Scanner(System.in);
	      String input;
	      String userList[];
	      String userInfo[];
	      int i,j;
	      while(true){
	         System.out.println("문자열을 입력하세요(x: 종료) :");
	         input = s.next();
	         if (input.equals("x")){
	            break;
	         }
	         
	         userList = input.split("###");
	         System.out.println("총"+userList.length+"명이 등록되었습니다.");
	         for(i=0;i<userList.length;i++){
	            userInfo = userList[i].split("\\|");
	            System.out.print(i+1+" ");
	            for(j=0;j<2;j++){
	               System.out.print(userInfo[j]+" ");
	            }
	            System.out.println();
	         }
	      }
	}

	
	
}

