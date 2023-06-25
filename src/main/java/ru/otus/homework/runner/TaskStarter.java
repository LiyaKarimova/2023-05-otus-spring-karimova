package ru.otus.homework.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.homework.service.TaskService;
import ru.otus.homework.util.ResultInfoPrinter;

@Component
public class TaskStarter implements CommandLineRunner {

    private final ResultInfoPrinter resultInfoPrinter;

    private final TaskService taskService;

    public TaskStarter(ResultInfoPrinter resultInfoPrinter, TaskService taskService) {
        this.resultInfoPrinter = resultInfoPrinter;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) {
        resultInfoPrinter.printResult(taskService.startTask());
    }
}
