/*
 * Problem: 396. Rotate Function
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotate-function/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int res = f;
        for (int i = 0; i < n - 1; i++) {
            f += nums[i] * n - sum;
            res = Math.max(res, f);
        }
        return res;
    }
}
