/*
 * Problem: 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean winnerOfGame(String colors) {
        char[] chrs = colors.toCharArray();
        int[] counts = new int[2];
        int count = 1;
        for (int i = 1; i < chrs.length; i++) {
            if (chrs[i] == chrs[i - 1]) {
                count++;
            } else {
                counts[chrs[i - 1] - 'A'] += count - 2 > 0 ? count - 2 : 0;
                count = 1;
            }
        }
        counts[chrs[chrs.length - 1] - 'A'] += count - 2 > 0 ? count - 2 : 0;
        return counts[0] > counts[1];
    }
}
