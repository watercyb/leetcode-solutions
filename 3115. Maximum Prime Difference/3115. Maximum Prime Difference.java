/*
 * Problem: 3115. Maximum Prime Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-prime-difference/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] nonPrimes = new boolean[101];
        nonPrimes[0] = nonPrimes[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(100); i++) {
            if (!nonPrimes[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    nonPrimes[j] = true;
                }
            }
        }
        int l = 0;
        while (nonPrimes[nums[l]]) {
            l++;
        }
        int r = nums.length - 1;
        while (nonPrimes[nums[r]]) {
            r--;
        }
        return r - l;
    }
}
