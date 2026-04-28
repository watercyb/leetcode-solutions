/*
 * Problem: 2539. Count the Number of Good Subsequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-good-subsequences/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int countGoodSubsequences(String s) {
        int mod = 1_000_000_007;
        int[] counts = new int['z' + 1];
        int count = 0;
        for (char chr : s.toCharArray()) {
            if (counts[chr]++ == 0)
                count++;
        }
        int[] arr = new int[count];
        int idx = 0;
        int max = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > 0) {
                arr[idx++] = counts[i];
                max = Math.max(counts[i], max);
            }
        }
        long[] invs = new long[max + 1];
        long[] facters = new long[arr.length];
        Arrays.fill(facters, 1);
        invs[1] = 1;
        long res = 0;
        for (int i = 1; i <= max; i++) {
            if (i > 1)
                invs[i] = mod - (mod / i * invs[mod % i]) % mod;
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < i)
                    continue;
                facters[j] = facters[j] * (arr[j] - i + 1) % mod * invs[i] % mod;
                sum = (sum * facters[j] + facters[j] + sum) % mod;
            }
            res = (res + sum) % mod;
        }
        return (int) res;
    }
}
