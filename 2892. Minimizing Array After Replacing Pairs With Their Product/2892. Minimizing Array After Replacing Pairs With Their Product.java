/*
 * Problem: 2892. Minimizing Array After Replacing Pairs With Their Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimizing-array-after-replacing-pairs-with-their-product/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minArrayLength(int[] nums, int k) {
        long product = nums[0];
        int res = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0)
                return 1;
            if (product == 0) {
                product = nums[i];
            } else {
                product *= nums[i];
                if (product <= k) {
                    res--;
                } else {
                    product = nums[i];
                }
            }
        }
        return res;
    }
}
