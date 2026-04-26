/*
 * Problem: 2400. Number of Ways to Reach a Position After Exactly k Steps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int mod = 1_000_000_007;
        int diff = Math.abs(endPos - startPos);
        if (diff > k || (k - diff) % 2 == 1)
            return 0;
        long res = 1;
        for (int i = k; i > (k + diff) / 2; i--) {
            res = (res * i) % mod;
        }
        for (int i = 1; i <= (k - diff) / 2; i++) {
            res = (res * modInverse(i, mod)) % mod;
        }
        // k!/(k+diff)/2!/(k-diff)/2!
        return (int) (res % mod);
    }

    static int modInverse(int A, int M)
    {
        int m0 = M;
        int y = 0, x = 1;
 
        if (M == 1)
            return 0;
 
        while (A > 1) {
            // q is quotient
            int q = A / M;
 
            int t = M;
 
            // m is remainder now, process
            // same as Euclid's algo
            M = A % M;
            A = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }
}
