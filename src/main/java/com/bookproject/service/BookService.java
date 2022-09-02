package com.bookproject.service;

import com.bookproject.domain.Book;

import java.util.List;

public interface BookService {

    /**
     * Method to get a list of book given a filters
     *
     * @param book book filters
     * @return list of filters that matched with the input filters
     */
    List<Book> getBooks(Book book);
}
