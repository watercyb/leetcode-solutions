/*
 * Problem: 1860. Incremental Memory Leak
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/incremental-memory-leak/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        while (true) {
            if (memory1 >= memory2) {
                if (memory1 < i)
                    return new int[] { i, memory1, memory2 };
                memory1 -= i;
            } else {
                if (memory2 < i)
                    return new int[] { i, memory1, memory2 };
                memory2 -= i;
            }
            i++;
        }
    }
}
