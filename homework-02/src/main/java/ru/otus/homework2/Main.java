package ru.otus.homework2;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.homework2.repositories.BookRepository;

import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Main.class);
        Console.main(args);
    }
}
