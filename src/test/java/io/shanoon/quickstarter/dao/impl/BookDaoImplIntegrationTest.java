package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.TestDataUtil;
import io.shanoon.quickstarter.dao.AuthorDoa;
import io.shanoon.quickstarter.domain.Author;
import io.shanoon.quickstarter.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static io.shanoon.quickstarter.TestDataUtil.createBook;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {

    private AuthorDoa authorDoa;
    private final BookDoaImp underTest;


    @Autowired
    public BookDaoImplIntegrationTest(BookDoaImp underTest,AuthorDoa authorDoa) {
        this.underTest = underTest;
        this.authorDoa = authorDoa;
    }

    @Test
    public void testThatBookCanBeCreateAndRecall(){
        Author author = TestDataUtil.createTestAuthor();
        authorDoa.create(author);

        Book book = createBook();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> testBook = underTest.findOne(book.getIsbn());

        assertThat(testBook).isPresent();
        assertThat(testBook.get()).isEqualTo(book);
    }
}
