package io.shanoon.quickstarter.dao;

import io.shanoon.quickstarter.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDoa {
    void create(Book book);

    Optional<Book> findOne(String isbn );

    List<Book> findAll();
}
