/*
 * Problem: 2815. Max Pair Sum in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/max-pair-sum-in-an-array/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int maxSum(int[] nums) {
        int[] max = new int[10];
        Arrays.fill(max, Integer.MIN_VALUE);
        int res = -1;
        for (int num : nums) {
            int temp = num;
            int digit = 0;
            while (temp > 0) {
                digit = Math.max(temp % 10, digit);
                temp /= 10;
            }
            res = Math.max(max[digit] + num, res);
            max[digit] = Math.max(max[digit], num);
        }
        return res;
    }
}
