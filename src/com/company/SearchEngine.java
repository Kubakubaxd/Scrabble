package com.company;

import java.util.HashSet;

public class SearchEngine {
    private int bufferLimit = 100000;
    private HashSet<String> buffer = new HashSet<>();
    private HashSet<String> permuteRestWords = new HashSet<>();
    private HashSet<String> library;
    private HashSet<String> foundWords = new HashSet<>();

    public SearchEngine(HashSet<String> library) {
        this.library = library;
    }

    public HashSet<String> generate(String letters) {
        long startTime = System.currentTimeMillis();
        permute(letters, 0, letters.length() - 1);
        System.out.println("Czas permute: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
        startTime = System.currentTimeMillis();
        permuteRest(letters);
        System.out.println("Czas permuteRest: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
        search();
        return foundWords;
    }

    public void permuteRest(String letters) {
        int lettersLength = letters.length();
        if (lettersLength <= 2) return;

        for (int i = 0; i < lettersLength; i++) {
            StringBuilder sb = new StringBuilder(letters);
            String newLetters = sb.deleteCharAt(i).toString();
            if(!permuteRestWords.contains(newLetters)) {
                permuteRestWords.add(newLetters);
                permute(newLetters, 0, newLetters.length() - 1);
            }
            permuteRest(newLetters);
        }
    }

    public void permute(String str, int l, int r) {
        if (l == r) {
            buffer.add(str);
            if (buffer.size() >= bufferLimit) {
                search();
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private void search() {
        compareWithLib(buffer);
        buffer.clear();
    }

    public void compareWithLib(HashSet<String> possibleWords) {
        for (String possibleWord : possibleWords)
            if (library.contains(possibleWord))
                foundWords.add(possibleWord);
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
