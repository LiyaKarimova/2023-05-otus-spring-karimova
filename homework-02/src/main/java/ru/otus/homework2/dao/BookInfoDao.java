package ru.otus.homework2.dao;

import ru.otus.homework2.domain.BookInfo;

import java.util.List;

public interface BookInfoDao {

    BookInfo getBookInfoByBookId (long id);

    List<BookInfo> getBookInfoList ();
}
