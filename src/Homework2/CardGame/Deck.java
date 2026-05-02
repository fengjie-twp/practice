package Homework2.CardGame;

import java.util.Random;

public class Deck {

    private final Card[] cards = new Card[52]; // 一副牌固定52张
    private int cardsUsed = 0;                 // 已经发出的牌数（下一个要发的索引）
    private final Random rand = new Random();

    public Deck() {
        // 4种花色
        String[] suits = {"\u2663", "\u2666", "\u2665", "\u2660"};
        // 13种牌面
        String[] points = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "A"};
        // 对应的大小
        int[] values  = { 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10, 11, 12, 13, 14};
        int index = 0;
        for (String suit : suits) {
            for (int i = 0; i < points.length; i++) {
                cards[index++] = new Card(values[i], suit, points[i]);
            }
        }
    }

    // 洗牌：把cards数组随机打乱，并把 cardsUsed 重置为0
    public void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // 0..i
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        cardsUsed = 0;
    }

    // 发一张牌：按当前顺序发出下一张
    public Card dealCard() {
        if (cardsUsed >= cards.length) {
            return null; // 发完了
        }
        return cards[cardsUsed++];
    }
}
