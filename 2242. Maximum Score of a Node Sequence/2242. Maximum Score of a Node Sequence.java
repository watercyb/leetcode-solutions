/*
 * Problem: 2242. Maximum Score of a Node Sequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-of-a-node-sequence/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int[][] links = new int[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            Arrays.fill(links[i], -1);
        }
        for (int[] edge : edges) {
            insert(links[edge[0]], scores, edge[1]);
            insert(links[edge[1]], scores, edge[0]);
        }
        int res = -1;
        for (int[] edge : edges) {
            int sum = scores[edge[0]] + scores[edge[1]];
            int used = 0;
            for (int i = 0; i < 3 && links[edge[0]][i] != -1; i++) {
                if (links[edge[0]][i] == edge[1])
                    continue;
                for (int j = 0; j < 3 && links[edge[1]][j] != -1; j++) {
                    if (links[edge[1]][j] != edge[0] && links[edge[1]][j] != links[edge[0]][i]) {
                        res = Math.max(sum + scores[links[edge[0]][i]] + scores[links[edge[1]][j]], res);
                        used++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public void insert(int[] links, int[] scores, int i) {
        if (links[2] != -1 && scores[links[2]] >= scores[i])
            return;
        int j = 1;
        while (j >= 0 && (links[j] == -1 || scores[links[j]] < scores[i])) {
            links[j + 1] = links[j];
            j--;
        }
        links[++j] = i;
    }
}
