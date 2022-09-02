package com.bookproject.controller;


import com.bookproject.controller.response.GetBookResponse;
import com.bookproject.domain.Book;
import com.bookproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public GetBookResponse getBooks(@RequestParam(required = false) String id,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String category,
                                    @RequestParam(required = false) String isbn,
                                    @RequestParam(required = false) String author) {

        Book bookFilters = Book.builder()
                .id(id)
                .name(name)
                .category(category)
                .isbn(isbn)
                .author(author)
                .build();

        List<Book> bookList = bookService.getBooks(bookFilters);
        return GetBookResponse.builder().books(bookList).build();
    }
}
