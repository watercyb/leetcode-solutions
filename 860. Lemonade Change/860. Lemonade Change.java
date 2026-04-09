/*
 * Problem: 860. Lemonade Change
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/lemonade-change/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] counts = new int[2];
        for (int bill : bills) {
            if (bill == 20) {
                if (counts[1] > 0 && counts[0] > 0) {
                    counts[1]--;
                    counts[0]--;
                } else if (counts[0] > 2) {
                    counts[0] -= 3;
                } else {
                    return false;
                }
            } else if (bill == 10) {
                if (counts[0] > 0) {
                    counts[0]--;
                } else {
                    return false;
                }
                counts[1]++;
            } else {
                counts[0]++;
            }
        }
        return true;
    }
}
