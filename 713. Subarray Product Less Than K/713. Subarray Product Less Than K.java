/*
 * Problem: 713. Subarray Product Less Than K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subarray-product-less-than-k/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int pro = 1;
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            pro *= nums[r];
            while (pro >= k) {
                pro /= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
