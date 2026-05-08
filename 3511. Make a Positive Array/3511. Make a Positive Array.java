/*
 * Problem: 3511. Make a Positive Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-a-positive-array/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int makeArrayPositive(int[] nums) {
        int res = 0;
        long min=Long.MIN_VALUE / 2;
        long max1 = 0l;
        long max2 = min;
        long max3 = min;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum <= max3) {
                res++;
                max1 = 0l;
                max2 = min;
                max3 = min;
                sum = 0;
            } else {
                max3 = Math.max(max2, max3);
                max2 = max1;
                max1 = sum;
            }
        }
        return res;
    }
}
