/*
 * Problem: 1834. Single-Threaded CPU
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/single-threaded-cpu/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] getOrder(int[][] tasks) {
        Node[] nodes = new Node[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            nodes[i] = new Node(tasks[i][0], tasks[i][1], i);
        }
        Arrays.sort(nodes, (a, b) -> a.beginning - b.beginning);
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> a.time == b.time ? a.idx - b.idx : a.time - b.time);
        int[] res = new int[tasks.length];
        int idxRes = 0;
        int idxTasks = 0;
        int time = 0;
        while (idxRes < tasks.length) {
            if (idxTasks < tasks.length && PQ.isEmpty() && time < nodes[idxTasks].beginning)
                time = nodes[idxTasks].beginning;
            while (idxTasks < tasks.length && nodes[idxTasks].beginning <= time) {
                PQ.offer(nodes[idxTasks++]);
            }
            Node node = PQ.poll();
            res[idxRes++] = node.idx;
            time += node.beginning;
        }
        return res;
    }
}

class Node {
    int beginning;
    int time;
    int idx;

    public Node(int beginning,int time, int idx) {
        this.beginning=beginning;
        this.time=time;
        this.idx=idx;
    }
}
