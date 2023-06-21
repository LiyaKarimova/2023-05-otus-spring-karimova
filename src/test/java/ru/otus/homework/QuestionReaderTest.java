package ru.otus.homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;;
import ru.otus.homework.util.Interfaces.StringReader;
import ru.otus.homework.util.Interfaces.StringToQuestionParser;
import ru.otus.homework.util.QuestionReaderImpl;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionReaderTest {

    @Mock
    private StringReader stringReader;
    @Mock
    private StringToQuestionParser stringToQuestionParser;
    @InjectMocks
    private QuestionReaderImpl questionReader;

//    @BeforeEach
//    void prepare () {
//        stringReader = new CSVResourceStringReader("questions.csv");
//        stringToQuestionParser = new StringToQuestionParserImpl(",");
//        questionReader = new QuestionReaderImpl(stringReader,stringToQuestionParser);
//    }

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
