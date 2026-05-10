/*
 * Problem: 3710. Maximum Partition Factor
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-partition-factor/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maxPartitionFactor(int[][] points) {
        int n = points.length;
        if (n == 2)
            return 0;
        int[] links = new int[n];
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                PQ.offer(new Node(i, j, getDist(points[i], points[j])));
            }
            links[i] = i;
        }
        int[] opposites = new int[n];
        Arrays.fill(opposites, -1);
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            int a = find(links, node.i);
            int b = find(links, node.j);
            if (a == b)
                return node.dist;
            if (opposites[a] == -1 && opposites[b] == -1) {
                opposites[a] = b;
                opposites[b] = a;
            } else if (opposites[a] != -1 && opposites[b] == -1) {
                links[find(links, opposites[a])] = b;
                opposites[a] = b;
                opposites[b] = a;
            } else if (opposites[a] == -1 && opposites[b] != -1) {
                links[find(links, opposites[b])] = a;
                opposites[a] = b;
                opposites[b] = a;
            } else {
                int oA = find(links, opposites[a]);
                int oB = find(links, opposites[b]);
                if (oA == oB)
                    return node.dist;
                links[a] = oB;
                links[b] = oA;
            }
        }
        return -1;
    }

    public int find(int[] links, int i) {
        if (i == -1)
            return -1;
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

class Node implements Comparable<Node> {
    int i;
    int j;
    int dist;

    public Node(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
        return dist - node.dist;
    }
}
