/*
 * Problem: 2747. Count Zero Request Servers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-zero-request-servers/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        Node[] nodes = new Node[queries.length];
        for (int i = 0; i < queries.length; i++) {
            nodes[i] = new Node(queries[i], i);
        }
        Arrays.sort(nodes, (a, b) -> a.val - b.val);
        int[] res = new int[queries.length];
        Arrays.fill(res, n);
        int[] counts = new int[n + 1];
        int count = 0;
        int l = 0;
        while (l < logs.length && logs[l][1] < nodes[0].val - x) {
            l++;
        }
        int r = l;
        int idx = 0;
        while (l < logs.length && idx < nodes.length) {
            while (r < logs.length && logs[r][1] <= nodes[idx].val) {
                if (counts[logs[r][0]]++ == 0)
                    count++;
                r++;
            }
            while (l < r && logs[l][1] < nodes[idx].val - x) {
                if (counts[logs[l][0]]-- == 1)
                    count--;
                l++;
            }
            res[nodes[idx].idx] = n - count;
            idx++;
        }
        return res;
    }
}

class Node {
    int val;
    int idx;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
