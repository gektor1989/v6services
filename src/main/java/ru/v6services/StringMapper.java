package ru.v6services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StringMapper {

    public static Map<String, Integer> stringToTreeMapWithDuplicatesLineQuantity(String src) {
        Map<String, Integer> sortedSrcMap = new TreeMap<>();
        return getSrcMap(src, sortedSrcMap);
    }

    public static Map<String, Integer> stringToHashMapWithDuplicatesLineQuantity(String src) {
        Map<String, Integer> srcMap = new HashMap<>();
        return getSrcMap(src, srcMap);
    }

    public static Map<String, Integer> stringToMapWithCharLineQuantity(String src) {
        Map<String, Integer> sortedSrc = new HashMap<>();
        try (Scanner scanner = new Scanner(src)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                sortedSrc.put(line, line.toCharArray().length);
            }
        }
        return sortedSrc;
    }

    private static Map<String, Integer> getSrcMap(String src, Map<String, Integer> sortedSrc) {
        try (Scanner scanner = new Scanner(src)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (sortedSrc.containsKey(line)) {
                    sortedSrc.put(line, sortedSrc.get(line) + 1);
                } else {
                    sortedSrc.put(line, 1);
                }
            }
        }
        return sortedSrc;
    }

}