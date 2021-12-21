package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
