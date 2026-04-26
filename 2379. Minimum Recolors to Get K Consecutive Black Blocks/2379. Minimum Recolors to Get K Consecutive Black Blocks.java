/*
 * Problem: 2379. Minimum Recolors to Get K Consecutive Black Blocks
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] chrs = blocks.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += chrs[i] - 'B';
        }
        int res = count;
        for (int i = k; i < chrs.length; i++) {
            count += chrs[i] - chrs[i - k];
            res = Math.min(count, res);
        }
        return res / ('W' - 'B');
    }
}
