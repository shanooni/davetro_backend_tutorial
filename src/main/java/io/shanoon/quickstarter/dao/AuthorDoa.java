package io.shanoon.quickstarter.dao;

import io.shanoon.quickstarter.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDoa {
    void create(Author author);

    Optional<Author> findOne(Long id);

    List<Author> findAll();


    void update(Author author, long id);
}
