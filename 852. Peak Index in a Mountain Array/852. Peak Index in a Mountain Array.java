/*
 * Problem: 852. Peak Index in a Mountain Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-2;
        while (left!=right) {
            int tmp=(right-left)/2+left;
            if (arr[tmp]>arr[tmp+1]) {
                right=tmp;
            } else {
                left=tmp+1;
            }
        }
        return right;
    }
}
