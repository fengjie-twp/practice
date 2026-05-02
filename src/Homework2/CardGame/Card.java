package Homework2.CardGame;


public class Card {
    private final int value;
    private final String suit;
    private final String point;

    Card(int value, String suit, String point){
        this.value = value;
        this.suit = suit;
        this.point = point;
    }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return suit + " " + point;
    }
}
