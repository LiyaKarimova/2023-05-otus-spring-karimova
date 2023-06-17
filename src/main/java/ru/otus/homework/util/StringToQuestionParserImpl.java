package ru.otus.homework.util;

import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Question;
import ru.otus.homework.util.Interfaces.StringToQuestionParser;

@Service
public class StringToQuestionParserImpl implements StringToQuestionParser {

    @Setter
    private String regex;

    @Override
    public Question parseString(String string) {

        String[] question = string.split(regex);
        return new Question(question[0], question.length > 1 ? question[1] : null);

    }


}
