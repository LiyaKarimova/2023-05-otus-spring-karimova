package ru.otus.homework.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;
import ru.otus.homework.util.Interfaces.StringToAnswerParser;

@AllArgsConstructor
@Slf4j
@Service
public class QuestionIOService {

    private final IOService ioService;

    private final StringToAnswerParser stringToAnswerParser;


    public void printQuestion (Question question) {
        ioService.printString(question.getQuestion());
    }


    public Answer getAnswer () {
        return stringToAnswerParser.parseStringToAnswer(ioService.readString());
    }
}
