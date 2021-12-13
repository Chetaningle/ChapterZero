package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findAll(); // just in case
    List<Book> findById(int id); // not needed
    List<Book> findByAuthorNameContainsOrBookNameContainsOrPublisherContains(String author_name, String book_name, String publisher);//for search
}
