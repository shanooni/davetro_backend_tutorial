package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.dao.BookDoa;
import io.shanoon.quickstarter.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDoaImp implements BookDoa {
    private final JdbcTemplate jdbcTemplate;

    public BookDoaImp(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books(isbn, title, author_id VALUES (?, ?, ?)",
                book.getIsbn(),
                book.getTitle(),
                book.getAuthorId()
        );
    }
}
