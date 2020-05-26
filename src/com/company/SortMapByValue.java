package com.company;

import java.util.*;
 import java.util.Map.Entry;
 import java.util.stream.Collectors;

 public class SortMapByValue

 {
    private static boolean ASC = true;
    private static boolean DESC = false;


    public LinkedHashMap<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    public void printMap(Map<String, Integer> map)
    {
        map.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
    }
}