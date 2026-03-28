/*
 * Problem: 245. Shortest Word Distance III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-word-distance-iii/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (word1.equals(word2)) {
            int idx = Integer.MIN_VALUE / 2;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    res = Math.min(i - idx, res);
                    idx = i;
                }
            }
            return res;
        }
        int idx1 = Integer.MIN_VALUE / 2;
        int idx2 = Integer.MIN_VALUE / 2;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
                res = Math.min(idx1 - idx2, res);
            } else if (wordsDict[i].equals(word2)) {
                idx2 = i;
                res = Math.min(idx2 - idx1, res);
            }
        }
        return res;
    }
}
