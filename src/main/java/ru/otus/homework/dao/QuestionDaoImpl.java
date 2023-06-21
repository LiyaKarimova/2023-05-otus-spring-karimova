package ru.otus.homework.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;
import ru.otus.homework.util.Interfaces.QuestionReader;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Component
public class QuestionDaoImpl implements QuestionDao {

    private final QuestionReader questionReader;

    @Override
    public List<Question> getAllQuestions() {
        try {
            return questionReader.getAllQuestionsFromSource();
        } catch (ParseException e) {
            log.error("Parser exception: ",e);
            return new ArrayList<>();
        }
    }
}
