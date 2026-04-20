/*
 * Problem: 1764. Form Array by Concatenating Subarrays of Another Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int idx = 0;
        for (int[] group : groups) {
            idx = chk(group, nums, idx);
            if (idx == -1)
                return false;
        }
        return true;
    }

    public int chk(int[] group, int[] nums, int idx) {
        while (idx <= nums.length - group.length) {
            int i = 0;
            int j = idx;
            while (i < group.length) {
                if (group[i] != nums[j])
                    break;
                i++;
                j++;
            }
            if (i == group.length)
                return j;
            idx++;
        }
        return -1;
    }
}
