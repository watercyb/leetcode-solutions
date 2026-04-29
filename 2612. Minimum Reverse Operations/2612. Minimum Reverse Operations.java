/*
 * Problem: 2612. Minimum Reverse Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-reverse-operations/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        boolean[] bans = new boolean[n];
        for (int idx : banned) {
            bans[idx] = true;
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[p] = 0;
        int[] Qu = new int[n];
        Qu[0] = p;
        int left = 0;
        int right = 1;
        int k1 = k - 1;
        int k2 = 2 * n - 1 - k;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = i + 2;
        }
        while (left < right) {
            int current = Qu[left++];
            int stp = res[current] + 1;
            int l = Math.max(k1 - current, current - k1);
            int r = Math.min(k2 - current, current + k1);
            int idx = l;
            while (idx <= r) {
                if (res[idx] == -1 && !bans[idx]) {
                    res[idx] = stp;
                    Qu[right++] = idx;
                }
                int nextIdx = next[idx];
                next[idx] = Math.max(r, next[idx]);
                idx = nextIdx;
            }
        }
        return res;
    }
}
