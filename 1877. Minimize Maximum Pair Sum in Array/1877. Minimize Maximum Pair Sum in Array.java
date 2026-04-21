/*
 * Problem: 1877. Minimize Maximum Pair Sum in Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minPairSum(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
           max = Math.max(nums[i], max);
        }
        int[] counts = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int l = 0;
        int r = max;
        int res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            while (counts[l] == 0) {
                l++;
            }
            while (counts[r] == 0) {
                r--;
            }
            res = Math.max(l + r, res);
            counts[l]--;
            counts[r]--;
        }
        return res;
    }
}
