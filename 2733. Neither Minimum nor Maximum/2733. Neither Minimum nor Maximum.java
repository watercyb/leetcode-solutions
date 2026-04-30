/*
 * Problem: 2733. Neither Minimum nor Maximum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/neither-minimum-nor-maximum/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int findNonMinOrMax(int[] nums) {
        boolean[] seens = new boolean[101];
        for (int num : nums) {
            seens[num] = true;
        }
        int idx = 0;
        while (!seens[idx]) {
            idx++;
        }
        idx++;
        while (idx < seens.length && !seens[idx]) {
            idx++;
        }
        if (idx == seens.length)
            return -1;
        int res = idx;
        idx++;
        while (idx < seens.length && !seens[idx]) {
            idx++;
        }
        if (idx == seens.length)
            return -1;
        return res;
    }
}
