package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.dao.AuthorDoa;
import io.shanoon.quickstarter.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDoaImpl implements AuthorDoa {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDoaImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id,name,age) VALUES (?,?,?)",
                author.getId(),author.getName(),author.getAge());

    }
}
