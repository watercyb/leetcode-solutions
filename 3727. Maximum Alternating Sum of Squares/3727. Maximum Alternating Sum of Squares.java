/*
 * Problem: 3727. Maximum Alternating Sum of Squares
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-alternating-sum-of-squares/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i + min;
            }
        }
        long res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            res += (long) nums[r] * nums[r] - (long) nums[l] * nums[l];
            l++;
            r--;
        }
        if (l == r)
            res += (long) nums[l] * nums[l];
        return res;
    }
}
