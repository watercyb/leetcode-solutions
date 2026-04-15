/*
 * Problem: 1299. Replace Elements with Greatest Element on Right Side
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }
}
