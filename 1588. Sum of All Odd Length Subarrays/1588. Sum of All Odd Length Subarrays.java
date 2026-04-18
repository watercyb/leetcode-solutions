/*
 * Problem: 1588. Sum of All Odd Length Subarrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftEven = i / 2 + 1;
            int leftOdd = i + 1 - leftEven;
            int rightEven = (arr.length - i - 1) / 2 + 1;
            int rightOdd = arr.length - i - rightEven;
            res += arr[i] * leftEven * rightEven + arr[i] * leftOdd * rightOdd;
        }
        return res;
    }
}
