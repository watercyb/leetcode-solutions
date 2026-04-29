/*
 * Problem: 2698. Find the Punishment Number of an Integer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    static int[] sums;

    public int punishmentNumber(int n) {
        if (sums == null) {
            sums = new int[1001];
            for (int i = 1; i <= 1000; i++) {
                sums[i] = sums[i - 1];
                int p = i * i;
                if (chk(p, i))
                    sums[i] += p;
            }
        }
        return sums[n];
    }

    public boolean chk(int p, int target) {
        if (p < target)
            return false;
        if (p == target)
            return true;
        int base = 1;
        int num = 0;
        while (p > 0) {
            num += p % 10 * base;
            p /= 10;
            if (chk(p, target - num))
                return true;
            base *= 10;
        }
        return false;
    }
}
