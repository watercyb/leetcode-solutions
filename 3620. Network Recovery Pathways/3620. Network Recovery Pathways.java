/*
 * Problem: 3620. Network Recovery Pathways
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/network-recovery-pathways/?envType=daily-question&envId=2026-07-03
 * Language: java
 * Date: 2026-07-03
 */

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        List<int[]>[] lists = new ArrayList[online.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int r = 0;
        for (int[] edge : edges) {
            if (!online[edge[0]] || !online[edge[1]])
                continue;
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            r = Math.max(edge[2], r);
        }
        int[][][] links = new int[lists.length][][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        scores = new long[links.length];
        if (!chk(links, 0, k, 0))
            return -1;
        int l = 0;
        r++;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(links, 0, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    long[] scores;

    public boolean chk(int[][][] links, int i, long k, int mid) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(k, 0));
        Arrays.fill(scores, -1);
        scores[0] = k;
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            if (scores[node.idx] != node.score)
                continue;
            for (int[] next : links[node.idx]) {
                int idx = next[0];
                long score = node.score - next[1];
                if (next[1] >= mid && score > scores[idx]) {
                    if (idx == links.length - 1)
                        return true;
                    scores[idx] = score;
                    PQ.offer(new Node(score, idx));
                }
            }
        }
        return false;
    }
}

class Node implements Comparable<Node> {
    long score;
    int idx;

    public Node(long score, int idx) {
        this.score = score;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node node) {
        return Long.compare(node.score, score);
    }
}
