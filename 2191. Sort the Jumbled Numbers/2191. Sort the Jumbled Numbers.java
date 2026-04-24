/*
 * Problem: 2191. Sort the Jumbled Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-the-jumbled-numbers/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int mask = 1;
        int lim = (int) Math.ceil(Math.log(max) / Math.log(10));
        int[] numsTemp = new int[nums.length];
        for (int i = 0; i < lim; i++) {
            int[] counts = new int[10];
            for (int j = 0; j < nums.length; j++) {
                int digit = nums[j] / mask % 10;
                if (nums[j] >= mask || mask == 1)
                    digit = mapping[digit];
                counts[digit]++;
            }
            int sum = nums.length;
            for (int j = 9; j >= 0; j--) {
                sum -= counts[j];
                counts[j] = sum;
            }
            for (int j = 0; j < nums.length; j++) {
                int digit = nums[j] / mask % 10;
                if (nums[j] >= mask || mask == 1)
                    digit = mapping[digit];
                numsTemp[counts[digit]++] = nums[j];
            }
            for (int j = 0; j < nums.length; j++) {
                nums[j] = numsTemp[j];
            }
            mask *= 10;
        }
        return nums;
    }
}
