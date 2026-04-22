/*
 * Problem: 1921. Eliminate Maximum Number of Monsters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] times = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            int time = dist[i] / speed[i];
            if (dist[i] % speed[i] > 0)
                time++;
            if (time < dist.length)
                times[time]++;
        }
        int monsters = 0;
        for (int i = 1; i < dist.length; i++) {
            monsters += times[i];
            if (monsters > i)
                return i;
        }
        return dist.length;
    }
}
