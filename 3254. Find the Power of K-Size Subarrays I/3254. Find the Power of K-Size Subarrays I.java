/*
 * Problem: 3254. Find the Power of K-Size Subarrays I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1)
            return nums;
        int[] MQ = new int[nums.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < k; i++) {
            while (l < r && nums[i] != nums[MQ[r - 1]] + 1) {
                r--;
            }
            MQ[r++] = i;
        }
        int[] res = new int[nums.length - k + 1];
        if (r - l == k) {
            res[0] = nums[MQ[r - 1]];
        } else {
            res[0] = -1;
        }
        for (int i = k; i < nums.length; i++) {
            if (MQ[l] == i - k)
                l++;
            while (l < r && nums[i] != nums[MQ[r - 1]] + 1) {
                r--;
            }
            MQ[r++] = i;
            if (r - l == k) {
                res[i - k + 1] = nums[MQ[r - 1]];
            } else {
                res[i - k + 1] = -1;
            }
        }
        return res;
    }
}
