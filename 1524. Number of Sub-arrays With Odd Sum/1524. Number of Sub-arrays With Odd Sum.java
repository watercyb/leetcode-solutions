/*
 * Problem: 1524. Number of Sub-arrays With Odd Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        long[] sums = new long[2];
        sums[0] = 1;
        long res = 0;
        int sum = 0;
        for (int num : arr) {
            sum = (sum + num) & 1;
            res += sums[1 - sum];
            sums[sum]++;
        }
        return (int) (res % mod);
    }
}
