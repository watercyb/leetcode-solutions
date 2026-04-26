/*
 * Problem: 2342. Max Sum of a Pair With Equal Sum of Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int maximumSum(int[] nums) {
        int[] max = new int[82];
        Arrays.fill(max, Integer.MIN_VALUE);
        int res = -1;
        for (int num : nums) {
            int sum = 0;
            int n = num;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            res = Math.max(max[sum] + num, res);
            max[sum] = Math.max(num, max[sum]);
        }
        return res;
    }
}
