/*
 * Problem: 1304. Find N Unique Integers Sum up to Zero
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int r = n / 2;
        int l = r - 1;
        if (n % 2 == 1)
            r++;
        int num = 1;
        while (r < n) {
            arr[l--] = -num;
            arr[r++] = num;
            num++;
        }
        return arr;
    }
}
