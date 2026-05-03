/*
 * Problem: 3011. Find if Array Can Be Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-if-array-can-be-sorted/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public boolean canSortArray(int[] nums) {
        int prv = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int min = nums[i];
            int max = nums[i];
            while (j < nums.length && Integer.bitCount(nums[j]) == Integer.bitCount(nums[i])) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                j++;
            }
            if (min < prv)
                return false;
            prv = max;
            i = j;
        }
        return true;
    }
}
