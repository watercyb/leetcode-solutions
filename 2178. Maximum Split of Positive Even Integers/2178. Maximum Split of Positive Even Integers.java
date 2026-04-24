/*
 * Problem: 2178. Maximum Split of Positive Even Integers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-split-of-positive-even-integers/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 1)
            return res;
        long base = 2;
        while (finalSum >= base) {
            res.add(base);
            finalSum -= base;
            base += 2;
        }
        if (finalSum != 0) {
            res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        }
        return res;
    }
}
