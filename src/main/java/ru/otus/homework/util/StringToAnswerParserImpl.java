package ru.otus.homework.util;

import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.util.Interfaces.StringToAnswerParser;

@Component
public class StringToAnswerParserImpl implements StringToAnswerParser {

    @Override
    public Answer parseStringToAnswer(String str) {
        return new Answer(str);
    }
}
