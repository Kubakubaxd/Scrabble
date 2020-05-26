package com.company;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGenerator {

    public String createRegex(String question) {
        String command = "^";

        for (char letter : question.toCharArray()) {
            if (letter == '?') command += ".";
            else if (letter == '.') command += "[a-ząęłżźó]*";
            else command += letter;
        }
        command += "$";
        return command;
    }

    public void analyse(Map<String, Integer> found, String question, int printLimit) {
        String pattern = createRegex(question);
        Pattern compiledPattern = Pattern.compile(pattern);
        System.out.println(pattern);
        int i = 0;
        for (Map.Entry<String, Integer> entry : found.entrySet()) {
            if(i >= printLimit) return;
            else i++;

            Matcher matcher = compiledPattern.matcher(entry.getKey());
            if (matcher.matches()) System.out.println(entry.getValue() + " : " + entry.getKey());
        }
    }
}
