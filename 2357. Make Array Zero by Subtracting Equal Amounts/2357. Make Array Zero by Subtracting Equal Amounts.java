/*
 * Problem: 2357. Make Array Zero by Subtracting Equal Amounts
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[101];
        seen[0] = true;
        int res = 0;
        for (int num : nums) {
            if (!seen[num]) {
                res++;
                seen[num] = true;
            }
        }
        return res;
    }
}
