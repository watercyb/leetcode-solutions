/*
 * Problem: 3577. Count the Number of Computer Unlocking Permutations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int countPermutations(int[] complexity) {
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0])
                return 0;
        }
        long res = 1;
        for (int i = 2; i < complexity.length; i++) {
            res = res * i % 1_000_000_007;
        }
        return (int) res;
    }
}
