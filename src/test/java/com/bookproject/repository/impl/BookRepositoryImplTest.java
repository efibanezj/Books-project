package com.bookproject.repository.impl;

import com.bookproject.config.exception.ExceptionEnum;
import com.bookproject.config.exception.NotFoundException;
import com.bookproject.domain.Book;
import com.bookproject.repository.BookRepository;
import com.bookproject.repository.entity.BookEntity;
import com.bookproject.service.impl.BookServiceImpl;
import com.bookproject.service.mapper.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class BookRepositoryImplTest {

    private BookServiceImpl service;
    @Mock
    private BookRepository repository;

    @BeforeEach
    void setUp() {
        BookMapper mapper = Mappers.getMapper(BookMapper.class);
        service = new BookServiceImpl(repository, mapper);
    }

    @Test
    void getBooks_noFilters_AllBooks() {

        when(repository.getBooks(null, null, null, null, null)).thenReturn(Collections.emptyList());


        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                service.getBooks(null));

        assertThat(exception.getErrorCode()).isEqualTo(ExceptionEnum.BOOK_NOT_FOUND.getValue());

        verify(repository).getBooks(any(), any(), any(), any(), any());

    }

    @Test
    void getBooks_allFilters_draculaBook() {

        BookEntity bookEntity = BookEntity.builder()
                .id("848cf97a-2a78-11ed-a261-0242ac120002")
                .name("Dracula")
                .category("terror")
                .isbn("736-0-545-01022-1")
                .author("Bram Stoker")
                .build();


        when(repository.getBooks("848cf97a-2a78-11ed-a261-0242ac120002", "Dracula", "terror", "736-0-545-01022-1", "Bram Stoker")).thenReturn(List.of(bookEntity));


        Book bookFilters = Book.builder()
                .id("848cf97a-2a78-11ed-a261-0242ac120002")
                .name("Dracula")
                .category("terror")
                .isbn("736-0-545-01022-1")
                .author("Bram Stoker")
                .build();

        List<Book> bookList = service.getBooks(bookFilters);

        assertThat(bookList).hasSize(1);
        Book draculaBook = bookList.get(0);
        assertThat(draculaBook.getId()).isEqualTo(bookFilters.getId());
        assertThat(draculaBook.getName()).isEqualTo(bookFilters.getName());
        assertThat(draculaBook.getCategory()).isEqualTo(bookFilters.getCategory());
        assertThat(draculaBook.getIsbn()).isEqualTo(bookFilters.getIsbn());
        assertThat(draculaBook.getAuthor()).isEqualTo(bookFilters.getAuthor());
    }
}