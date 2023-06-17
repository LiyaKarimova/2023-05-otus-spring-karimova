package ru.otus.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.QuestionDao;
import ru.otus.homework.domain.Question;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Override
    public List<Question> getQuestionList() {
        return questionDao.getAllQuestions();
    }
}
