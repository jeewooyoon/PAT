package 도서관1;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn;
	private String title;
	private String author;
	private int price;
	private int pub_year;
	private String pub_company;
	private int pop;
	
	public Book(String isbn, String title, String author, int price, int pub_year, String pub_company, int pop){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pub_year = pub_year;
		this.pub_company = pub_company;
		this.pop = pop;
	}
	public String getCompany() {
		return pub_company;
	}
	
	public int getYear() {
		return pub_year;
	}
	
	public int getPop() {
		return pop;
	}
	
	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCompany(String company) {
		this.pub_company = company;
	}
	
	public void setYear(int year) {
		this.pub_year = year;
	}
	
	public void setPop(int p) {
		this.pop = p;
	}
	public String toString(){
		return getIsbn() + "," + getTitle() + "," + getAuthor() + "," + getPrice() + "," + getYear()+","+getCompany()+","+getPop();
	}

}

