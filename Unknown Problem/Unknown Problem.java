/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-value/
 * Language: java
 * Date: 2026-06-24
 */

class Solution {
    public int maxTotalValue(int[] value, int[] decay, int m) {
        long total = m;
        long sum = 0;
        int max = 0;
        for (int i = 0; i < value.length; i++) {
            int count = Math.max((value[i] + decay[i] - 1) / decay[i], 0);
            sum += (long) (value[i] - (long) decay[i] * (count - 1) + value[i]) * count / 2;
            total -= count;
            max = Math.max(max, value[i]);
        }
        if (total >= 0)
            return (int) (sum % mod);
        int l = 0;
        int r = max + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(value, decay, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return getSum(value, decay, m, l - 1);
    }

    int mod = 1_000_000_007;

    public int getSum(int[] value, int[] decay, int m, int n) {
        long sum = 0;
        for (int i = 0; i < value.length; i++) {
            int count = Math.max((value[i] - n + decay[i] - 1) / decay[i], 0);
            sum += (long) (value[i] - decay[i] * (count - 1) + value[i]) * count / 2;
            m -= count;
        }
        return (int) ((sum - (long) (-m) * n) % mod);
    }

    public boolean chk(int[] value, int[] decay, int m, int mid) {
        mid--;
        for (int i = 0; i < value.length && m > 0; i++) {
            m -= Math.max((value[i] - mid + decay[i] - 1) / decay[i], 0);
        }
        return m <= 0;
    }
}
