/*
 * Problem: 1557. Minimum Number of Vertices to Reach All Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] seens = new boolean[n];
        for (List<Integer> edge : edges) {
            seens[edge.get(1)] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!seens[i])
                res.add(i);
        }
        return res;
    }
}
