/*
 * Problem: 24 Game
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/24-game/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean judgePoint24(int[] cards) {
        double[] cardsDouble = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            cardsDouble[i] = cards[i];
        }
        return dfsNum(cardsDouble, 0, 0);
    }

    public boolean dfsNum(double[] cards, int i, int n) {
        if (n == 3)
            return cards[i] >= 23.99 && cards[i] <= 24.01;
        for (int j = 0; j < cards.length; j++) {
            if (cards[j] == 0)
                continue;
            for (int k = j + 1; k < cards.length; k++) {
                if (cards[k] == 0)
                    continue;
                if (dfsSign(cards, j, k, n))
                    return true;
            }
        }
        return false;
    }

    public boolean dfsSign(double[] cards, int i, int j, int n) {
        double num1 = cards[i];
        double num2 = cards[j];
        cards[j] = 0;
        cards[i] = num1 + num2;
        if (dfsNum(cards, i, n + 1))
            return true;
        cards[i] = num1 - num2;
        if (dfsNum(cards, i, n + 1))
            return true;
        cards[i] = num2 - num1;
        if (dfsNum(cards, i, n + 1))
            return true;
        cards[i] = num1 * num2;
        if (dfsNum(cards, i, n + 1))
            return true;
        if (num2 != 0) {
            cards[i] = num1 / num2;
            if (dfsNum(cards, i, n + 1))
                return true;
        }
        if (num1 != 0) {
            cards[i] = num2 / num1;
            if (dfsNum(cards, i, n + 1))
                return true;
        }
        cards[i] = num1;
        cards[j] = num2;
        return false;
    }
}
