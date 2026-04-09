/*
 * Problem: 857. Minimum Cost to Hire K Workers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Node[] nodes = new Node[quality.length];
        for (int i = 0; i < quality.length; i++) {
            nodes[i] = new Node((double) wage[i] / quality[i], i);
        }
        Arrays.sort(nodes, (a, b) -> Double.compare(a.slope, b.slope));
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        Node tmp = new Node();
        int sum = 0;
        int idx = 0;
        while (idx < k) {
            PQ.offer(quality[nodes[idx].idx]);
            sum += quality[nodes[idx].idx];
            idx++;
        }
        double res = nodes[idx - 1].slope * sum;
        while (idx < quality.length) {
            tmp = nodes[idx++];
            if (quality[tmp.idx] < PQ.peek()) {
                sum -= PQ.poll();
                PQ.offer(quality[tmp.idx]);
                sum += quality[tmp.idx];
            }
            double wageTmp = tmp.slope * sum;
            if (wageTmp < res)
                res = wageTmp;
        }
        return res;
    }
}

class Node {
    double slope;
    int idx;

    public Node() {

    }

    public Node(double slope, int idx) {
        this.slope = slope;
        this.idx = idx;
    }
}
