package ru.v6services;

import java.util.List;
import java.util.Map;

import static ru.v6services.FileLoader.*;
import static ru.v6services.StringMapper.*;
import static ru.v6services.Sorter.*;

public class LineCounter {

    private static final String TEXT_SRC = "src\\main\\resources\\src.txt";
    private static final String TEXT_OUT = "src\\main\\resources\\out.txt";

    private static boolean sortByAlphabet(String filePath) {
        String src = readFile(filePath);
        Map<String, Integer> sortedSrc = stringToTreeMapWithDuplicatesLineQuantity(src);
        return writeToFile(sortedSrc, TEXT_OUT);
    }

    private static boolean sortByLineCharQuantity(String filePath) {
        String src = readFile(filePath);
        Map<String, Integer> srcMapWithCharLineQuantity = stringToMapWithCharLineQuantity(src);
        Map<String, Integer> srcMapWithDuplicates = stringToHashMapWithDuplicatesLineQuantity(src);
        List<Integer> sortedCharLineQuantity = sortByCharQuantity(srcMapWithCharLineQuantity);
        Map<String, Integer> sortedSrc = sortMapByCharQuantity(srcMapWithCharLineQuantity, srcMapWithDuplicates, sortedCharLineQuantity);
        return writeToFile(sortedSrc, TEXT_OUT);
    }

    private static boolean sortByWord(String filePath) {
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(sortByAlphabet(TEXT_SRC));
        sortByLineCharQuantity(TEXT_SRC);
    }

}