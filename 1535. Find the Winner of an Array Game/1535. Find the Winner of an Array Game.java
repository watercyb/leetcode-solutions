/*
 * Problem: 1535. Find the Winner of an Array Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-winner-of-an-array-game/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int getWinner(int[] arr, int k) {
        int winner=arr[0];
        int count=0;
        for (int i=1;i<arr.length;i++) {
            if (winner>arr[i]) {
                count++;
            } else {
                winner=arr[i];
                count=1;
            }
            if (count==k) break;
        }
        return winner;
    }
}
