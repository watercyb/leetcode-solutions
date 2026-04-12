/*
 * Problem: 1099. Two Sum Less Than K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum-less-than-k/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int[] counts = new int[1001];
        for (int num : nums) {
            counts[num]++;
        }
        int idx = 0;
        for (int i = 0; i <= 1000; i++) {
            while (counts[i] > 0) {
                nums[idx++] = i;
                counts[i]--;
            }
        }
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum >= k) {
                r--;
            } else {
                res = Math.max(sum, res);
                l++;
            }
        }
        return res;
    }
}
