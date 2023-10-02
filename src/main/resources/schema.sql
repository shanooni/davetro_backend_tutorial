DROP TABLE IF EXISTS "authors";
DROP TABLE IF EXISTS "books";


CREATE TABLE "authors"(
                          "id" bigint not null,
                          "name" text,
                          "age" integer,
                          constraint "authors_pkey" primary key ("id")
);

CREATE TABLE "books"(
    "isbn" text  not null ,
    "title" text,
    "author_id" bigint,
    constraint "books_pkey" primary key ("isbn"),
    constraint "fk_authors" foreign key (author_id) references authors(id)

);
