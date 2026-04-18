/*
 * Problem: 1566. Detect Pattern of Length M Repeated K or More Times
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; i++) {
            int idx = i;
            int n = k;
            for (int j = i + m; j < arr.length; j++) {
                if (arr[j] == arr[idx]) {
                    if (++idx == i + m) {
                        idx = i;
                        if (--n == 1)
                            return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
