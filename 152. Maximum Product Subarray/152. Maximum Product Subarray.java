/*
 * Problem: 152. Maximum Product Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int pro = 1;
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            res = Math.max(pro, res);
            if (pro == 0)
                pro = 1;
        }
        pro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            pro *= nums[i];
            res = Math.max(pro, res);
            if (pro == 0)
                pro = 1;
        }
        return res;
    }
}
