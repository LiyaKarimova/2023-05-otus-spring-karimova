package ru.otus.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework.service.TaskService;
import ru.otus.homework.service.TaskServiceImpl;
import ru.otus.homework.util.Interfaces.ResultInfoPrinter;
import ru.otus.homework.util.ResultInfoImpl;


@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        TaskService taskService = context.getBean(TaskServiceImpl.class);
        ResultInfoPrinter resultInfoPrinter = context.getBean(ResultInfoImpl.class);

        resultInfoPrinter.printResult(taskService.startTask());
    }
}
