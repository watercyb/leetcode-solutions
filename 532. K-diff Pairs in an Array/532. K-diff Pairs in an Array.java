/*
 * Problem: 532. K-diff Pairs in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 1;
        int prv = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == prv)
                continue;
            prv = nums[i];
            if (j <= i)
                j = i + 1;
            while (j < nums.length && nums[j] - nums[i] < k) {
                j++;
            }
            if (j == nums.length)
                break;
            if (nums[j] - nums[i] == k)
                res++;
        }
        return res;
    }
}
