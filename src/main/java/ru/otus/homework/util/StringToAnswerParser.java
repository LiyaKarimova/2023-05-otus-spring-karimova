package ru.otus.homework.util;

import ru.otus.homework.domain.Answer;

public interface StringToAnswerParser {

    Answer parseStringToAnswer (String str);
}
