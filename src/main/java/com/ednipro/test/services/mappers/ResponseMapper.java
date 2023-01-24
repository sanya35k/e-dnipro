package com.ednipro.test.services.mappers;

public interface ResponseMapper<T, D> {
    D mapToDto(T model);
}
