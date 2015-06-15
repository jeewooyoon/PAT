package 실습;

import java.util.Scanner;

public class I01 {
	void ShowMenu() {
		System.out
				.println("1. 피자(15,000원), 2. 스파게티(10,000원), 3. 샐러드(7,000원), 4. 음료수(2,000원), 5. 종료");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		I01 I = new I01();
		int total = 0;
		while (true) {
			I.ShowMenu();
			System.out.print("메뉴를 선택해주세요.(종료 : 5)");
			int menu = scan.nextInt();
			
			if (menu == 1) {
				total += 15000;
			} else if (menu == 2) {
				total += 10000;
			} else if (menu == 3) {
				total += 7000;
			} else if (menu == 4) {
				total += 2000;
			} else {
				break;
			}
			System.out.println("현재까지의 주문 금액은 "+total+"원 입니다.");
		}
		System.out.println("총 주문 금액은 "+total+"원 입니다.");
	}

}
