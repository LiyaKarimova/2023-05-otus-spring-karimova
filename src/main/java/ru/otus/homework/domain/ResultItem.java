package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResultItem {

    private final Question question;

    private final Answer answer;

    private final boolean isRightAnswer;
}
