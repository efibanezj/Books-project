package com.bookproject.repository;

import com.bookproject.repository.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, String>, BookCustomRepository {


}
