package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IO io = new IO();
        PointCounter pointCounter = new PointCounter();
        RegexGenerator regexGenerator = new RegexGenerator();
        Library library = new Library("slowa.txt");
        InvertedSearchEngine invertedSearchEngine = new InvertedSearchEngine(library.getSimpleLib());

        String userLetters = "";

        System.out.print("Ile wyników?: ");
        int howManyWords = scan.nextInt();

        while (!userLetters.equals("1")) {
            System.out.print("litery: ");
            userLetters = scan.next();
            if (userLetters.equals("1")) return;
            else System.out.println(userLetters);


            var foundWords = invertedSearchEngine.find(userLetters);
            var foundWordsWithPoints = pointCounter.calculate(foundWords);
            io.readMap(foundWordsWithPoints);

            System.out.print("Scan: ");
            scan.nextLine();
            String regex = scan.nextLine();
            regexGenerator.analyse(foundWordsWithPoints, regex, howManyWords);
        }
    }
}
