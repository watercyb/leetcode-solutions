/*
 * Problem: 2654. Minimum Number of Operations to Make All Array Elements Equal to 1
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count++;
        }
        if (count > 0)
            return nums.length - count;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            int j = i + 1;
            while (j < nums.length && gcd != 1) {
                gcd = GCD(gcd, nums[j]);
                j++;
            }
            if (gcd != 1)
                break;
            res = Math.min(res, j - i);
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res + nums.length - 2;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
