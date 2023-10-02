package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.dao.BookDoa;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDoaImp implements BookDoa {
    private final JdbcTemplate jdbcTemplate;

    public BookDoaImp(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
