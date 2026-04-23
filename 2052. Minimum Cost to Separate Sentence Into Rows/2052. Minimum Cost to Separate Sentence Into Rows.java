/*
 * Problem: 2052. Minimum Cost to Separate Sentence Into Rows
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-separate-sentence-into-rows/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minimumCost(String sentence, int k) {
        String[] strs = sentence.split(" ");
        int[] lens = new int[strs.length];
        int[] scores = new int[strs.length];
        int l = strs.length - 1;
        lens[l] = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int len = strs[i].length();
            int min = Integer.MAX_VALUE;
            int r = l;
            while (r < lens.length && lens[r] <= k) {
                min = Math.min(min, scores[r] + (k - lens[r]) * (k - lens[r]));
                lens[r] += len + 1;
                r++;
            }
            lens[--l] = len;
            scores[l] = min;
        }
        int res = Integer.MAX_VALUE;
        while (l < lens.length && lens[l] <= k) {
            res = Math.min(res, scores[l]);
            l++;
        }
        return res;
    }
}
