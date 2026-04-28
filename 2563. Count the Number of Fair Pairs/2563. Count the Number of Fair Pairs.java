/*
 * Problem: 2563. Count the Number of Fair Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-fair-pairs/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        for (int i = 0; i < k; i++) {
            if (j < i) {
                j++;
            } else {
                while (j > i && nums[i] + nums[j] >= lower) {
                    j--;
                }
            }
            while (k > j && nums[i] + nums[k] > upper) {
                k--;
            }
            res += k - j;
        }
        return res;
    }
}
