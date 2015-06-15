package 실습;
import java.util.Scanner;
public class A07 {

	public static void main(String[] args) {
		int gigabytes;
		int megabytes;
		int kilobytes;
		long bytes;
		Scanner scan = new Scanner(System.in);

		System.out.println("파일 용량을 기가바이트 단위로 입력하세요.");
		gigabytes=scan.nextInt();
		megabytes=gigabytes*1024;
		kilobytes=megabytes*1024;
		bytes=kilobytes*1024L;
		System.out.println("입력하신 파일 용량은\n "+megabytes+" 메가바이트,\n "+kilobytes+" 킬로바이트,\n "+bytes+" 바이트 입니다.");

	}

}
