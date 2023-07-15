package ru.otus.homework.runner;

import org.springframework.stereotype.Component;
import ru.otus.homework.service.TaskService;
import ru.otus.homework.util.ResultInfoPrinter;

@Component
public class TaskStarter {

    private final ResultInfoPrinter resultInfoPrinter;

    private final TaskService taskService;

    public TaskStarter(ResultInfoPrinter resultInfoPrinter, TaskService taskService) {
        this.resultInfoPrinter = resultInfoPrinter;
        this.taskService = taskService;
    }

    public void run(String userName, String userSurname) {
        resultInfoPrinter.printResult(taskService.startTask(userName, userSurname));
    }
}
