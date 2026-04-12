/*
 * Problem: 1089. Duplicate Zeros
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/duplicate-zeros/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num == 0)
                count++;
        }
        int idx = arr.length - 1;
        while (idx >= arr.length - count) {
            if (arr[idx] == 0)
                count--;
            idx--;
        }
        if (count == 0)
            return;
        if (idx + count < arr.length - 1)
            arr[arr.length - 1] = 0;
        for (int i = idx; count > 0; i--) {
            arr[i + count] = arr[i];
            if (arr[i] == 0) {
                arr[i + (--count)] = 0;
            }
        }
    }
}
