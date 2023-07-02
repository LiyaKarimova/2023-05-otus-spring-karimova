package ru.otus.homework.utilTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;;
import ru.otus.homework.util.StringReader;
import ru.otus.homework.util.StringToQuestionParser;
import ru.otus.homework.util.impl.QuestionReaderImpl;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest (classes = {StringReader.class, StringToQuestionParser.class, QuestionReaderImpl.class})
public class QuestionReaderTest {

    @MockBean
    private StringReader stringReader;
    @MockBean
    private StringToQuestionParser stringToQuestionParser;
    @Autowired
    private QuestionReaderImpl questionReader;


    @DisplayName("Корректно возвращается список вопросов из файла")
    @Test
    void getAllQuestionsFromSourceTest() throws ParseException {
        var expectedData = List.of("Expected Text, 1", "Expected test, 2");
        given(stringReader.readAllStrings())
                .willReturn(expectedData);

        List <Question> questionList = List.of(new Question("Expected Text", "1"), new Question("Expected test", "2"));
        when(stringToQuestionParser.parseString(expectedData.get(0))).thenReturn(new Question("Expected Text", "1"));
        when(stringToQuestionParser.parseString(expectedData.get(1))).thenReturn(new Question("Expected test", "2"));

        assertThat(questionReader.getAllQuestionsFromSource())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(questionList);
    }
}
