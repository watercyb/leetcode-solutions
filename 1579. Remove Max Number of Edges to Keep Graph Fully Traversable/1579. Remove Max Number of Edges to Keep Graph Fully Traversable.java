/*
 * Problem: 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] links = new int[n + 1];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int a = unionFind(links, edge[1]);
                int b = unionFind(links, edge[2]);
                if (a != b) {
                    count++;
                    links[b] = a;
                }
            }
        }
        if (count == n - 1)
            return edges.length - count;
        int[] linksClone = links.clone();
        int count1 = 0;
        int count2 = 0;
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                int a = unionFind(links, edge[1]);
                int b = unionFind(links, edge[2]);
                if (a != b) {
                    count1++;
                    links[b] = a;
                }
            } else if (edge[0] == 2) {
                int a = unionFind(linksClone, edge[1]);
                int b = unionFind(linksClone, edge[2]);
                if (a != b) {
                    count2++;
                    linksClone[b] = a;
                }
            }
        }
        if (count + count1 == n - 1 && count + count2 == n - 1)
            return edges.length - (count + count1 + count2);
        return -1;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
