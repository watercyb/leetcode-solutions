/*
 * Problem: 1514. Path with Maximum Probability
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-with-maximum-probability/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probs = new double[n];
        probs[start_node] = 1;
        for (boolean changed = true; changed;) {
            changed = false;
            for (int i = 0; i < edges.length; i++) {
                if (probs[edges[i][0]] * succProb[i] > probs[edges[i][1]]) {
                    probs[edges[i][1]] = probs[edges[i][0]] * succProb[i];
                    changed = true;
                } else if (probs[edges[i][1]] * succProb[i] > probs[edges[i][0]]) {
                    probs[edges[i][0]] = probs[edges[i][1]] * succProb[i];
                    changed = true;
                }
            }
        }
        return probs[end_node];
    }
}
