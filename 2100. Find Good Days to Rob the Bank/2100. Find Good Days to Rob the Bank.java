/*
 * Problem: 2100. Find Good Days to Rob the Bank
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-good-days-to-rob-the-bank/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 1; i < n - time; i++) {
            if (security[i] <= security[i - 1])
                prefix[i] = prefix[i - 1] + 1;
        }
        for (int i = n - 2; i >= time; i--) {
            if (security[i] <= security[i + 1])
                suffix[i] = suffix[i + 1] + 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (prefix[i] >= time && suffix[i] >= time)
                res.add(i);
        }
        return res;
    }
}
