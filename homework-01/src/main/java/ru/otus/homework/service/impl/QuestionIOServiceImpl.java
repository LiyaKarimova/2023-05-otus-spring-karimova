package ru.otus.homework.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.IOService;
import ru.otus.homework.service.QuestionIOService;
import ru.otus.homework.util.StringToAnswerParser;

@AllArgsConstructor
@Slf4j
@Service
public class QuestionIOServiceImpl implements QuestionIOService {

    private final IOService ioService;

    private final StringToAnswerParser stringToAnswerParser;

    @Override
    public void printQuestion (Question question) {
        ioService.printString(question.getQuestion());
    }

    @Override
    public Answer getAnswer () {
        return stringToAnswerParser.parseStringToAnswer(ioService.readString());
    }
}
