/*
 * Problem: 3064. Guess the Number Using Bitwise Questions I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/guess-the-number-using-bitwise-questions-i/
 * Language: java
 * Date: 2026-05-03
 */

/**
 * Definition of commonSetBits API (defined in the parent class Problem).
 * int commonSetBits(int num);
 */

public class Solution extends Problem {
    public int findNumber() {
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            if (commonSetBits(1 << i) == 1)
                res += 1 << i;
        }
        return res;
    }
}
