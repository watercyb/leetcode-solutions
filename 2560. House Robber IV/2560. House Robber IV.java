/*
 * Problem: 2560. House Robber IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber-iv/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minCapability(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int l = min;
        int r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int k, int mid) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                k--;
                i++;
            }
        }
        return k <= 0;
    }
}
