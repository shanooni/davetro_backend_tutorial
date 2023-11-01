package io.shanoon.quickstarter.dao.impl;


import io.shanoon.quickstarter.TestDataUtil;
import io.shanoon.quickstarter.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDoaImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDoaImpl underTest;

    @Test
    public void testThatCreateAuthorGenerateCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();

        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id,name,age) VALUES (?,?,?)"),
                eq(1L),eq("John Doe"), eq(45)
        );
    }

    @Test
    public void testThatFindOneGenerateCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id,name,age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDoaImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyGenerateTheCorrectSql(){
        underTest.findAll();

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDoaImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesTheCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.update(author, 3L);

        verify(jdbcTemplate).update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                1L, "John Doe", 45, 3L
        );
    }

    @Test
    public void testThatDeleteGeneratesTheCorrectSql(){

        long bookId = 1L;

        underTest.delete(bookId);

        verify(jdbcTemplate).update(
               "DELETE FROM authors WHERE id = ?",
                 bookId
        );
    }
}
