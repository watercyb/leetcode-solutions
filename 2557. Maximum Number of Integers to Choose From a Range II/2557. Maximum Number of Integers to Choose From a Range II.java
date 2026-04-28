/*
 * Problem: 2557. Maximum Number of Integers to Choose From a Range II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-ii/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int maxCount(int[] banned, int n, long maxSum) {
        Arrays.sort(banned);
        long prv = 1;
        int res = 0;
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] > n)
                banned[i] = n + 1;
            if (banned[i] <= prv) {
                prv = banned[i] + 1;
            } else {
                long sum = (prv + banned[i] - 1) * (banned[i] - prv) / 2;
                if (sum <= maxSum) {
                    maxSum -= sum;
                    res += banned[i] - prv;
                    prv = banned[i] + 1;
                } else {
                    int x = (int) ((Math.sqrt(4 * prv * prv - 4 * prv + 8 * maxSum + 1) - 1) / 2);
                    maxSum -= (prv + x) * (x - prv - 1) / 2;
                    res += x - prv + 1;
                    return res;
                }
            }
            if (prv > maxSum || prv > n)
                return res;
        }
        int last = banned[banned.length - 1] + 1;
        res += Math.min((int) ((Math.sqrt(4 * last * last - 4 * last + 8 * maxSum + 1) - 1) / 2), n) - last + 1;
        return res;
    }
}
