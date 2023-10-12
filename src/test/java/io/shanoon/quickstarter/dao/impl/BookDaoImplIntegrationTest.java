package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.TestDataUtil;
import io.shanoon.quickstarter.dao.AuthorDoa;
import io.shanoon.quickstarter.domain.Author;
import io.shanoon.quickstarter.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static io.shanoon.quickstarter.TestDataUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
        Author author = TestDataUtil.createTestAuthorA();
        authorDoa.create(author);

        Book book = createBookByAuthorA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> testBook = underTest.findOne(book.getIsbn());

        assertThat(testBook).isPresent();
        assertThat(testBook.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){

        Author authorA = createTestAuthorA();
        authorDoa.create(authorA);
        Book bookByAuthorA = createBookByAuthorA();
        bookByAuthorA.setAuthorId(authorA.getId());
        underTest.create(bookByAuthorA);

        Author authorB = createTestAuthorB();
        authorDoa.create(authorB);
        Book bookByAuthorB = createBookByAuthorB();
        bookByAuthorB.setAuthorId(authorB.getId());
        underTest.create(bookByAuthorB);

        Author authorC = createTestAuthorC();
        authorDoa.create(authorC);
        Book bookByAuthorC = createBookByAuthorC();
        bookByAuthorC.setAuthorId(authorC.getId());
        underTest.create(bookByAuthorC);

        List<Book> bookList = underTest.findAll();

        assertThat(bookList)
                .hasSize(3)
                .contains(bookByAuthorA,bookByAuthorB,bookByAuthorC);

    }

    @Test
    public void testThatBookCanBeCreatedAndUpdated(){
        Author author = createTestAuthorA();
        authorDoa.create(author);
        Book book = createBookByAuthorA();
        book.setAuthorId(author.getId());
        underTest.create(book);

        book.setTitle("the new life");
        underTest.update(book,book.getIsbn());

        Optional<Book> testOne = underTest.findOne(book.getIsbn());
        assertThat(testOne).isPresent();
        assertThat(testOne.get()).isEqualTo(book);
    }
}
