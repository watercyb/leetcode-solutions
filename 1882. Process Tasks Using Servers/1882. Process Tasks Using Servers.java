/*
 * Problem: 1882. Process Tasks Using Servers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/process-tasks-using-servers/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Long> free = new PriorityQueue<>();
        PriorityQueue<Node> using = new PriorityQueue<>(
                (a, b) -> a.time == b.time ? Long.compare(a.id, b.id) : a.time - b.time);
        for (int i = 0; i < servers.length; i++) {
            free.offer(((long) servers[i]) * 200001 + i);
        }
        int[] res = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i];
            while (!using.isEmpty() && using.peek().time <= i) {
                free.offer(using.poll().id);
            }
            if (free.isEmpty()) {
                Node node = using.poll();
                int time = node.time;
                long id = node.id;
                res[i] = (int) (id % 200001);
                using.offer(new Node(time + task, id));
            } else {
                long id = free.poll();
                res[i] = (int) (id % 200001);
                using.offer(new Node(i + task, id));
            }
        }
        return res;
    }
}

class Node {
    int time;
    long id;

    public Node(int time, long id) {
        this.time = time;
        this.id = id;
    }
}
