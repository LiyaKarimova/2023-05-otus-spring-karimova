package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ResultItem {

    private final Question question;

    private final Answer answer;

    @Getter
    private final boolean isRightAnswer;
}
