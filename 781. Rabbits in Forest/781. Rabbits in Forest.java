/*
 * Problem: 781. Rabbits in Forest
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rabbits-in-forest/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int numRabbits(int[] answers) {
        int[] counts = new int[1001];
        int res = 0;
        for (int answer : answers) {
            if (counts[answer] == 0) {
                counts[answer] = answer;
                res += answer + 1;
            } else {
                counts[answer]--;
            }
        }
        return res;
    }
}
