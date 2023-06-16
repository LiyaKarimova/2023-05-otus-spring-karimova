package ru.otus.homework.util.Interfaces;

import ru.otus.homework.exception.StringReaderException;

import java.util.List;

public interface StringReader {

    List<String> readAllStrings() throws StringReaderException;
}
