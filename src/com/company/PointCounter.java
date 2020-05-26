package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class PointCounter {
    private final Map<Character, Integer> punctation;

    public PointCounter() {
        punctation = loadPunctation();
    }

    public LinkedHashMap<String, Integer> calculate(HashSet<String> foundWords) {
        SortMapByValue mapSorter = new SortMapByValue();
        Map<String, Integer> mapWithPoints = pointsToWords(foundWords);
        return mapSorter.sortByValue(mapWithPoints, false);
    }

    private Map<String, Integer> pointsToWords(HashSet<String> foundWords) {
        Map<String, Integer> calculatedWords = new HashMap<>();
        for (String word : foundWords) {
            calculatedWords.put(word, count(word));
        }
        return calculatedWords;
    }

    private int count(String word) {
        int points = 0;
        for (char letter : word.toCharArray()) {
            points += punctation.get(letter);
        }
        return points;
    }


    private Map<Character, Integer> loadPunctation() {

        Map<Character, Integer> punctation = new HashMap<>();
        punctation.put('a', 1);
        punctation.put('ą', 5);
        punctation.put('b', 3);
        punctation.put('c', 2);
        punctation.put('ć', 6);
        punctation.put('d', 2);
        punctation.put('e', 1);
        punctation.put('ę', 5);
        punctation.put('f', 5);
        punctation.put('g', 3);
        punctation.put('h', 3);
        punctation.put('i', 1);
        punctation.put('j', 3);
        punctation.put('k', 2);
        punctation.put('l', 2);
        punctation.put('ł', 3);
        punctation.put('m', 2);
        punctation.put('n', 1);
        punctation.put('ń', 7);
        punctation.put('o', 1);
        punctation.put('ó', 5);
        punctation.put('p', 2);
        punctation.put('r', 1);
        punctation.put('s', 1);
        punctation.put('ś', 5);
        punctation.put('t', 2);
        punctation.put('q', 0);
        punctation.put('u', 3);
        punctation.put('w', 1);
        punctation.put('y', 2);
        punctation.put('z', 1);
        punctation.put('ż', 5);
        punctation.put('ź', 9);

        punctation.put(' ', 0);
        punctation.put('?', 0);
        punctation.put('x', 0);
        punctation.put('v', 0);

        return punctation;
    }


}
