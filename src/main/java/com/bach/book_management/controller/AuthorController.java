package com.bach.book_management.controller;

import com.bach.book_management.dto.AuthorDto;
import com.bach.book_management.model.Author;
import com.bach.book_management.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long authorId) {
        Author author = authorService.getAuthorById(authorId);
        return ResponseEntity.ok(author);
    }

    @PostMapping()
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
        return ResponseEntity.ok(authorDto);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(authorId,authorDto);
        return ResponseEntity.ok(authorDto);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok("Deleted Author Successfully");
    }

}
