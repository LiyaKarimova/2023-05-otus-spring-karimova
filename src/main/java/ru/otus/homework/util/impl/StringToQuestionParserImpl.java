package ru.otus.homework.util.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Question;
import ru.otus.homework.util.StringToQuestionParser;

@Component
public class StringToQuestionParserImpl implements StringToQuestionParser {

    @Setter
    private final String regex;

    public StringToQuestionParserImpl(@Value("${file.regex}") String regex) {
        this.regex = regex;
    }

    @Override
    public Question parseString(String string) {

        String[] question = string.split(regex);
        return new Question(question[0].trim(), question.length > 1 ? question[1].trim() : null);

    }


}
