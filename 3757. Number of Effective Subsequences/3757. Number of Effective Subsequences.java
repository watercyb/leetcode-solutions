/*
 * Problem: 3757. Number of Effective Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-effective-subsequences/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int countEffective(int[] nums) {
        int mod = 1_000_000_007;
        int or = 0;
        for (int num : nums) {
            or |= num;
        }
        int len = Integer.bitCount(or);
        int[] counts = new int[1 << len];
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            int idx = 0;
            for (int j = 1; j <= nums[i]; j <<= 1) {
                if ((or & j) != 0) {
                    if ((nums[i] & j) != 0)
                        num += 1 << idx;
                    idx++;
                }
            }
            counts[num]++;
        }
        for (int i = 0; i < len; i++) {
            int mask = 1 << i;
            for (int j = 1; j < counts.length; j++) {
                if ((j & mask) != 0) {
                    counts[j] += counts[j - mask];
                }
            }
        }
        long[] pows = new long[nums.length + 1];
        pows[0] = 1;
        for (int i = 1; i < pows.length; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        int mask = (1 << len) - 1;
        long res = 0;
        for (int i = 1; i < counts.length; i++) {
            int count = counts[i ^ mask];
            if (Integer.bitCount(i) % 2 == 1) {
                res += pows[count];
            } else {
                res -= pows[count];
            }
        }
        return (int) ((res % mod + mod) % mod);
    }
}
