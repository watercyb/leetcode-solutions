/*
 * Problem: 3756. Concatenate Non-Zero Digits and Multiply by Sum II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = 1_000_000_007;
        char[] chrs = s.toCharArray();
        int[] indexLefts = new int[chrs.length];
        int[] indexRights = new int[chrs.length];
        long[] nums = new long[chrs.length + 2];
        int[] sums = new int[chrs.length + 2];
        long[] pows = new long[chrs.length + 1];
        pows[0] = 1;
        long num = 0;
        int sum = 0;
        int idx = 1;
        for (int i = 0; i < chrs.length; i++) {
            int digit = chrs[i] - '0';
            if (digit == 0) {
                indexLefts[i] = idx;
                indexRights[i] = idx - 1;
            } else {
                num = (num * 10 + digit) % mod;
                sum += digit;
                indexLefts[i] = idx;
                indexRights[i] = idx;
                nums[idx] = num;
                sums[idx] = sum;
                idx++;
            }
            pows[i + 1] = pows[i] * 10 % mod;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = indexLefts[queries[i][0]];
            int r = indexRights[queries[i][1]];
            num = ((nums[r] - nums[l - 1] * pows[r - l + 1]) % mod + mod) % mod;
            sum = sums[r] - sums[l - 1];
            res[i] = (int) (num * sum % mod);
        }
        return res;
    }
}
