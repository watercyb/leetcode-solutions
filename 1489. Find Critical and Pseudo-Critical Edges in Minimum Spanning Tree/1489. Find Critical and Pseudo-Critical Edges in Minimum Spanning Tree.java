/*
 * Problem: 1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] links = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            links[i][0] = edges[i][0];
            links[i][1] = edges[i][1];
            links[i][2] = edges[i][2];
            links[i][3] = i;
        }
        Arrays.sort(links, (a, b) -> a[2] - b[2]);
        List<Integer> crt = new ArrayList<>();
        List<Integer> psc = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(crt);
        res.add(psc);
        int min = getMin(links, n, -1);
        for (int i = 0; i < links.length; i++) {
            if (getMinWO(links, n, i) != min) {
                crt.add(links[i][3]);
            } else if (getMin(links, n, i) == min) {
                psc.add(links[i][3]);
            }
        }
        return res;
    }

    public int getMinWO(int[][] edges, int n, int chk) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int res = 0;
        for (int i = 0; i < edges.length && n > 1; i++) {
            if (i == chk)
                continue;
            if (unionFind(links, edges[i][0]) != unionFind(links, edges[i][1])) {
                res += edges[i][2];
                links[links[edges[i][0]]] = links[edges[i][1]];
                n--;
            }
        }
        if (n > 1)
            return -1;
        return res;
    }

    public int getMin(int[][] edges, int n, int chk) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int res = 0;
        if (chk >= 0) {
            res += edges[chk][2];
            links[edges[chk][0]] = edges[chk][1];
            n--;
        }
        for (int i = 0; i < edges.length && n > 1; i++) {
            if (i == chk)
                continue;
            if (unionFind(links, edges[i][0]) != unionFind(links, edges[i][1])) {
                res += edges[i][2];
                links[links[edges[i][0]]] = links[edges[i][1]];
                n--;
            }
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] == i)
            return i;
        links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
