/*
 * Problem: 1283. Find the Smallest Divisor Given a Threshold
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 1000000;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, threshold, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int threshold, int mid) {
        int res = 0;
        for (int num : nums) {
            res += (num + mid - 1) / mid;
            if (res > threshold)
                return false;
        }
        return true;
    }
}
