package library2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookObjectOutputTest{

	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		ArrayList list = new ArrayList();
		Book b1 = new Book("a0001", "홍길동전", "허균", 10000);
		Book b2 = new Book("a0002", "신나는장례식", "구치훈", 20000);
		Book b3 = new Book("a0003", "400원입니당", "안세영", 25000);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		 
		try{
			fout = new FileOutputStream("booklist2.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.reset();
			oos.writeObject(list);
			oos.reset();
			
			System.out.println("저장되었습니다.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} // finally
	} // main end
} // class end
