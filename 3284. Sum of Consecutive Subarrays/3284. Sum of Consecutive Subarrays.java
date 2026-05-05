/*
 * Problem: 3284. Sum of Consecutive Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-consecutive-subarrays/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int getSum(int[] nums) {
        long res = nums[nums.length - 1];
        int l = 0;
        while (l < nums.length - 1) {
            int r = l + 1;
            int diff = nums[r] - nums[l];
            if (Math.abs(diff) != 1) {
                res += nums[l];
                l = r;
            } else {
                long sum = nums[l];
                long sumSum = nums[l];
                while (r < nums.length && nums[r] - nums[r - 1] == diff) {
                    sum += nums[r];
                    sumSum += sum;
                    r++;
                }
                while (l < r) {
                    res += sumSum;
                    sumSum -= (long) (r - l) * nums[l];
                    l++;
                }
                l -= 1;
                res -= nums[l];
            }
        }
        return (int) (res % 1_000_000_007);
    }
}
