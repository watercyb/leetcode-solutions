/*
 * Problem: 2350. Shortest Impossible Sequence of Rolls
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int res = 0;
        int idx = 0;
        while (idx < rolls.length) {
            boolean[] seens = new boolean[k];
            int count = 0;
            while (idx < rolls.length && count < k) {
                if (!seens[rolls[idx] - 1]) {
                    seens[rolls[idx] - 1] = true;
                    count++;
                }
                idx++;
            }
            if (count == k)
                res++;
        }
        return res + 1;
    }
}
