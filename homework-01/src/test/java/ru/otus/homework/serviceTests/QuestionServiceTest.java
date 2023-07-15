package ru.otus.homework.serviceTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework.dao.impl.QuestionDaoImpl;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.impl.QuestionServiceImpl;

import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest (classes = {QuestionServiceImpl.class, QuestionDaoImpl.class})
public class QuestionServiceTest {

    @MockBean
    private QuestionDaoImpl questionDaoMocked;
    @Autowired
    private QuestionServiceImpl questionService;

    @Test
    public void getAllQuestionsTest () {
        List<Question> questionList = List.of(new Question("question1", "answer1"),
                new Question("question2", "answer2"));
        given(questionDaoMocked.getAllQuestions()).willReturn(questionList);

        List <Question> questionListFromService = questionService.getQuestionList();
        Assertions.assertNotNull(questionListFromService);
        Assertions.assertFalse(questionListFromService.isEmpty());
    }


}
