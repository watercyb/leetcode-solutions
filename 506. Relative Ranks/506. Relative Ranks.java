/*
 * Problem: 506. Relative Ranks
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/relative-ranks/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for (int i = 0; i < score.length; i++) {
            PQ.offer(i);
        }
        String[] res = new String[score.length];
        res[PQ.poll()] = "Gold Medal";
        if (!PQ.isEmpty())
            res[PQ.poll()] = "Silver Medal";
        if (!PQ.isEmpty())
            res[PQ.poll()] = "Bronze Medal";
        for (int i = 4; i <= score.length; i++) {
            res[PQ.poll()] = String.valueOf(i);
        }
        return res;
    }
}
