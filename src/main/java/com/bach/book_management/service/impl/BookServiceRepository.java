package com.bach.book_management.service.impl;

import com.bach.book_management.repository.BookRepository;
import com.bach.book_management.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookServiceRepository implements BookService {

    BookRepository bookRepository;

}
