/*
 * Problem: 3250. Find the Count of Monotonic Pairs I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-count-of-monotonic-pairs-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int countOfPairs(int[] nums) {
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.max(nums[i] - nums[i - 1], 0);
            offset += diff;
            if (nums[i] - offset < 0)
                return 0;
        }
        int x = nums.length;
        int y = nums[nums.length - 1] - offset;
        return (int) c(x + y, y);
    }

    long mod = 1_000_000_007;

    public long c(int m, int n) {
        if (2 * n > m)
            n = m - n;
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * (m - i + 1) % mod * reverse(i)) % mod;
        }
        return res;
    }

    public long reverse(long a) {
        if (a == 1)
            return a;
        return mod - (mod / a) * reverse(mod % a) % mod;
    }
}
