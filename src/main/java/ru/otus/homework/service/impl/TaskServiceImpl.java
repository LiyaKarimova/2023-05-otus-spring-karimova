package ru.otus.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.AppProperties;
import ru.otus.homework.domain.User;
import ru.otus.homework.domain.Result;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.ResultItem;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.service.QuestionIOService;
import ru.otus.homework.service.QuestionService;
import ru.otus.homework.service.TaskService;
import ru.otus.homework.util.AnswerToResultItemParser;
import ru.otus.homework.util.AnswerToUserParser;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final QuestionIOService questionIOService;

    private final QuestionService questionService;

    private final AnswerToUserParser answerToUserParser;

    private final AnswerToResultItemParser answerToResultItemParser;

    private final MessageSource messageSource;

    private final AppProperties properties;

    @Override
    public Result startTask() {
        Question firstQuestion = new Question(
                messageSource.getMessage("userNameRequest", null, properties.getLocale()),
                null);
        User user = answerToUserParser.getUser(doQuestion(firstQuestion));
        List <ResultItem> resultItemList = new ArrayList<>();

        List<Question> questionList = questionService.getQuestionList();
        for (Question q: questionList) {
            resultItemList.add( answerToResultItemParser.getResultItem(q,doQuestion(q)));
        }

         return new Result(user,resultItemList);

    }

    private Answer doQuestion (Question question) {
        questionIOService.printQuestion(question);
        return questionIOService.getAnswer();
    }
}
