/*
 * Problem: 2448. Minimum Cost to Make Array Equal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-make-array-equal/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int l = 0;
        int r = 1000000;
        long sum = 0;
        for (int c : cost) {
            sum += c;
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (2 * chk(nums, cost, mid) >= sum) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (long) Math.abs(nums[i] - l) * cost[i];
        }
        return res;
    }

    public long chk(int[] nums, int[] cost, int mid) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid)
                res += cost[i];
        }
        return res;
    }
}
