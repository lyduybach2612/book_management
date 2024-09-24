package com.bach.book_management.service;

import com.bach.book_management.dto.BookDto;
import com.bach.book_management.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookById(Long bookId);

    void createBook(BookDto book);

    void updateBook(Long bookId, BookDto book);

    void deleteBookById(Long bookId);

}
