package com.bach.book_management.controller;

import com.bach.book_management.dto.BookDto;
import com.bach.book_management.model.Book;
import com.bach.book_management.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto book) {
        bookService.createBook(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long bookId, @RequestBody BookDto book) {
        bookService.updateBook(bookId, book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok("Delete book successfully!");
    }

}
