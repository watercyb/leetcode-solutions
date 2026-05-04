/*
 * Problem: 3179. Find the N-th Value After K Seconds
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int valueAfterKSeconds(int n, int k) {
        return C(n + k - 1, k);
    }

    int mod = 1_000_000_007;

    public int C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        long div = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a % mod;
            div = div * i % mod;
            a--;
        }
        return (int) (res * rev(div) % mod);
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
