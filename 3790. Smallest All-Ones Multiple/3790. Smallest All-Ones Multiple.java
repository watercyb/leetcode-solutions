/*
 * Problem: 3790. Smallest All-Ones Multiple
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-all-ones-multiple/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0)
            return -1;
        int num = 0;
        for (int i = 1; i <= k; i++) {
            num = (num * 10 + 1) % k;
            if (num == 0)
                return i;
        }
        return -1;
    }
}
