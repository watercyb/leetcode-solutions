/*
 * Problem: 3718. Smallest Missing Multiple of K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-missing-multiple-of-k/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] seens = new boolean[101];
        for (int num : nums) {
            seens[num] = true;
        }
        int res = k;
        while (res < seens.length) {
            if (!seens[res])
                break;
            res += k;
        }
        return res;
    }
}
