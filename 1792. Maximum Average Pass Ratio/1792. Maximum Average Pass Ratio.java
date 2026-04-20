/*
 * Problem: 1792. Maximum Average Pass Ratio
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-average-pass-ratio/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Node> PQ = new PriorityQueue<>(new Compare());
        for (int i = 0; i < classes.length; i++) {
            if (classes[0] == classes[1])
                continue;
            PQ.offer(new Node(classes[i], i));
        }
        for (int i = 0; i < extraStudents; i++) {
            Node max = PQ.poll();
            classes[max.idx][0]++;
            classes[max.idx][1]++;
            PQ.offer(new Node(classes[max.idx], max.idx));
        }
        double res = 0;
        for (int[] c : classes) {
            res += (double) c[0] / c[1];
        }
        res /= classes.length;
        return res;
    }
}

class Node {
    double rate;
    int idx;

    public Node(int[] c, int idx) {
        rate = (double) (c[0] + 1) / (c[1] + 1) - (double) c[0] / c[1];
        this.idx = idx;
    }
}

class Compare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        if (a.rate < b.rate) {
            return 1;
        } else if (a.rate > b.rate) {
            return -1;
        } else {
            return 0;
        }
    }
}
