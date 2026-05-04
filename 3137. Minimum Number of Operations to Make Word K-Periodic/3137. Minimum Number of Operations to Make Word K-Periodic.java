/*
 * Problem: 3137. Minimum Number of Operations to Make Word K-Periodic
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int max = 0;
        HashMap<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < word.length(); i += k) {
            String str = word.substring(i, i + k);
            int count = HM.getOrDefault(str, 0) + 1;
            HM.put(str, count);
            max = Math.max(count, max);
        }
        return word.length() / k - max;
    }
}
