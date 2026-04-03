/*
 * Problem: 410. Split Array Largest Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/split-array-largest-sum/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = Integer.MAX_VALUE;
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
        int sum = 0;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] > mid)
                return false;
            if (sum + nums[i] > mid) {
                sum = nums[i];
                k--;
            } else {
                sum += nums[i];
            }
        }
        return k > 0;
    }
}
