/*
 * Problem: 2410. Maximum Matching of Players With Trainers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int j = 0;
        int res = 0;
        for (int player : players) {
            while (j < trainers.length && trainers[j] < player) {
                j++;
            }
            if (j == trainers.length)
                break;
            j++;
            res++;
        }
        return res;
    }
}
