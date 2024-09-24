package com.bach.book_management.mapper;

import com.bach.book_management.dto.BookDto;
import com.bach.book_management.model.Book;

public class BookMapper {

    public static BookDto mapToBookDto(Book book) {
        return BookDto.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .publicationDate(book.getPublicationDate())
                .build();
    }

    public static Book mapToBook(BookDto book) {
        return Book.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .publicationDate(book.getPublicationDate())
                .build();
    }
}
