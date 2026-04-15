/*
 * Problem: 1287. Element Appearing More Than 25% In Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int findSpecialInteger(int[] arr) {
        int dist = arr.length / 4;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==arr[i+dist])
                return arr[i];
        }
        return -1;
    }
}
