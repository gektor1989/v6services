package ru.v6services;

import java.util.Map;

import static ru.v6services.FileLoader.*;
import static ru.v6services.StringMapper.*;

public class LineCounter {

    private static final String TEXT_SRC = "src\\main\\resources\\src.txt";
    private static final String TEXT_OUT = "src\\main\\resources\\out.txt";

    private static boolean sortByAlphabet(String filePath) {
        String src = readFile(filePath);
        Map<String, Integer> sortedSrc = stringToTreeMap(src);
        return writeToFile(sortedSrc, TEXT_OUT);
    }

    private static void sortByLineCharQuantity() {

    }

    private static void sortByWord() {

    }


    public static void main(String[] args) {
        System.out.println(sortByAlphabet(TEXT_SRC));
    }

}