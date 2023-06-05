package ru.otus.homework.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.FileParseException;
import ru.otus.homework.util.CSVQuestionParser;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class QuestionDaoImpl implements QuestionDao {

    private final CSVQuestionParser csvParser;

    @Override
    public List<Question> getAllQuestions() {
        try {
            return csvParser.getAllQuestionsFromFile();
        } catch (FileParseException e) {
            log.error("Parser exception: ",e);
            return new ArrayList<>();
        }
    }
}
