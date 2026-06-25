/*
 * Problem: 3969. Valid Subarrays With Matching Sum Digits I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-subarrays-with-matching-sum-digits-i/
 * Language: java
 * Date: 2026-06-25
 */

class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        long low = x;
        long high = x + 1;
        int res = 0;
        while (low <= sums[nums.length]) {
            int[] counts = new int[10];
            int l = 0;
            int r = 0;
            long sum = 0;
            for (int num : nums) {
                sum += num;
                while (l < sums.length && sum - sums[l] >= low) {
                    counts[(int) (sums[l] % 10)]++;
                    l++;
                }
                while (r < sums.length && sum - sums[r] > high) {
                    counts[(int) (sums[r] % 10)]--;
                    r++;
                }
                res += counts[(int) ((sum - x + 10) % 10)];
            }
            low *= 10;
            high *= 10;
        }
        return res;
    }
}
