/*
 * Problem: 2338. Count the Number of Ideal Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-ideal-arrays/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    int mod = 1_000_000_007;
    long[] meme = new long[15];

    public int idealArrays(int n, int maxValue) {
        int[] minDivs = new int[maxValue + 1];
        for (int i = 2; i <= maxValue; i++) {
            if (minDivs[i] == 0) {
                minDivs[i] = i;
                for (int j = 2 * i; j <= maxValue; j += i) {
                    if (minDivs[j] == 0)
                        minDivs[j] = i;
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= maxValue; i++) {
            int num = i;
            long p = 1;
            while (num > 1) {
                int div = minDivs[num];
                int count = 0;
                while (num % div == 0) {
                    count++;
                    num /= div;
                }
                if (meme[count] != 0) {
                    p = p * meme[count] % mod;
                } else {
                    long sum = C(n + count - 1, n - 1);
                    meme[count] = sum;
                    p = p * sum % mod;
                }
            }
            res = (res + p) % mod;
        }
        return (int) res;
    }

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        long div = 1;
        int a1 = a;
        for (int i = 1; i <= b; i++) {
            res = res * a1 % mod;
            div = div * i % mod;
            a1--;
        }
        res = res * rev(div) % mod;
        return res;
    }

    public long rev(long num) {
        if (num == 1)
            return num;
        return mod - mod / num * rev(mod % num) % mod;
    }
}
