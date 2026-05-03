/*
 * Problem: 3016. Minimum Number of Pushes to Type Word II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumPushes(String word) {
        int[] counts = new int[26];
        int max = 0;
        for (char chr : word.toCharArray()) {
            counts[chr - 'a']++;
            max = Math.max(counts[chr - 'a'], max);
        }
        int[] countCounts = new int[max + 1];
        for (int count : counts) {
            countCounts[count]++;
        }
        int idx = 0;
        int rank = 1;
        int res = 0;
        for (int i = max; i >= 1; i--) {
            for (int j = 0; j < countCounts[i]; j++) {
                res += i * rank;
                if (idx++ == 7) {
                    rank++;
                    idx = 0;
                }
            }
        }
        return res;
    }
}
