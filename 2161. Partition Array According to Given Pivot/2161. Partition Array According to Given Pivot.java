/*
 * Problem: 2161. Partition Array According to Given Pivot
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-according-to-given-pivot/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        int idx = 0;
        int j = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, j);
                j++;
            } else if (nums[i] > pivot) {
                arr[idx++] = nums[i];
            } else {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            nums[j++] = pivot;
        }
        for (int i = 0; i < idx; i++) {
            nums[j++] = arr[i];
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
