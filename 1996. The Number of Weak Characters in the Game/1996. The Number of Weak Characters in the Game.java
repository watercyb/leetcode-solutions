/*
 * Problem: 1996. The Number of Weak Characters in the Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int max = 0;
        for (int[] property : properties) {
            max = Math.max(property[0], max);
        }
        int[] atts = new int[max + 2];
        for (int[] property : properties) {
            atts[property[0]] = Math.max(property[1], atts[property[0]]);
        }
        for (int i = max; i >= 0; i--) {
            atts[i] = Math.max(atts[i + 1], atts[i]);
        }
        int res = 0;
        for (int[] property : properties) {
            if (atts[property[0] + 1] > property[1])
                res++;
        }
        return res;
    }
}
