package com.bach.book_management.dto;

import com.bach.book_management.model.Author;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {

    String name;
    String publisher;
    LocalDate publicationDate;
    Author author;

}
