package testproject;

import java.io.Serializable;
import java.util.Calendar;

public class Comicbook extends Book implements Serializable {
	private String painter;
	public Comicbook(String kind, String isbn, String title, String author,String painter, 
			int price, int pub_year, String pub_company, int pop,
			int search_cnt, String rental, Calendar rental_time) {
		super(kind, isbn, title, author, price, pub_year, pub_company, pop, search_cnt,
				rental, rental_time);
		this.painter = painter;
	}
	
	public String getPainter() {
		return painter;
	}
	public void setPainter(String painter) {
		this.painter = painter;
	}
	public String comicString(){
		return getKind()+"  isbn :"+getIsbn()+"  "+"제목 :"+getTitle()+"  "+"저자 :"+getAuthor()+"  "+"그린이 :"+getPainter()+"  가격 :"+getPrice()+"  "+"출판년도 :"+getYear()+"\n"+"출판사 :"+getCompany()+"  "+"인기도 :"+getPop()+"  "+"대출가능여부"+getRental()+"\n";
	}

}
