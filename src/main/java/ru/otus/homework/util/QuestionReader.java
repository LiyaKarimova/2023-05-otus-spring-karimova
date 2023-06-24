package ru.otus.homework.util;

import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;

import java.util.List;

public interface QuestionReader {
    List<Question> getAllQuestionsFromSource() throws ParseException;
}
