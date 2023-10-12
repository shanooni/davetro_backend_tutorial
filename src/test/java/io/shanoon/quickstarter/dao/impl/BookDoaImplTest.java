package io.shanoon.quickstarter.dao.impl;


import io.shanoon.quickstarter.TestDataUtil;
import io.shanoon.quickstarter.domain.Book;
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
public class BookDoaImplTest{

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDoaImp underTest;

    @Test
    public void testThatCreateBookGenerateCorrectSql(){
        Book book = TestDataUtil.createBook();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books(isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("912-4-5-908"),
                eq("The lost Lands"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql(){
        underTest.findOne("912-4-5-908");

        verify(jdbcTemplate).query(
                eq("SELECT isbn,title,author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDoaImp.BookRowMapper>any(),
                eq("912-4-5-908")
        );
    }
}
