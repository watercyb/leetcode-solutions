/*
 * Problem: 4039. Sum of Decoded Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-decoded-numbers/
 * Language: csharp
 * Date: 2026-09-01
 */

public class Solution {
    public int SumDecoded(long[] nums) {
        int res=0;
        foreach (long num in nums) {
            long n=num;
            long len=-1;
            while (n>0) {
                n/=10;
                len++;
            }
            n=num;
            long w=n%10;
            n/=10;
            long b=0;
            long d=1;
            while (len>w) {
                b+=n%10*d;
                n/=10;
                d*=10;
                len--;
            }
            long a=0;
            d=1;
            while (len>0) {
                a+=n%10*d;
                n/=10;
                d*=10;
                len--;
            }
            res=(res+pow(a,b))%mod;
        }
        return res;
    }

    int mod=1_000_000_007;

    public int pow(long a, long b) {
        long res=1;
        long d=a;
        while (b>0) {
            if ((b&1)==1) res=res*d%mod;
            d=d*d%mod;
            b>>=1;
        }
        return (int)(res%mod);
    }
}
