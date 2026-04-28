/*
 * Problem: 2572. Count the Number of Square-Free Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-square-free-subsets/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int squareFreeSubsets(int[] nums) {
        getPrimes();
        Arrays.fill(hList, -2);
        int[] counts = new int[31];
        for (int num : nums) {
            counts[num]++;
        }
        long[] DP = new long[1 << 10];
        DP[0] = pow(counts[1]) - 1;
        for (int i = 2; i <= 30; i++) {
            if (counts[i] == 0)
                continue;
            int h = getH(i);
            if (h == -1)
                continue;
            for (int j = DP.length - 1; j >= 1; j--) {
                if ((j & h) != 0)
                    continue;
                int idx = j | h;
                DP[idx] = (DP[idx] + DP[j] * counts[i]) % mod;
            }
            DP[h] = DP[h] + counts[i] * (DP[0] + 1) % mod;
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            res = (res + DP[i]) % mod;
        }
        return (int) res;
    }

    int mod = 1_000_000_007;
    static int[] hList = new int[31];
    static int[] primes;

    public long pow(int n) {
        long res = 1;
        long base = 2;
        while (n > 0) {
            if (n % 2 == 1)
                res = res * base % mod;
            base = base * base % mod;
            n /= 2;
        }
        return res;
    }

    public int getH(int num) {
        if (hList[num] != -2)
            return hList[num];
        int currentNum = num;
        int res = 0;
        for (int i = 0; i < primes.length; i++) {
            int p = primes[i];
            if (num % p == 0) {
                if (num / p % p == 0)
                    return hList[currentNum] = -1;
                res += 1 << i;
                num /= p;
            }
        }
        return hList[currentNum] = res;
    }

    public void getPrimes() {
        if (primes != null)
            return;
        boolean[] nonPrimes = new boolean[16];
        int count = 0;
        for (int i = 2; i <= 15; i++) {
            if (nonPrimes[i])
                continue;
            count++;
            for (int j = i + i; j <= 15; j += i) {
                nonPrimes[j] = true;
            }
        }
        primes = new int[count];
        int idx = 0;
        for (int i = 2; i <= 15; i++) {
            if (!nonPrimes[i])
                primes[idx++] = i;
        }
    }
}
