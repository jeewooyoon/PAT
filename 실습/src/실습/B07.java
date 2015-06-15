package 실습;
import java.util.Scanner;
public class B07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int megabytes;
		long bytes;
		String usb2;
		long time;

		System.out.println("파일 용량을 메가바이트 단위로 입력.");
		megabytes=scan.nextInt();
		bytes=megabytes*1024*1024;
		System.out.println("USB포트가 2.0이면 Y, 아니면 N을 입력하세요.");
		usb2=scan.next();
		if(usb2.equals("Y")) {
			time=bytes/60000000;
		}else {
			time=bytes/1500000;
		}
		System.out.println("파일 전송 시간은 "+time+"초 입니다."); 

	}

}
