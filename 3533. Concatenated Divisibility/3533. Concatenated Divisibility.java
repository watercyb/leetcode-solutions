/*
 * Problem: 3533. Concatenated Divisibility
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/concatenated-divisibility/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] concatenatedDivisibility(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        Long[][] DP = new Long[1 << n][k];
        int[] lens = new int[DP.length];
        int[] numLens = new int[n];
        for (int i = 0; i < n; i++) {
            numLens[i] = String.valueOf(nums[i]).length();
        }
        for (int i = 1; i < DP.length; i++) {
            int num = i;
            int base = 0;
            int len = 0;
            while (num > 0) {
                if ((num & 1) == 1)
                    len += numLens[base];
                num >>= 1;
                base++;
            }
            lens[i] = pow(len, k);
        }
        for (int i = 0; i < n; i++) {
            DP[1 << i][nums[i] % k] = (long) i;
        }
        long h = dfs(nums, lens, DP, (1 << n) - 1, 0, n, k);
        if (h == -1)
            return new int[0];
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[(int) (h % n)];
            h /= n;
        }
        return res;
    }

    public long dfs(int[] nums, int[] lens, Long[][] DP, int mask, int mod, int n, int k) {
        if (DP[mask][mod] != null)
            return DP[mask][mod];
        for (int i = 0; i < n; i++) {
            int base = 1 << i;
            if ((mask & base) != 0) {
                int modNext = (mod - nums[i] * lens[mask - base] % k + k) % k;
                long res = dfs(nums, lens, DP, mask - base, modNext, n, k);
                if (res != -1)
                    return DP[mask][mod] = DP[mask - base][modNext] * n + i;
            }
        }
        return DP[mask][mod] = -1l;
    }

    public int pow(int len, int k) {
        int base = 10;
        int res = 1;
        while (len > 0) {
            if (len % 2 == 1)
                res = res * base % k;
            base = base * base % k;
            len /= 2;
        }
        return res;
    }
}
