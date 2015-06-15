package 시험공부;
import java.util.*;
public class H09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;
		
		String userInfo[];
		int i,j;
		
		while(true) {
			System.out.println("문자열을 입력하세요(x:종료)");
			input = scan.nextLine();
			if(input.equals("x")) {
				System.out.println("종료되었습니다.");
				break;
			}
			String userList[] = input.split("###");
			System.out.println("총 "+userList.length+"명이 등록되었습니다.");
			for(i=0;i<userList.length;i++) {
				userInfo = userList[i].split("\\|");
				System.out.println(i+1+" "+userInfo[0]+" "+userInfo[1]);
			}
			
		}
	}

}
