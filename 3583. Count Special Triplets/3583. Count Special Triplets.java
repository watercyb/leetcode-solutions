/*
 * Problem: 3583. Count Special Triplets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-special-triplets/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        long res = 0;
        long[] counts1 = new long[max + 1];
        long[] counts2 = new long[max + 1];
        for (int num : nums) {
            if ((num & 1) == 0)
                res = (res + counts2[num / 2]) % mod;
            if (num * 2 < counts1.length)
                counts2[num] = (counts2[num] + counts1[num * 2]) % mod;
            counts1[num]++;
        }
        return (int) res;
    }
}
