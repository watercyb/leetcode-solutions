/*
 * Problem: 2660. Determine the Winner of a Bowling Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum = 0;
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < player1.length; i++) {
            sum += player1[i] - player2[i];
            if (t1 > 0)
                sum += player1[i];
            if (t2 > 0)
                sum -= player2[i];
            if (player1[i] == 10) {
                t1 = 2;
            } else {
                t1--;
            }
            if (player2[i] == 10) {
                t2 = 2;
            } else {
                t2--;
            }
        }
        if (sum > 0) {
            return 1;
        } else if (sum < 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
