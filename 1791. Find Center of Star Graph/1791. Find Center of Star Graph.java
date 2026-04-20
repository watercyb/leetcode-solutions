/*
 * Problem: 1791. Find Center of Star Graph
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-center-of-star-graph/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }
}
