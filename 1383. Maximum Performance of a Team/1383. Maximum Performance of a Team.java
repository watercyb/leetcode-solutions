/*
 * Problem: 1383. Maximum Performance of a Team
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-performance-of-a-team/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1_000_000_007;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(speed[i], efficiency[i]);
        }
        Arrays.sort(nodes, (a, b) -> b.efficiency - a.efficiency);
        long res = 0;
        long sum = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            PQ.offer(nodes[i].speed);
            sum += nodes[i].speed;
            res = Math.max(sum * nodes[i].efficiency, res);
        }
        for (int i = k; i < n; i++) {
            if (nodes[i].speed <= PQ.peek())
                continue;
            sum -= PQ.poll();
            PQ.offer(nodes[i].speed);
            sum += nodes[i].speed;
            res = Math.max(sum * nodes[i].efficiency, res);
        }
        return (int) (res % mod);
    }
}

class Node {
    int speed;
    int efficiency;

    public Node(int speed, int efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }
}
