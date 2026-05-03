/*
 * Problem: 3094. Guess the Number Using Bitwise Questions II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/guess-the-number-using-bitwise-questions-ii/
 * Language: java
 * Date: 2026-05-03
 */

/**
 * Definition of commonBits API (defined in the parent class Problem).
 * int commonBits(int num);
 */

public class Solution extends Problem {
    public int findNumber() {
        int res = 0;
        int count = commonBits(0);
        for (int i = 0; i <= 30; i++) {
            int countNext = commonBits(1 << i);
            if (countNext > count) {
                res += 1 << i;
            }
            count = countNext;
        }
        return res;
    }
}
