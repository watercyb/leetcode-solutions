/*
 * Problem: 2719. Count of Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-of-integers/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        char[] chrs1 = num1.toCharArray();
        char[] chrs2 = num2.toCharArray();
        int idx = chrs1.length - 1;
        while (chrs1[idx] == '0') {
            idx--;
        }
        if (idx == 0 && chrs1[0] == '1') {
            chrs1 = new char[chrs1.length - 1];
            Arrays.fill(chrs1, '9');
        } else {
            chrs1[idx]--;
            for (int i = idx + 1; i < chrs1.length; i++) {
                chrs1[i] = '9';
            }
        }
        return (int) ((getCount(chrs2, min_sum, max_sum) - getCount(chrs1, min_sum, max_sum)) % mod + mod) % mod;
    }

    int mod = 1_000_000_007;

    public long getCount(char[] chrs, int l, int r) {
        long[] DP = new long[r + 1];
        int count = 0;
        for (int i = 0; i < chrs.length; i++) {
            long[] DPNext = new long[r + 1];
            int digit = chrs[i] - '0';
            long sum = 0;
            for (int j = 0; j <= r; j++) {
                sum = (DP[j] + sum) % mod;
                DPNext[j] = sum;
                if (j >= 9)
                    sum = sum - DP[j - 9] + mod;
            }
            for (int j = 0; j < digit && j + count <= r; j++) {
                DPNext[j + count]++;
            }
            DP = DPNext;
            DP[0] = 1;
            count += digit;
        }
        long res = count <= r && count >= l ? 1 : 0;
        for (int i = l; i <= r; i++) {
            res += DP[i];
        }
        return res % mod;
    }
}
