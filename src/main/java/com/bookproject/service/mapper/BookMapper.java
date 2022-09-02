package com.bookproject.service.mapper;

import com.bookproject.domain.Book;
import com.bookproject.repository.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    List<Book> entityListToDomainList(List<BookEntity> bookEntity);
    Book entityToDomain(BookEntity bookEntity);
}
