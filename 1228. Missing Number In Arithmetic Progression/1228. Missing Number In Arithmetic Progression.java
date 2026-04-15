/*
 * Problem: 1228. Missing Number In Arithmetic Progression
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/missing-number-in-arithmetic-progression/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int missingNumber(int[] arr) {
        int l = 1;
        int r = arr.length - 1;
        int n = (arr[arr.length - 1] - arr[0]) / arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (Math.abs(arr[mid] - arr[0]) > Math.abs(mid * n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] - n;
    }
}
