/*
 * Problem: 3190. Find Minimum Operations to Make All Elements Divisible by Three
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (num % 3 != 0)
                res++;
        }
        return res;
    }
}
