package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.dao.AuthorDoa;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDoaImpl implements AuthorDoa {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDoaImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
