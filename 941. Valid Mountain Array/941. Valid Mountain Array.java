/*
 * Problem: 941. Valid Mountain Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-mountain-array/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        int idx = 0;
        while (idx < arr.length - 1 && arr[idx] < arr[idx + 1]) {
            idx++;
        }
        if (idx == 0 || idx == arr.length - 1)
            return false;
        while (idx < arr.length - 1 && arr[idx] > arr[idx + 1]) {
            idx++;
        }
        return idx == arr.length - 1;
    }
}
