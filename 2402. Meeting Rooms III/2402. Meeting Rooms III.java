/*
 * Problem: 2402. Meeting Rooms III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/meeting-rooms-iii/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int max = 0;
        for (int i = 0; i < meetings.length; i++) {
            max = Math.max(meetings[i][0], max);
        }
        int[] sorted = new int[max + 1];
        for (int i = 0; i < meetings.length; i++) {
            sorted[meetings[i][0]] = meetings[i][1];
        }
        int[] counts = new int[n];
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        PriorityQueue<Node> PQ1 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            PQ.offer(i);
        }
        long min = 0;
        for (int i = 0; i <= max; i++) {
            int l = i;
            int r = sorted[i];
            if (r == 0)
                continue;
            int len = r - l;
            min = Math.max(l, min);
            while (!PQ1.isEmpty() && PQ1.peek().time <= min) {
                PQ.offer(PQ1.poll().idx);
            }
            if (!PQ.isEmpty()) {
                int idx = PQ.poll();
                counts[idx]++;
                PQ1.offer(new Node(idx, min + len));
            } else {
                Node node = PQ1.poll();
                min = Math.max(node.time, min);
                counts[node.idx]++;
                node.time = min + len;
                PQ1.offer(node);
            }
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (counts[i] >= counts[res])
                res = i;
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    int idx;
    long time;

    public Node(int idx, long time) {
        this.idx = idx;
        this.time = time;
    }

    @Override
    public int compareTo(Node node) {
        if (time < node.time) {
            return -1;
        } else if (time > node.time) {
            return 1;
        } else if (idx < node.idx) {
            return -1;
        } else {
            return 1;
        }
    }
}
