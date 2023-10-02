DROP TABLE IF EXISTS "widgets";

DROP SEQUENCE IF EXISTS widgets_id_seq;

CREATE SEQUENCE widgets_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 923459696959494 CACHE 1;

CREATE TABLE "widgets"(
    "id" int default nextval('widgets_id_seq') not null ,
    "name" text,
    "purpose" text,
    constraint "widgets_pkey" primary key ("id")
);