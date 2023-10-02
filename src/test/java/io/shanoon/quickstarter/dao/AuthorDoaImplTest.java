package io.shanoon.quickstarter.dao;


import io.shanoon.quickstarter.dao.impl.AuthorDoaImpl;
import io.shanoon.quickstarter.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

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
        Author author = Author.builder()
                .id(1L)
                .name("John Doe")
                .age(45)
                        .build();

        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id,name,age) VALUES (?,?,?)"),
                eq(1L),eq("John Doe"), eq(45)
        );
    }
}
