package 실습;
import java.util.Scanner;
public class C07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("파일용량을 메가바이트 단위로 입력하시오");
		int megabytes = scan.nextInt();
		long bytes=megabytes*1024*1024;
		System.out.println("전송방식을 1:와이파이 2:블루투스 3:엘티이 4:유에스비 에서 선택하시오 ");
		byte kind = scan.nextByte();
		double time;
		if(kind==1) {
			time=bytes/1500000.0;
		}else if(kind==2) {
			time=bytes/300000.0;
		}else if(kind==3) {
			time=bytes/1000000.0;
		}else {
			time=bytes/60000000.0;
		}
		System.out.printf("파일 전송 시간은 %.1f이다.",time);
	}

}
