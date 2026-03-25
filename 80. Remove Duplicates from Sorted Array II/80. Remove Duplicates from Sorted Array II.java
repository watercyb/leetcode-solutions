/*
 * Problem: 80. Remove Duplicates from Sorted Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int prv = nums[0];
        int count = 1;
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prv) {
                if (count == 2) {
                    continue;
                } else {
                    count++;
                }
            } else {
                prv = nums[i];
                count = 1;
            }
            int tmp = nums[idx];
            nums[idx++] = nums[i];
            nums[i] = tmp;
        }
        return idx;
    }
}
