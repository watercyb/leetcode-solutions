/*
 * Problem: 2842. Count K-Subsequences of a String With Maximum Beauty
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-k-subsequences-of-a-string-with-maximum-beauty/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        if (k > 26)
            return 0;
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        for (char chr : chrs) {
            counts[chr - 'a']++;
        }
        Arrays.sort(counts);
        if (counts[26 - k] == 0)
            return 0;
        long res = 1;
        int a = 0;
        for (int i = 25; i >= 26 - k; i--) {
            if (counts[i] == counts[26 - k])
                a++;
            res = res * counts[i] % mod;
        }
        int b = 0;
        for (int i = 0; i < 26 - k; i++) {
            if (counts[i] == counts[26 - k])
                b++;
        }
        res = res * C(a + b, a) % mod;
        return (int) res;
    }

    int mod = 1_000_000_007;

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        long div = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a % mod;
            div = div * i % mod;
            a--;
        }
        return res * rev(div) % mod;
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
