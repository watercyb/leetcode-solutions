/*
 * Problem: 88. Merge Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-sorted-array/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int idx = nums1.length - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
    }
}
