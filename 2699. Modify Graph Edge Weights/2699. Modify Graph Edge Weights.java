/*
 * Problem: 2699. Modify Graph Edge Weights
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/modify-graph-edge-weights/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<int[]>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            links.get(edges[i][0]).add(new int[] { edges[i][1], edges[i][2], i });
            links.get(edges[i][1]).add(new int[] { edges[i][0], edges[i][2], i });
        }
        int sum = bfs(n, links, source, destination, target);
        if (sum < target) {
            return new int[0][0];
        } else if (sum == target) {
            for (int[] edge : edges) {
                if (edge[2] == -1)
                    edge[2] = 2_000_000_000;
            }
            return edges;
        }
        int a = bfs(n, edges, links, source, destination, target);
        while (a > 0) {
            a = bfs(n, edges, links, source, destination, target);
        }
        if (a == -1)
            return new int[0][0];
        for (int[] edge : edges) {
            if (edge[2] < 0)
                edge[2] = -edge[2];
        }
        return edges;
    }

    public int bfs(int n, int[][] edges, List<List<int[]>> links, int source, int destination, int target) {
        int[] stps = new int[n];
        Arrays.fill(stps, Integer.MAX_VALUE);
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        stps[source] = 0;
        PQ.offer(new Node(0, new ArrayList<>(), source));
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            if (current.sum != stps[current.tail])
                continue;
            if (current.tail == destination) {
                if (current.sum == target)
                    return 0;
                edges[current.list.getFirst()][2] -= target - current.sum;
                for (int idx : current.list) {
                    edges[idx][2] = -edges[idx][2];
                }
                for (int[] edge : edges) {
                    if (edge[2] < 0)
                        edge[2] = Integer.MAX_VALUE / 2;
                }
                for (int idx : current.list) {
                    edges[idx][2] = -edges[idx][2];
                }
                return 1;
            }
            for (int[] next : links.get(current.tail)) {
                int stp = current.sum + Math.abs(edges[next[2]][2]);
                if (stps[next[0]] > stp && stp <= target) {
                    stps[next[0]] = stp;
                    Node nodeNext = new Node(stp, new ArrayList<>(current.list), next[0]);
                    if (next[1] < 0)
                        nodeNext.list.add(next[2]);
                    PQ.offer(nodeNext);
                }
            }
        }
        return -1;
    }

    public int bfs(int n, List<List<int[]>> links, int source, int destination, int target) {
        int[] stps = new int[n];
        Arrays.fill(stps, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        stps[source] = 0;
        PQ.offer(new int[] { source, 0 });
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            if (current[1] != stps[current[0]])
                continue;
            if (current[0] == destination)
                return current[1];
            for (int[] next : links.get(current[0])) {
                if (next[1] != -1 && stps[next[0]] > current[1] + next[1]) {
                    stps[next[0]] = current[1] + next[1];
                    PQ.offer(new int[] { next[0], stps[next[0]] });
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

class Node {
    int sum = 0;
    List<Integer> list;
    int tail = 0;

    public Node(int sum, List<Integer> list, int tail) {
        this.sum = sum;
        this.list = list;
        this.tail = tail;
    }
}
