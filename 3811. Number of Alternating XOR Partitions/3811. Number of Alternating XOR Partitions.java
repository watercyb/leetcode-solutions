/*
 * Problem: 3811. Number of Alternating XOR Partitions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-alternating-xor-partitions/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int alternatingXOR(int[] nums, int target1, int target2) {
        int mod = 1_000_000_007;
        long[] DP = new long[4];
        DP[0] = 1;
        int xor = 0;
        int a = 0;
        int b = target1;
        int c = target1 ^ target2;
        int d = target2;
        for (int i = 0; i < nums.length - 1; i++) {
            long[] DPTemp = DP.clone();
            xor ^= nums[i];
            if (xor == a)
                DP[0] = (DP[0] + DPTemp[3]) % mod;
            if (xor == b)
                DP[1] = (DP[1] + DPTemp[0]) % mod;
            if (xor == c)
                DP[2] = (DP[2] + DPTemp[1]) % mod;
            if (xor == d)
                DP[3] = (DP[3] + DPTemp[2]) % mod;
        }
        long res = 0;
        xor ^= nums[nums.length - 1];
        if (xor == a)
            res += DP[3];
        if (xor == b)
            res += DP[0];
        if (xor == c)
            res += DP[1];
        if (xor == d)
            res += DP[2];
        return (int) (res % mod);
    }
}
