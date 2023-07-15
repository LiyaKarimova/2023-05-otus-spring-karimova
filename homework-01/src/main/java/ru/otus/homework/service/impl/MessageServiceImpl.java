package ru.otus.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.AppProperties;
import ru.otus.homework.service.MessageService;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    private final AppProperties properties;


    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key, null, properties.getLocale());
    }

    @Override
    public String getMessage(String key, String[] options) {
        return messageSource.getMessage(key,options,properties.getLocale());
    }
}
