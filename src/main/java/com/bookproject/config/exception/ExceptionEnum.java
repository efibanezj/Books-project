package com.bookproject.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    BOOK_NOT_FOUND(1001);

    private final int value;

}
