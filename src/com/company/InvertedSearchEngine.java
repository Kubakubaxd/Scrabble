package com.company;

import java.util.Arrays;
import java.util.HashSet;

public class InvertedSearchEngine {
    HashSet<String> library;
    HashSet<String> result = new HashSet<>();

    public InvertedSearchEngine(HashSet<String> library) {
        this.library = library;
    }

    public HashSet<String> find(String letters){
        for(String word : library){
            if(compare(letters, word)){
                result.add(word);
            }
        }
        return result;
    }


    boolean compare(String letters, String word) {
        char[] wordChars = word.toCharArray();
        char[] letterChars = letters.toCharArray();
        boolean searchNext = true;
        for (char wordChar : wordChars) {
            searchNext = false;
            for (int i = letterChars.length-1; i >= 0; i--) {
                //System.out.print("i : "+ i + "charlen: " + letterChars.length+ " " +wordChar + "==" + letterChars[i] + "  " + Arrays.toString(letterChars));
                if (wordChar == letterChars[i]) {
                    letterChars = removeCharAt(letterChars, i);
                   // System.out.println(" T");
                    searchNext = true;
                    break;
                }
                //else System.out.println(" F");
            }
            if (!searchNext){
               // System.out.print("Z powodu przerwania: ");
                return false;
            }
        }
        //System.out.print("WYSZŁO :");
        return searchNext;
    }

    public char[] removeCharAt(char[] chars, int at) {
        char[] result = new char[chars.length - 1];
        int i = 0;
        for (int last_insert = 0; last_insert < chars.length-1; last_insert++) {
            if (i == at) i++;
            result[last_insert] = chars[i];
            i++;
        }
        return result;
    }

}
