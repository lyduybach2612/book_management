package com.bach.book_management.service.impl;

import com.bach.book_management.dto.BookDto;
import com.bach.book_management.mapper.BookMapper;
import com.bach.book_management.model.Book;
import com.bach.book_management.repository.BookRepository;
import com.bach.book_management.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookServiceRepository implements BookService {

    BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book Not Found"));
    }

    @Override
    public void createBook(BookDto book) {
        bookRepository.save(BookMapper.mapToBook(book));
    }

    @Override
    public void updateBook(Long bookId, BookDto book) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book Not Found"));
        existingBook = BookMapper.mapToBook(book);
        existingBook.setId(bookId);
        bookRepository.save(existingBook);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
