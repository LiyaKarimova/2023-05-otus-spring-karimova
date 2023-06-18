package ru.otus.homework.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Result;
import ru.otus.homework.domain.ResultItem;
import ru.otus.homework.domain.User;
import ru.otus.homework.service.IOService;
import ru.otus.homework.util.Interfaces.ResultInfoPrinter;

@Component
public class ResultInfoImpl implements ResultInfoPrinter {

    private final IOService ioService;

    public ResultInfoImpl(@Qualifier("IOServiceStream") IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void printResult(Result result) {
        long allCount = result.getResultItemList().size();
        long rightCount = result.getResultItemList().stream().filter(ResultItem::isRightAnswer).count();
        User user = result.getUser();
        StringBuilder sb = new StringBuilder();
        String s = sb
                .append("Пользователь ")
                .append(user.getName())
                .append(" ")
                .append(user.getSurname())
                .append(" набрал ")
                .append(rightCount)
                .append("/")
                .append(allCount)
                .append(" баллов")
                .toString();
        ioService.printString(s);
    }
}
