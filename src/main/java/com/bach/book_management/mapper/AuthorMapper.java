package com.bach.book_management.mapper;

import com.bach.book_management.dto.AuthorDto;
import com.bach.book_management.model.Author;

public class AuthorMapper {

    public static Author mapToAuthor(AuthorDto author) {
        return Author.builder()
                .name(author.getName())
                .birthOfDate(author.getBirthOfDate())
                .books(author.getBooks())
                .nationality(author.getNationality())
                .build();
    }

    public static AuthorDto mapToAuthorDto(Author author) {
        return AuthorDto.builder()
                .name(author.getName())
                .birthOfDate(author.getBirthOfDate())
                .books(author.getBooks())
                .nationality(author.getNationality())
                .build();
    }

}
