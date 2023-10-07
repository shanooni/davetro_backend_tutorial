package io.shanoon.quickstarter.dao.impl;

import io.shanoon.quickstarter.TestDataUtil;
import io.shanoon.quickstarter.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImpIntegrationTest {
    private AuthorDoaImpl underTest;

    @Autowired
    public AuthorDaoImpIntegrationTest(AuthorDoaImpl authorDoa){
        this.underTest = authorDoa;
    }
    @Test
    public void testThatAuthorCanBeCreatedAndRecall(){

        Author author = TestDataUtil.createTestAuthor();

        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }
}
