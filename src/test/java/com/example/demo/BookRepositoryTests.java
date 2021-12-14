package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateBook() {
//		Book book = new Book();
//		
//		book.setBook_name("Harry Potter and the Sorcerer's Stone");
//		book.setAuthor_name("J.K. Rowling");
//		book.setPublisher("Bloomsbury");
//		book.setRating(4.5);
//		book.setBookUrl("www.google.com");
//		
//		
//		Book saved = bookRepo.save(book);
//		Book exists = entityManager.find(Book.class, saved.getId());
//		
//		assertThat(exists.getBookName()).isEqualTo(book.getBookName());
	}
	

}
