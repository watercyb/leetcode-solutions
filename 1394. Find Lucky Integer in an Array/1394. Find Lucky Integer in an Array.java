/*
 * Problem: 1394. Find Lucky Integer in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-lucky-integer-in-an-array/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int findLucky(int[] arr) {
        int[] counts = new int[501];
        for (int num : arr) {
            counts[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (counts[i] == i)
                return i;
        }
        return -1;
    }
}
