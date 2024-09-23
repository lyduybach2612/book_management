package com.bach.book_management.service;

import com.bach.book_management.dto.AuthorDto;
import com.bach.book_management.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAuthors();

    Author getAuthorById(Long authorId);

    void createAuthor(AuthorDto authorDto);

    void updateAuthor(Long authorId, AuthorDto authorDto);

    void deleteAuthor(Long authorId);
}
