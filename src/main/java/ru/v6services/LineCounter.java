package ru.v6services;

import java.util.*;

import static ru.v6services.FileLoader.*;
import static ru.v6services.StringMapper.*;
import static ru.v6services.Sorter.*;
import static ru.v6services.Validator.validateFilePath;
import static ru.v6services.Validator.validateWordPosition;

/**
 * LineCounter
 *
 * @author vlsolovev@gmail.com
 * @version 1.0.0
 */
public class LineCounter {

    private static final String TEXT_SRC = "src\\main\\resources\\src.txt";
    private static final String TEXT_OUT = "src\\main\\resources\\out.txt";

    /**
     * Method for sorting text file in alphabet order (sorting unit is line)
     *
     * @param filePath is path to file + file name
     * @return true if sorting is Ok (and in this case soring text is sent to out.txt), false if sorting canceled
     */
    public static boolean sortByAlphabet(String filePath) {
        if (!validateFilePath(filePath)) {
            return false;
        }
        String src = readFile(filePath);
        Map<String, Integer> sortedSrc = stringToTreeMapWithDuplicatesLineQuantity(src);
        return writeToFile(sortedSrc, TEXT_OUT);
    }

    /**
     * Method for sorting text file by line character quantity (sorting unit is line)
     *
     * @param filePath is path to file + file name
     * @return true if sorting is Ok (and in this case soring text is sent to out.txt), false if sorting canceled
     */
    public static boolean sortByLineCharQuantity(String filePath) {
        if (!validateFilePath(filePath)) {
            return false;
        }
        String src = readFile(filePath);
        Map<String, Integer> srcMapWithCharLineQuantity = stringToMapWithCharLineQuantity(src);
        Map<String, Integer> srcMapWithDuplicates = stringToHashMapWithDuplicatesLineQuantity(src);
        List<Integer> sortedCharLineQuantity = sortByCharQuantity(srcMapWithCharLineQuantity);
        Map<String, Integer> sortedSrc = sortMapByCharQuantity(srcMapWithCharLineQuantity, srcMapWithDuplicates, sortedCharLineQuantity);
        return writeToFile(sortedSrc, TEXT_OUT);
    }

    /**
     * Method for sorting text file by certain word in parameter (sorting unit is line)
     *
     * @param filePath is path to file + file name
     * @param wordPosition word position in lines
     * @return true if sorting is Ok (and in this case soring text is sent to out.txt), false if sorting canceled
     */
    public static boolean sortByWord(String filePath, int wordPosition) {
        if (!validateFilePath(filePath)) {
            return false;
        }
        String src = readFile(filePath);
        if (!validateWordPosition(src, wordPosition)) {
            System.out.println("Check word position " + wordPosition);
            return false;
        }
        Map<String, String> srcMapWithSortingWords = stringToMapWithSortingWords(src, wordPosition);
        Map<String, Integer> srcMapWithDuplicates = stringToHashMapWithDuplicatesLineQuantity(src);
        List<String> sortedByWords = sortByWords(srcMapWithSortingWords);
        Map<String, Integer> sortedSrc = sortMapByWords(srcMapWithSortingWords, srcMapWithDuplicates, sortedByWords);
        return writeToFile(sortedSrc, TEXT_OUT);
    }


    public static void main(String[] args) {
        System.out.println(sortByAlphabet(TEXT_SRC));
//        System.out.println(sortByLineCharQuantity(TEXT_SRC));
//        System.out.println(sortByWord(TEXT_SRC, 1));
    }

}