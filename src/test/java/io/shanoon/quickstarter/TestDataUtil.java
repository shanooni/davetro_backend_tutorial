package io.shanoon.quickstarter;

import io.shanoon.quickstarter.domain.Author;
import io.shanoon.quickstarter.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static Author createTestAuthor() {
        Author author = Author.builder()
                .id(1L)
                .name("John Doe")
                .age(45)
                        .build();
        return author;
    }

    public static Book createBook() {
        Book book = Book.builder()
                .isbn("912-4-5-908")
                .title("The lost Lands")
                .authorId(1L)
                .build();
        return book;
    }
}
