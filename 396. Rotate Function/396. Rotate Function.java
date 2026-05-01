/*
 * Problem: 396. Rotate Function
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotate-function/?envType=daily-question&envId=2026-05-01
 * Language: java
 * Date: 2026-05-01
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
