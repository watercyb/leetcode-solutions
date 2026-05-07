/*
 * Problem: 3424. Minimum Cost to Make Arrays Identical
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += Math.abs(arr[i] - brr[i]);
        }
        if (sum1 <= k)
            return sum1;
        Arrays.sort(arr);
        Arrays.sort(brr);
        long sum2 = k;
        for (int i = 0; i < arr.length; i++) {
            sum2 += Math.abs(arr[i] - brr[i]);
        }
        return Math.min(sum1, sum2);
    }
}
