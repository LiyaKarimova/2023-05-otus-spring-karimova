package ru.otus.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework.util.QuestionPrinter;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionPrinter questionPrinter = context.getBean(QuestionPrinter.class);
        questionPrinter.printAllQuestions();
    }
}
