package com.bookproject.service.impl;

import com.bookproject.config.exception.ExceptionEnum;
import com.bookproject.config.exception.NotFoundException;
import com.bookproject.domain.Book;
import com.bookproject.repository.BookRepository;
import com.bookproject.repository.entity.BookEntity;
import com.bookproject.service.BookService;
import com.bookproject.service.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Book> getBooks(Book book) {

        if (book == null) {
            book = new Book();
        }

        List<BookEntity> bookList = repository.getBooks(book.getId(), book.getName(), book.getCategory(), book.getIsbn(), book.getAuthor());

        if (CollectionUtils.isEmpty(bookList)) {
            throw new NotFoundException(ExceptionEnum.BOOK_NOT_FOUND);
        }

        return mapper.entityListToDomainList(bookList);
    }
}
