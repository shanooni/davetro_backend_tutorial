package io.shanoon.quickstarter;

import io.shanoon.quickstarter.domain.Author;
import io.shanoon.quickstarter.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static Author createTestAuthorA() {
        Author author = Author.builder()
                .id(1L)
                .name("John Doe")
                .age(45)
                        .build();
        return author;
    }
    public static Author createTestAuthorB() {
        Author author = Author.builder()
                .id(2L)
                .name("Owusu Ansah")
                .age(32)
                .build();
        return author;
    }
    public static Author createTestAuthorC() {
        Author author = Author.builder()
                .id(3L)
                .name("Ama Serwah")
                .age(23)
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
