package ru.otus.homework.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.homework.runner.TaskStarter;

@ShellComponent
public class ApplicationCommands {

    private final TaskStarter taskStarter;

    private String userName;

    private String userSurname;

    public ApplicationCommands(TaskStarter taskStarter) {
        this.taskStarter = taskStarter;
    }

    @ShellMethod (key = "start")
    private String welcomeMethod () {
        return "Добро пожаловать в систему тестирования, зарегистрирутесь с помощью команды 'login'";
    }

    @ShellMethod (key = "login")
    private String login (String name, String surname) {
        this.userName = name;
        this.userSurname = surname;
        return String.format("%s, вы успешно зарегистрировались. Для старта теста введите 'start test'",
                userName + " " + userSurname);
    }

    @ShellMethod (key = "start test")
    @ShellMethodAvailability(value = "isUserLoginAvailable")
    private void startTest () {
        taskStarter.run(userName, userSurname);
    }

    private Availability isUserLoginAvailable() {
        return (userName == null && userSurname == null) ?
                Availability.unavailable("Сначала необходимо зарегистрироваться"): Availability.available();
    }
}
