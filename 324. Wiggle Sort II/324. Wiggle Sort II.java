/*
 * Problem: 324. Wiggle Sort II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/wiggle-sort-ii/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public void wiggleSort(int[] nums) {
        int[] counts = new int[5001];
        for (int num : nums) {
            counts[num]++;
        }
        int i = 1;
        int j = 5000;
        while (i < nums.length) {
            while (counts[j] == 0) {
                j--;
            }
            nums[i] = j;
            i += 2;
            counts[j]--;
        }
        i = 0;
        while (i < nums.length) {
            while (counts[j] == 0) {
                j--;
            }
            nums[i] = j;
            i += 2;
            counts[j]--;
        }
    }
}
