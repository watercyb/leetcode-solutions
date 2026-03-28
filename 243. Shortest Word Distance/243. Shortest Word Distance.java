/*
 * Problem: 243. Shortest Word Distance
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shortest-word-distance/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = Integer.MIN_VALUE / 2;
        int idx2 = Integer.MIN_VALUE / 2;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
                res = Math.min(i - idx2, res);
            } else if (wordsDict[i].equals(word2)) {
                idx2 = i;
                res = Math.min(i - idx1, res);
            }
        }
        return res;
    }
}
