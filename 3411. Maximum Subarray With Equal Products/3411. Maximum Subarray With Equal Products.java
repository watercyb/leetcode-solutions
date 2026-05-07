/*
 * Problem: 3411. Maximum Subarray With Equal Products
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-subarray-with-equal-products/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxLength(int[] nums) {
        int res = Math.min(nums.length, 2);
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (!chk(nums, i, j))
                    break;
                j++;
            }
            res = Math.max(j - i, res);
        }
        return res;
    }

    public boolean chk(int[] nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if (GCD(nums[k], nums[j]) != 1)
                return false;
        }
        return true;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

}
