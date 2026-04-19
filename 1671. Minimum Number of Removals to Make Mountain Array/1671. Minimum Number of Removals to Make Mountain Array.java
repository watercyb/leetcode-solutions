/*
 * Problem: 1671. Minimum Number of Removals to Make Mountain Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] DP = new int[nums.length + 1];
        int idx = 0;
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = binarySearch(DP, idx, nums[i]);
            if (left[i] > idx) {
                DP[++idx] = nums[i];
            } else if (DP[left[i]] > nums[i]) {
                DP[left[i]] = nums[i];
            }
        }
        idx = 0;
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i > 0; i--) {
            right[i] = binarySearch(DP, idx, nums[i]);
            if (right[i] > idx) {
                DP[++idx] = nums[i];
            } else if (DP[right[i]] > nums[i]) {
                DP[right[i]] = nums[i];
            }
        }
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (left[i] > 1 && right[i] > 1)
                res = Math.max(left[i] + right[i], res);
        }
        return nums.length - res + 1;
    }

    public int binarySearch(int[] DP, int idx, int num) {
        int l = 0;
        int r = idx + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
