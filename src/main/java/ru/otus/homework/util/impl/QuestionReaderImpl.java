package ru.otus.homework.util.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.ParseException;
import ru.otus.homework.exception.StringReaderException;
import ru.otus.homework.util.QuestionReader;
import ru.otus.homework.util.StringReader;
import ru.otus.homework.util.StringToQuestionParser;

import java.util.List;

@Component
@AllArgsConstructor
public class QuestionReaderImpl implements QuestionReader {

    private StringReader stringReader;

    private StringToQuestionParser stringToQuestionParser;

    @Override
    public List<Question> getAllQuestionsFromSource() throws ParseException {
        if (stringReader != null && stringToQuestionParser != null) {
            try {
                return stringReader.readAllStrings().stream().map(stringToQuestionParser::parseString).toList();
            } catch (StringReaderException e) {
                throw new ParseException (e);
            }
        } else {
            throw new ParseException("String reader and StringToQuestionParser must not be null");
        }
    }


}
