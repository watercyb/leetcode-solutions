/*
 * Problem: 1122. Relative Sort Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/relative-sort-array/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }

        int[] res = new int[arr1.length];
        int idx = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                res[idx++] = num;
                counts[num]--;
            }
        }
         for (int i=0;i<=1000;i++) {
            while (counts[i] > 0) {
                res[idx++] = i;
                counts[i]--;
            }
        }
        return res;
    }
}
