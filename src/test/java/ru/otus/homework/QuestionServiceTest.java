package ru.otus.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.dao.QuestionDao;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.QuestionService;
import ru.otus.homework.service.impl.QuestionServiceImpl;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    private QuestionDao questionDaoMocked;

    @Test
    public void getAllQuestionsTest () {
        QuestionService questionService = new QuestionServiceImpl(questionDaoMocked);
        List<Question> questionList = questionService.getQuestionList();
        Assertions.assertNotNull(questionList);
    }


}
