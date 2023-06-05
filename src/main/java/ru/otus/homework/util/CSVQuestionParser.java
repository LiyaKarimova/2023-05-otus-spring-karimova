package ru.otus.homework.util;

import lombok.Setter;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.FileParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class CSVQuestionParser {
    @Setter
    private String fileName;

    public List<Question> getAllQuestionsFromFile() throws FileParseException {
        List<Question> allQuestions = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (fileName == null) {
            throw new FileParseException("File name is null");
        }
        if (is == null) {
            throw new FileParseException("File not found");
        }
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));) {
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                allQuestions.add(new Question(data[0], data.length > 1 ? data[1] : null));
            }
        } catch (IOException e) {
            throw new FileParseException("Failed to read file: " + fileName + e.getMessage());
        }

        return allQuestions;

    }
}
