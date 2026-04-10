/*
 * Problem: 950. Reveal Cards In Increasing Order
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int i = 0;
        int j = 0;
        boolean skp = false;
        int[] res = new int[deck.length];
        while (i < deck.length) {
            if (j == deck.length)
                j = 0;
            if (res[j] == 0) {
                if (!skp)
                    res[j] = deck[i++];
                skp = !skp;
            }
            j++;
        }
        return res;
    }
}
