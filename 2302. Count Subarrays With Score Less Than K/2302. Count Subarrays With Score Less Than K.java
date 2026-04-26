/*
 * Problem: 2302. Count Subarrays With Score Less Than K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-score-less-than-k/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        int l = 0;
        long sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
