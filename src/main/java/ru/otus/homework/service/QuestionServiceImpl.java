package ru.otus.homework.service;

import lombok.AllArgsConstructor;
import ru.otus.homework.dao.QuestionDao;
import ru.otus.homework.domain.Question;

import java.util.List;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Override
    public List<Question> getQuestionList() {
        return questionDao.getAllQuestions();
    }
}
