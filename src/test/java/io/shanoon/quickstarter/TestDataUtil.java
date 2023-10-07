package io.shanoon.quickstarter;

import io.shanoon.quickstarter.domain.Author;

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
}
