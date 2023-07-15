package ru.otus.homework.service;

import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;

public interface QuestionIOService {

    void printQuestion (Question question);

    Answer getAnswer ();
}
