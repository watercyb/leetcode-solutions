/*
 * Problem: 3396. Minimum Number of Operations to Make Elements in Array Distinct
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seens = new boolean[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seens[nums[i]])
                return i / 3 + 1;
            seens[nums[i]] = true;
        }
        return 0;
    }
}
