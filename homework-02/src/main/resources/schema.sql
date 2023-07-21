DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS
(
    ID   BIGINT PRIMARY KEY,
    NAME VARCHAR(255)
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES
(
    ID   BIGINT PRIMARY KEY,
    GENRETITLE VARCHAR(255)
);

DROP TABLE IF EXISTS BOOKS;
  CREATE TABLE BOOKS
  (
      ID   BIGINT PRIMARY KEY,
      TITLE VARCHAR(255),
      AuthorId BIGINT,
      GenreId BIGINT,
      FOREIGN KEY (AuthorId)  REFERENCES AUTHORS (Id),
      FOREIGN KEY (GenreId)  REFERENCES GENRES(Id)
  );