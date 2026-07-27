/*
 * Problem: 4002. Count Valid Sequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-valid-sequences/
 * Language: csharp
 * Date: 2026-07-27
 */

public class Solution {
    static long[] F;
    static long[] RF;
    static long[] Inv;
    static int mod=1_000_000_007;

    public static void getF() {
        F = new long[500001];
        RF = new long[500001];
        Inv = new long[500001];
        F[0] = 1;
        RF[0] = 1;
        Inv[0] = 1;
        F[1] = 1;
        RF[1] = 1;
        Inv[1] = 1;
        for (int i = 2; i < 500001; i++) {
            F[i] = F[i - 1] * i % mod;
            Inv[i] = mod - mod / i * Inv[mod % i] % mod;
            RF[i] = RF[i - 1] * Inv[i] % mod;
        }
    }

    public int CountValidSequences(int n, int k) {
        if (F==null) getF();
        if ((n+k)%2==1)
            return (int)C(n-1,k-1);
        return (int)(C(n-1,k-1)-C((n-k)/2+k-1,k-1)+mod)%mod;
    }

    public long C(int a, int b) {
        if (a<b) return 0;
        return F[a]*RF[a-b]%mod*RF[b]%mod;
    }
}
