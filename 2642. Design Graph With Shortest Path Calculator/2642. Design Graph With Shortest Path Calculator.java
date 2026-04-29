/*
 * Problem: 2642. Design Graph With Shortest Path Calculator
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-graph-with-shortest-path-calculator/
 * Language: java
 * Date: 2026-04-29
 */

class Graph {
    int[][] costs;

    public Graph(int n, int[][] edges) {
        costs = new int[n][n];
        for (int[] arr : costs) {
            Arrays.fill(arr, Integer.MAX_VALUE / 2);
        }
        for (int[] edge : edges) {
            costs[edge[0]][edge[1]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            costs[i][i]=0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    costs[j][k] = Math.min(costs[j][i] + costs[i][k], costs[j][k]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        if (costs[edge[0]][edge[1]] <= edge[2])  return;
        costs[edge[0]][edge[1]] = edge[2];
        for (int i = 0; i < costs.length; i++) {
            costs[i][edge[1]] = Math.min(costs[i][edge[0]] + costs[edge[0]][edge[1]], costs[i][edge[1]]);
            for (int j = 0; j < costs.length; j++) {
                costs[i][j] = Math.min(costs[i][edge[1]] + costs[edge[1]][j], costs[i][j]);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        if (costs[node1][node2]==Integer.MAX_VALUE / 2) return -1;
        return costs[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
