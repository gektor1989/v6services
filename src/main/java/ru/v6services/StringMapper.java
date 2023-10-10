package ru.v6services;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StringMapper {

    public static Map<String, Integer> stringToTreeMap(String src) {
        Map<String, Integer> sortedSrc = new TreeMap<>();
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