/*
 * Problem: 2295. Replace Elements in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/replace-elements-in-an-array/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int[] op : operations) {
            max = Math.max(op[0], max);
            max = Math.max(op[1], max);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = i;
        }
        for (int[] op : operations) {
            int idx = arr[op[0]];
            nums[idx] = op[1];
            arr[op[1]] = idx;
        }
        return nums;
    }
}
