/*
 * Problem: 1927. Sum Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-game/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean sumGame(String num) {
        char[] chrs = num.toCharArray();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < chrs.length / 2; i++) {
            if (chrs[i] == '?') {
                count++;
            } else {
                sum += chrs[i] - '0';
            }
        }
        for (int i = chrs.length / 2; i < chrs.length; i++) {
            if (chrs[i] == '?') {
                count--;
            } else {
                sum -= chrs[i] - '0';
            }
        }
        if (count == 0)
            return sum != 0;
        if (count % 2 == 1)
            return true;
        return (double) sum / count * 2 != -9;
    }
}
