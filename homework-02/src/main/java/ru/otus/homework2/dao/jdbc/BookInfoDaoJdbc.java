package ru.otus.homework2.dao.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.dao.BookInfoDao;
import ru.otus.homework2.dao.jdbc.mapper.BookInfoMapper;
import ru.otus.homework2.domain.BookInfo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
@Repository
public class BookInfoDaoJdbc implements BookInfoDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookInfoDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public BookInfo getBookInfoByBookId(long id) {
        return null;
//        Map<String, Object> params = Collections.singletonMap("id", id);
//        namedParameterJdbcOperations.queryForObject("", )
    }

    @Override
    public List<BookInfo> getBookInfoList() {
        return namedParameterJdbcOperations.query("SELECT TITLE, NAME FROM " +
                "BOOKS LEFT JOIN AUTHORS ON (BOOKS.AUTHORID = AUTHORS.ID)", new BookInfoMapper());
    }



}
