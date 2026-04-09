/*
 * Problem: 878. Nth Magical Number
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/nth-magical-number/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int[] inp=inl(a, b);
        long l = inp[0];
        long r = (long) n * inp[0];
        while (l < r) {
            long mid = (r - l) / 2 + l;
            if (chk(n, inp[0], inp[1], inp[2], mid)) {
                r = mid;

            } else {

                l = mid + 1;
            }
        }
        return (int) (l % 1000000007);

    }

    public boolean chk(int n, int a, int b, int c, long mid) {
        if (a == b)
            return mid / a >= n;
        return mid / a + mid / b - mid / c >= n;
    }

    public int[] inl(int a, int b) {
        int[] res;
        if (a > b) {
            res=new int[] {b,a,a*b};
        } else {
            res=new int[] {a,b,a*b};
        }
        while(a != 0) {
            int rem = b%a;
            b = a;
            a = rem;
        }
        res[2]/=b;   
        return res;
    }
}
