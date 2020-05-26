package com.company;

public class Letter {
    char letter;
    int points;

    public Letter(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    public char getLetter() {
        return letter;
    }
    public void setLetter(char letter) {
        this.letter = letter;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}
