/*
 * Problem: 2221. Find Triangular Sum of an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-triangular-sum-of-an-array/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int triangularSum(int[] nums) {
        int res = 0;
        java.math.BigInteger a = java.math.BigInteger.ONE;
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            res = (res + a.mod(java.math.BigInteger.TEN).intValue() * nums[i]) % 10;
            a = a.multiply(java.math.BigInteger.valueOf(n - i)).divide(java.math.BigInteger.valueOf(i + 1));
        }
        return res;
    }
}
