package ru.otus.homework.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.homework.config.AppProperties;
import ru.otus.homework.domain.Result;
import ru.otus.homework.domain.ResultItem;
import ru.otus.homework.domain.User;
import ru.otus.homework.service.IOService;
import ru.otus.homework.util.ResultInfoPrinter;

@Component
public class ResultInfoImpl implements ResultInfoPrinter {

    private final IOService ioService;

    private final MessageSource messageSource;

    private final AppProperties properties;

    public ResultInfoImpl(@Qualifier("IOServiceStream") IOService ioService, MessageSource messageSource, AppProperties properties) {
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.properties = properties;
    }

    @Override
    public void printResult(Result result) {
        long allCount = result.getResultItemList().size();
        long rightCount = result.getResultItemList().stream().filter(ResultItem::isRightAnswer).count();
        User user = result.getUser();
        StringBuilder sb = new StringBuilder();
        String s = sb
                .append(messageSource.getMessage("userResult", new String [] {user.getName(), user.getSurname()},properties.getLocale()))
                .append(" ")
                .append(rightCount)
                .append("/")
                .append(allCount)
                .toString();
        ioService.printString(s);
    }
}
