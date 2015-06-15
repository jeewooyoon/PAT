package 실습;

import java.util.Scanner;

public class G01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int birth_year = 0;
		int age[] = new int[100];
		int count_person=0;
		int count_child=0;
		int count_baby=0;
		int count_youth=0;
		int count_young=0;
		int count_adult=0;
		int count_old=0;
		int i=0;
		
		do {
			
			System.out.print((i+1)+"번째 사람의 태어난 년도를 입력.");
			birth_year=scan.nextInt();
			age[i]=2012-birth_year+1;
			i++;
			count_person++;
		}while(2012>birth_year);
		
		for(i=0;i<count_person-1;i++) {
			System.out.println((i+1)+"번째 사람의 나이는 "+age[i]+"이다.");
			if(age[i]<7) {
				count_baby++;
			}else if(7<=age[i]&&age[i]<13) {
				count_child++;
			}else if(13<=age[i]&&age[i]<20) {
				count_youth++;
			}else if(20<=age[i]&&age[i]<30) {
				count_young++;
			}else if(30<=age[i]&&age[i]<60) {
				count_adult++;
			}else {
				count_old++;
			}
		}
		System.out.println("유아는 "+count_baby);
		System.out.println("어린이는 "+count_child);
		System.out.println("청소년은 "+count_youth);
		System.out.println("청년은  "+count_young);
		System.out.println("중년은  "+count_adult);
		System.out.println("노년은  "+count_old);
	}

}
