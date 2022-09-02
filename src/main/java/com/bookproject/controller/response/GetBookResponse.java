package com.bookproject.controller.response;

import com.bookproject.domain.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetBookResponse {

    private List<Book> books;
}
