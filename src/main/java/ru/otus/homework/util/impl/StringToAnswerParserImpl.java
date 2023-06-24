package ru.otus.homework.util.impl;

import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.util.StringToAnswerParser;

@Component
public class StringToAnswerParserImpl implements StringToAnswerParser {

    @Override
    public Answer parseStringToAnswer(String str) {
        return new Answer(str);
    }
}
