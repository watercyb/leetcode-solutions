/*
 * Problem: 2347. Best Poker Hand
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/best-poker-hand/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if (chk1(suits))
            return "Flush";
        int h = chk2(ranks, suits);
        if (h == 3)
            return "Three of a Kind";
        if (h == 1)
            return "Pair";
        return "High Card";
    }

    public boolean chk1(char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0])
                return false;
        }
        return true;
    }

    public int chk2(int[] ranks, char[] suits) {
        int res = 0;
        int[] counts = new int[14];
        for (int rank : ranks) {
            if (++counts[rank] == 2) {
                res |= 1;
            } else if (counts[rank] == 3) {
                res |= 2;
            }
        }
        return res;
    }
}
