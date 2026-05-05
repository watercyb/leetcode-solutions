/*
 * Problem: 3272. Find the Count of Good Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-count-of-good-integers/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long countGoodIntegers(int n, int k) {
        return dfs(new int[10], 0, 0, 0, n - 1, n, k);
    }

    HashSet<Long> HS = new HashSet<>();
    long[] bases10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
    long[] bases11 = { 0, 11, 121, 1331, 14641, 161051, 1771561, 19487171, 214358881, 2357947691l };

    public long dfs(int[] counts, long num, long h, int l, int r, int n, int k) {
        if (l > r) {
            if (num % k == 0 && HS.add(h))
                return chk(counts, n);
            return 0;
        }
        long res = 0;
        for (int i = l == 0 ? 1 : 0; i <= 9; i++) {
            if (l != r) {
                counts[i] += 2;
                res += dfs(counts, num + (bases10[l] + bases10[r]) * i,
                        h + bases11[i] * 2, l + 1, r - 1, n, k);
                counts[i] -= 2;
            } else {
                counts[i]++;
                res += dfs(counts, num + bases10[l] * i,
                        h + bases11[i], l + 1, r - 1, n, k);
                counts[i]--;
            }
        }
        return res;
    }

    public long chk(int[] counts, int n) {
        long res = 1;
        int count = n;
        for (int i = 0; i <= 9; i++) {
            res *= C(count, counts[i]);
            count -= counts[i];
        }
        if (counts[0] != 0) {
            long offset = C(n - 1, counts[0] - 1);
            count = n - counts[0];
            for (int i = 1; i <= 9; i++) {
                offset *= C(count, counts[i]);
                count -= counts[i];
            }
            res -= offset;
        }
        return res;
    }

    public long C(int a, int b) {
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a / i;
            a--;
        }
        return res;
    }
}
