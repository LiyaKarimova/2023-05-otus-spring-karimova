package ru.otus.homework2.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework2.dao.jdbc.BookDaoJdbc;
import ru.otus.homework2.dao.jdbc.BookInfoDaoJdbc;

@ShellComponent
public class ApplicationCommands {

    private final BookInfoDaoJdbc bookInfoDaoJdbc;

    private final BookDaoJdbc bookDaoJdbc;

    public ApplicationCommands(BookInfoDaoJdbc bookInfoDaoJdbc, BookDaoJdbc bookDaoJdbc) {
        this.bookInfoDaoJdbc = bookInfoDaoJdbc;
        this.bookDaoJdbc = bookDaoJdbc;
    }


    @ShellMethod(key = "bookList")
    private String printBookList () {
        return "Все книги библиотеки: ";
    }

    @ShellMethod (key = "count")
    private int printCount () {
        return bookDaoJdbc.count();
    }
}
