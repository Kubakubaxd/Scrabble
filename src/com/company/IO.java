package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

public class IO {
    public void readMap(LinkedHashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " : " + entry.getKey());
        }
    }

    public void readMap(LinkedHashMap<String, Integer> map, int i) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (i <= 0) return;
            i--;
            System.out.println(entry.getValue() + " : " + entry.getKey());
        }
    }
}
