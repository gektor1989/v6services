package ru.v6services;

import java.util.Arrays;

public class Validator {

    public static boolean validateWordPosition(String src, int wordPosition) {
        long count = Arrays.stream(src.split("\n"))
                .mapToInt(s -> s.split(" ").length)
                .filter(value -> (value - 1) < wordPosition)
                .count();
        return count > 0 ? false : true;
    }

    public static boolean validateFilePath(String filePath) {
        return filePath != null;
    }

}