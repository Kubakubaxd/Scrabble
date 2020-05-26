package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class Library {
    List<LinkedHashMap<String, Integer>> libMap;
    PointCounter pointCounter = new PointCounter();
    private HashSet<String> simpleLib;

    public Library(String fileName) {
        this.simpleLib = new HashSet<>(readFile(fileName));
    }

    public HashSet<String> getSimpleLib() {
        return simpleLib;
    }

    public List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}