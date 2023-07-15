package ru.otus.homework.util;

import ru.otus.homework.domain.Question;

public interface StringToQuestionParser {

    Question parseString (String stringToParse);

}
