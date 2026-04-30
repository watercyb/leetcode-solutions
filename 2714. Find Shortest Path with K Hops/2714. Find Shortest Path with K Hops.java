/*
 * Problem: 2714. Find Shortest Path with K Hops
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-shortest-path-with-k-hops/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {
        List<List<int[]>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(new int[] { edge[1], edge[2] });
            links.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int[][] steps = new int[n][k + 1];
        for (int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> a.w - b.w);
        PQ.offer(new Node(0, s, 0));
        steps[s][0] = 0;
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            if (current.idx == d)
                return current.w;
            if (steps[current.idx][current.n] != current.w)
                continue;
            for (int[] next : links.get(current.idx)) {
                int sum = current.w + next[1];
                if (steps[next[0]][current.n] > sum) {
                    steps[next[0]][current.n] = sum;
                    PQ.offer(new Node(sum, next[0], current.n));
                }
                if (current.n < k && steps[next[0]][current.n + 1] > current.w) {
                    steps[next[0]][current.n + 1] = current.w;
                    PQ.offer(new Node(current.w, next[0], current.n + 1));
                }
            }
        }
        return -1;
    }
}

class Node {
    int w;
    int idx;
    int n;

    public Node(int w, int idx, int n) {
        this.w = w;
        this.idx = idx;
        this.n = n;
    }
}
