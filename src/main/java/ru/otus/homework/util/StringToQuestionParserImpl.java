package ru.otus.homework.util;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;
import ru.otus.homework.util.Interfaces.StringToQuestionParser;

@Service
public class StringToQuestionParserImpl implements StringToQuestionParser {

    @Setter
    private final String regex;

    public StringToQuestionParserImpl(@Value("${file.regex}") String regex) {
        this.regex = regex;
    }

    @Override
    public Question parseString(String string) {

        String[] question = string.split(regex);
        return new Question(question[0], question.length > 1 ? question[1] : null);

    }


}
