/*
 * Problem: 1550. Three Consecutive Odds
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/three-consecutive-odds/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                if (count++ == 2)
                    return true;
            } else {
                count = 0;
            }
        }
        return false;
    }
}
