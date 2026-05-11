/*
 * Problem: 3819. Rotate Non Negative Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotate-non-negative-elements/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int[] rotateElements(int[] nums, int k) {
        if (k == 0)
            return nums;
        int count = 0;
        for (int num : nums) {
            if (num >= 0)
                count++;
        }
        if (count == 0 || k % count == 0)
            return nums;
        int[] arr = new int[count];
        int idx = count - k % count;
        for (int num : nums) {
            if (num >= 0) {
                arr[idx] = num;
                if (++idx == arr.length)
                    idx = 0;
            }
        }
        idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = arr[idx++];
            }
        }
        return nums;
    }
}
