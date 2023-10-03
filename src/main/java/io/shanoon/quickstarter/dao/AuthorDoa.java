package io.shanoon.quickstarter.dao;

import io.shanoon.quickstarter.domain.Author;

import java.util.Optional;

public interface AuthorDoa {
    void create(Author author);

    Optional<Author> findOne(Long id);
}
