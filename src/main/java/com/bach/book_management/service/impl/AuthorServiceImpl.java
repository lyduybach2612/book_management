package com.bach.book_management.service.impl;

import com.bach.book_management.dto.AuthorDto;
import com.bach.book_management.mapper.AuthorMapper;
import com.bach.book_management.model.Author;
import com.bach.book_management.repository.AuthorRepository;
import com.bach.book_management.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;


    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public void createAuthor(AuthorDto authorDto) {
        Author author = AuthorMapper.mapToAuthor(authorDto);
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Long authorId, AuthorDto authorDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("User Not Found"));
        author = AuthorMapper.mapToAuthor(authorDto);
        author.setId(authorId);
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
