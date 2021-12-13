package com.example.demo;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
//Books object

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "book_name")
	String bookName;
	@Column(name = "author_name")
	String authorName;
	@Column
	String publisher;
	@Column
	String rating;
	@Column(name = "author_url")
	String authorUrl;
	public String getAuthorUrl() {
		return authorUrl;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	@Column(name = "book_url")
	String bookUrl;
	@Column
	int bookid;
	@Transient
	public boolean favorite;

//	boolean favorite;
//	
	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getBook_url() {
		return bookUrl;
	}

	public void setBook_url(String book_url) {
		this.bookUrl = book_url;
	}

	@Autowired
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getBook_name() {
		return bookName;
	}

	public void setBook_name(String book_name) {
		this.bookName = book_name;
	}

	public String getAuthor_name() {
		return authorName;
	}

	public void setAuthor_name(String author_name) {
		this.authorName = author_name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
