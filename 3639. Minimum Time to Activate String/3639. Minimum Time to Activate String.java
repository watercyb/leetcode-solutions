/*
 * Problem: 3639. Minimum Time to Activate String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-activate-string/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        long sum = (long) n * (n + 1) / 2;
        if (k > sum)
            return -1;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        for (int i = 0; i < n; i++) {
            lefts[i] = i - 1;
            rights[i] = i + 1;
        }
        for (int i = order.length - 1; i >= 0; i--) {
            int idx = order[i];
            int l = lefts[idx];
            int r = rights[idx];
            sum -= (long) (idx - r) * (l - idx);
            if (sum < k)
                return i;
            if (l >= 0)
                rights[l] = r;
            if (r < n)
                lefts[r] = l;
        }
        return -1;
    }
}
