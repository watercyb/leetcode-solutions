/*
 * Problem: 2134. Minimum Swaps to Group All 1's Together II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minSwaps(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int count = 0;
        for (int i = 0; i < total; i++) {
            count += nums[i];
        }
        int res = total - count;
        for (int i = 0; i < nums.length - 1 && res > 0; i++) {
            int j = (i + total) % nums.length;
            count += -nums[i] + nums[j];
            res = Math.min(total - count, res);
        }
        return res;
    }
}
