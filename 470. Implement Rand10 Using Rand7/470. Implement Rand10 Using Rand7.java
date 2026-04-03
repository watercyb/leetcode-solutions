/*
 * Problem: 470. Implement Rand10() Using Rand7()
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/implement-rand10-using-rand7/
 * Language: java
 * Date: 2026-04-03
 */

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a = rand7();
        int b = rand7();
        int num = (a - 1) * 7 + b;
        if (num > 40)
            return rand10();
        return num % 10 + 1;
    }
}
