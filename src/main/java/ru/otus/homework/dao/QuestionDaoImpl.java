package ru.otus.homework.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;
import ru.otus.homework.util.QuestionReaderImpl;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Component
public class QuestionDaoImpl implements QuestionDao {

    private final QuestionReaderImpl csvParser;

    @Override
    public List<Question> getAllQuestions() {
        try {
            return csvParser.getAllQuestionsFromSource();
        } catch (ParseException e) {
            log.error("Parser exception: ",e);
            return new ArrayList<>();
        }
    }
}
