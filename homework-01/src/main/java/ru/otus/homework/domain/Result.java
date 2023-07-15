package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Result {

    private User user;

    private List<ResultItem> resultItemList;
}
