package ru.otus.homework.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.QuestionService;

@AllArgsConstructor
@Slf4j
public class QuestionPrinter {

    private final QuestionService questionService;

    public void printAllQuestions () {
        for (Question q:questionService.getQuestionList()) {
            log.info(q.getQuestion());
        }


    }
}
