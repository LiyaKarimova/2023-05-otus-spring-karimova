package ru.otus.homework;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.homework.service.TaskService;
import ru.otus.homework.util.Interfaces.ResultInfoPrinter;

@Component
@AllArgsConstructor
public class TaskStarter {

    private final ResultInfoPrinter resultInfoPrinter;

    private final TaskService taskService;

    public void startTask () {

        resultInfoPrinter.printResult(taskService.startTask());
    }
}
