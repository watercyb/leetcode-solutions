/*
 * Problem: 2225. Find Players With Zero or One Losses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
                List<Integer> Li1 = new ArrayList<>();
        List<Integer> Li2 = new ArrayList<>();
        int[] counts = new int[100001];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int[] match : matches) {
            if (counts[match[0]] == 0)
                counts[match[0]]--;
            if (counts[match[1]] == 0) {
                counts[match[1]] = -2;
            } else {
                counts[match[1]]--;
            }
            if (min>Math.min(match[0],match[1])) min=Math.min(match[0],match[1]);
            if (max<Math.max(match[0],match[1])) max=Math.max(match[0],match[1]);
        }

        for (int i = min; i <=max; i++) {
            if (counts[i] == -1) {
                Li1.add(i);
            } else if (counts[i] == -2) {
                Li2.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(Li1);
        res.add(Li2);

        return res;
        
    }
}
