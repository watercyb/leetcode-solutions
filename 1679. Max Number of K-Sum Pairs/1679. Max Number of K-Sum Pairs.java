/*
 * Problem: 1679. Max Number of K-Sum Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxOperations(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                nums[i] = 0;
                l++;
            }
        }
        Arrays.sort(nums);
        int res = 0;
        while (l < r) {
            if (nums[l] + nums[r] > k) {
                r--;
            } else if (nums[l] + nums[r] < k) {
                l++;
            } else {
                res++;
                l++;
                r--;
            }
        }
        return res;
    }
}
