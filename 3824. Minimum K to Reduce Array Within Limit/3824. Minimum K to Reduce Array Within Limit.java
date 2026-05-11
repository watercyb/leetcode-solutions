/*
 * Problem: 3824. Minimum K to Reduce Array Within Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-k-to-reduce-array-within-limit/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int minimumK(int[] nums) {
        int max = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int mid) {
        long count = (long) mid * mid;
        for (int i = 0; i < nums.length && count >= 0; i++) {
            count -= (nums[i] + mid - 1) / mid;
        }
        return count >= 0;
    }
}
