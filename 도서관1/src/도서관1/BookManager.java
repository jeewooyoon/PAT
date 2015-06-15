package 도서관1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class BookManager {
	public BookManager() {
		// TODO Auto-generated constructor stub
	}
	Scanner scan = new Scanner(System.in);
	int cnt=0;
	ArrayList<Book> bookList = new ArrayList<Book>();
	public void input() {
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);
			
			bookList = (ArrayList)ois.readObject();
			cnt=bookList.size();
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} // finally
	}
	public void addBook() {
		System.out.println("도서를 추가하겠습니다.");
		System.out.println("isbn을 입력하시오.");
		String isbn=scan.next();
		System.out.println("제목을 입력하시오.");
		String title=scan.next();
		System.out.println("저자를 입력하시오.");
		String author=scan.next();
		System.out.println("가격을 입력하시오.");
		int price=scan.nextInt();
		System.out.println("출판년도를 입력하시오.");
		int pub_year=scan.nextInt();
		System.out.println("출판사를 입력하시오.");
		String pub_company=scan.next();
		System.out.println("인기도를 입력하시오.(1:최악 2:조금미흡 3:보통 4:우수 5:최고)");
		int pop=scan.nextInt();
		
		bookList.add(new Book(isbn, title, author, price, pub_year, pub_company, pop));
		cnt++;
		
		System.out.println("도서가 추가 되었습니다.");
	}
	public void modifyBook() {
		System.out.println("도서정보를 변경하겠습니다.");
		System.out.println("변경하고 싶으신 도서의 제목을 입력해주십시오.");
		String title = scan.next();
		for(int i=0;i<cnt;i++) {
			if(bookList.get(i).getTitle().equals(title)) {
				System.out.println("변경하실 항목을 입력해주세요. 1)isbn 2)제목 3)저자 4)가격 5)출판년도 6)출판사 7)인기도(1~5)");
				int select = scan.nextInt();
				if(select==1) {
					System.out.println("변경하실 isbn을 입력해주세요.");
					String isbn = scan.next();
					bookList.get(i).setIsbn(isbn);
					System.out.println("변경되었습니다.");
				}else if(select==2) {
					System.out.println("변경하실 제목을 입력해주세요.");
					String title_ = scan.next();
					bookList.get(i).setTitle(title_);
					System.out.println("변경되었습니다.");
				}else if(select==3) {
					System.out.println("변경하실 저자를 입력해주세요.");
					String author = scan.next();
					bookList.get(i).setAuthor(author);
					System.out.println("변경되었습니다.");
				}else if(select==4) {
					System.out.println("변경하실 가격을 입력해주세요.");
					int price = scan.nextInt();
					bookList.get(i).setPrice(price);
					System.out.println("변경되었습니다.");
				}else if(select==5) {
					System.out.println("변경하실 출판년도를 입력해주세요.");
					int pub_year = scan.nextInt();
					bookList.get(i).setYear(pub_year);
					System.out.println("변경되었습니다.");
				}else if(select==6) {
					System.out.println("변경하실 출판사를 입력해주세요.");
					String pub_company = scan.next();
					bookList.get(i).setCompany(pub_company);
					System.out.println("변경되었습니다.");
				}else if(select==7) {
					System.out.println("변경하실 인기도를 입력해주세요.");
					int pop = scan.nextInt();
					bookList.get(i).setPop(pop);
					System.out.println("변경되었습니다.");
				}
				break;
			}
		}
	}
	public void deleteBook() {
		System.out.println("도서를 삭제하겠습니다.");
		System.out.println("삭제하실 도서의 제목을 입력해주세요.");
		String title = scan.next();
		for(int i=0;i<cnt;i++) {
			if(bookList.get(i).getTitle().equals(title)) {
				bookList.remove(i);
				cnt--;
				System.out.println("삭제되었습니다.");
				break;
			}
		}
		
	}
	public void searchBook() {
		System.out.println("도서를 검색하겠습니다.");
		System.out.println("검색하실 항목을 선택하세요.(1:저자명 2:단가 3:출판사 4:isbn 5:출판년도 6:인기도)");
		int num = scan.nextInt();
		
		if(num==1) {
			System.out.println("검색하실 저자명을 입력하세요.");
			String author = scan.next();
			for(int i=0;i<cnt;i++) {
				if(bookList.get(i).getAuthor().equals(author)) {
					System.out.println(bookList.get(i).toString());
				}
				
			}
		}else if(num==2) {
			System.out.println("검색하실 단가를 입력하세요.");
			int price = scan.nextInt();
			for(int i=0;i<cnt;i++) {
				if(bookList.get(i).getPrice()==price) {
					System.out.println(bookList.get(i).toString());
				}
				
			}
		}else if(num==3) {
			System.out.println("검색하실 출판사를 입력하세요.");
			String company = scan.next();
			for(int i=0;i<cnt;i++) {
				if(bookList.get(i).getCompany().equals(company)) {
					System.out.println(bookList.get(i).toString());
				}
				
			}
		}else if(num==4) {
			System.out.println("검색하실 isbn을 입력하세요.");
			String isbn = scan.next();
			for(int i=0;i<cnt;i++) {
				if(bookList.get(i).getIsbn().equals(isbn)) {
					System.out.println(bookList.get(i).toString());
				}
				
			}
		}else if(num==5) {
			System.out.println("검색하실 출판년도를 입력하세요.");
			int year = scan.nextInt();
			for(int i=0;i<cnt;i++) {
				if(bookList.get(i).getYear()==year) {
					System.out.println(bookList.get(i).toString());
				}
				
			}
		}else if(num==6) {
			System.out.println("검색하실 인기도를 입력하세요.");
			int popular = scan.nextInt();
			for(int i=0;i<cnt;i++) {
				if(bookList.get(i).getPop()==popular) {
					System.out.println(bookList.get(i).toString());
				}
				
			}
		}
		
	}
	public void outPut() {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		 
		try{
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(bookList);
			oos.reset();
			oos.writeObject(bookList);
			oos.reset();
			
			System.out.println("저장완료.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} // finally
	}
	public void run() {
		while(true) {
			System.out.println("1) 도서추가 2) 도서정보변경 3) 도서삭제 4) 도서검색 5) 파일읽기 6) 파일저장");
			int sel=scan.nextInt();
			if(sel==1) {
				addBook();
			}else if(sel==2) {
				modifyBook();
			}else if(sel==3) {
				deleteBook();
			}else if(sel==4) {
				searchBook();
			}else if(sel==5) {
				input();
			}else if(sel==6) {
				outPut();
			}
		}
	}
	public static void main(String[] args) {
		BookManager b = new BookManager();
		b.run();

	}

}
