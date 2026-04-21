/*
 * Problem: 1846. Maximum Element After Decreasing and Rearranging
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] counts = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length) {
                counts[arr.length]++;
            } else {
                counts[arr[i]]++;
            }
        }
        int max = 1;
        int j = 0;
        for (int i=0;i<arr.length;i++) {
            while (j < max || counts[j] == 0) {
                j++;
                if (j > arr.length)
                    return max - 1;
            }
            max++;
            counts[j]--;
        }
        return max - 1;
    }
}
