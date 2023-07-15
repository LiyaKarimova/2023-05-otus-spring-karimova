package ru.otus.homework.util;

import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.ResultItem;


@Component
public class AnswerToResultItemParser {

    public ResultItem getResultItem (Question question, Answer answer) {
        return new ResultItem(
                question,
                answer,
                question.getRightAnswer().equalsIgnoreCase(answer.getAnswer()));
    }
}
