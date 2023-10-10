package ru.v6services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sorter {

    public static List<Integer> sortByCharQuantity(Map<String, Integer> srcMap) {
        return srcMap.values().stream().sorted().collect(Collectors.toList());
    }

    public static Map<String, Integer> sortMapByCharQuantity(Map<String, Integer> srcMapWithCharLineQuantity,
                                                             Map<String, Integer> srcMapWithDuplicates,
                                                             List<Integer> sortedListByCharQuantity) {
        Map<String, Integer> sortedMapByCharQuantity = new LinkedHashMap<>();
        sortedListByCharQuantity.forEach(i -> {
            srcMapWithCharLineQuantity.forEach((key, value) -> {
                if (value.equals(i)) {
                    for (int j = 0; j < srcMapWithDuplicates.get(key); j++) {
                        sortedMapByCharQuantity.put(key, srcMapWithDuplicates.get(key));
                    }
                }
            });
        });
        return sortedMapByCharQuantity;
    }

}