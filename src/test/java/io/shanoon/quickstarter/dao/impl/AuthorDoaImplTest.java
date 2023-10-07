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
        Author author = TestDataUtil.createTestAuthor();

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
}
