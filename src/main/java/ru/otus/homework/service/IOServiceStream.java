package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStream implements IOService {

    private final PrintStream output;

    private final Scanner input;

    public IOServiceStream() {
        this.output = System.out;
        this.input = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return input.nextLine();
    }

    @Override
    public void printString(String str) {
        output.println(str);
    }
}
