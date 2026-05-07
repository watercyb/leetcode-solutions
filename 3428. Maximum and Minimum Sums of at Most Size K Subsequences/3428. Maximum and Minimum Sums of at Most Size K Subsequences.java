/*
 * Problem: 3428. Maximum and Minimum Sums of at Most Size K Subsequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {

    static long[] rev = new long[89];
    int mod = 1_000_000_007;

    public int minMaxSums(int[] nums, int k) {
        if (rev[1] == 0) {
            long a = 1;
            for (int i = 1; i <= 88; i++) {
                rev[i] = reverse(a);
                a = a * i % mod;
            }
        }
        Arrays.sort(nums);
        long res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < nums.length) {
            int size = nums.length - l;
            int lim = Math.min(size, k);
            int num = nums[l] + nums[r];
            long a = 1;
            for (int i = 1; i <= lim; i++) {
                res = (res + a * rev[i] % mod * num) % mod;
                a = a * (size - i) % mod;
            }
            l++;
            r--;
        }
        return (int) (res % mod);
    }

    public long reverse(long a) {
        if (a == 1)
            return a;
        return (mod - (mod / a * reverse(mod % a))) % mod + mod;
    }
}
