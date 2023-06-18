package ru.otus.homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.exception.ParseException;
import ru.otus.homework.util.CSVResourceStringReader;
import ru.otus.homework.util.Interfaces.QuestionReader;
import ru.otus.homework.util.Interfaces.StringReader;
import ru.otus.homework.util.Interfaces.StringToQuestionParser;
import ru.otus.homework.util.QuestionReaderImpl;
import ru.otus.homework.util.StringToQuestionParserImpl;

@ExtendWith(MockitoExtension.class)
public class QuestionReaderTest {

    private StringReader stringReader;

    private StringToQuestionParser stringToQuestionParser;

    private QuestionReaderImpl questionReader;

    @BeforeEach
    void prepare () {
        stringReader = new CSVResourceStringReader("questions.csv");
        stringToQuestionParser = new StringToQuestionParserImpl(",");
        questionReader = new QuestionReaderImpl(stringReader,stringToQuestionParser);
    }

    @DisplayName("должен возвращать не пустой набор вопросов")
    @Test
    void getAllQuestionsFromSourceTest() throws ParseException {
        Assertions.assertNotNull(questionReader.getAllQuestionsFromSource());
        Assertions.assertFalse(questionReader.getAllQuestionsFromSource().isEmpty());
    }
}
