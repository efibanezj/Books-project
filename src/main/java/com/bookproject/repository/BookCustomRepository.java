package com.bookproject.repository;

import com.bookproject.repository.entity.BookEntity;

import java.util.List;

public interface BookCustomRepository {

    /**
     * Method to get a list of books given a filters
     *
     * @param id       identifier
     * @param name     name
     * @param category category
     * @param isbn     isbn
     * @param author   author
     * @return lsito of books that matched with the input filters
     */
    List<BookEntity> getBooks(String id, String name, String category, String isbn, String author);
}
