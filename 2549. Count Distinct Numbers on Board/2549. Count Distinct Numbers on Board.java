/*
 * Problem: 2549. Count Distinct Numbers on Board
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-distinct-numbers-on-board/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int distinctIntegers(int n) {
        if (n>1) return n-1;
        return 1;
    }
}
