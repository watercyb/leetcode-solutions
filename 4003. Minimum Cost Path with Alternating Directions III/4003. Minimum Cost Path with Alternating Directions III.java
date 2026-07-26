/*
 * Problem: 4003. Minimum Cost Path with Alternating Directions III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-path-with-alternating-directions-iii/
 * Language: java
 * Date: 2026-07-26
 */

class Solution {
    public long minCost(int m, int n, int[][] penalty) {
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> Long.compare(a.c, b.c));
        long[][][] costs = new long[m][n][2];
        for (long[][] row : costs) {
            for (long[] arr : row) {
                Arrays.fill(arr, Long.MAX_VALUE);
            }
        }
        PQ.offer(new Node(0, 0, 1, 0));
        costs[0][0][0] = 1;
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            int x = current.x;
            int y = current.y;
            long c = current.c;
            int stp = current.stp;
            if (x == m - 1 && y == n - 1)
                return c;
            if (costs[x][y][stp] != c)
                continue;
            if (stp == 0) {
                if (x - 1 >= 0 && c + x * (y + 1) + penalty[x][y] < costs[x - 1][y][1]) {
                    costs[x - 1][y][1] = c + x * (y + 1) + penalty[x][y];
                    PQ.offer(new Node(x - 1, y, c + x * (y + 1) + penalty[x][y], 1));
                }
                if (x + 1 < m && c + (x + 2) * (y + 1) < costs[x + 1][y][1]) {
                    costs[x + 1][y][1] = c + (x + 2) * (y + 1);
                    PQ.offer(new Node(x + 1, y, c + (x + 2) * (y + 1), 1));
                }
                if (y - 1 >= 0 && c + (x + 1) * y + penalty[x][y] < costs[x][y - 1][1]) {
                    costs[x][y - 1][1] = c + (x + 1) * y + penalty[x][y];
                    PQ.offer(new Node(x, y - 1, c + (x + 1) * y + penalty[x][y], 1));
                }
                if (y + 1 < n && c + (x + 1) * (y + 2) < costs[x][y + 1][1]) {
                    costs[x][y + 1][1] = c + (x + 1) * (y + 2);
                    PQ.offer(new Node(x, y + 1, c + (x + 1) * (y + 2), 1));
                }
                if (c + penalty[x][y] < costs[x][y][1]) {
                    costs[x][y][1] = c + penalty[x][y];
                    PQ.offer(new Node(x, y, c + penalty[x][y], 1));
                }
            } else {
                if (x - 1 >= 0 && c + x * (y + 1) < costs[x - 1][y][0]) {
                    costs[x - 1][y][0] = c + x * (y + 1);
                    PQ.offer(new Node(x - 1, y, c + x * (y + 1), 0));
                }
                if (x + 1 < m && c + (x + 2) * (y + 1) + penalty[x][y] < costs[x + 1][y][0]) {
                    costs[x + 1][y][0] = c + (x + 2) * (y + 1) + penalty[x][y];
                    PQ.offer(new Node(x + 1, y, c + (x + 2) * (y + 1) + penalty[x][y], 0));
                }
                if (y - 1 >= 0 && c + (x + 1) * y < costs[x][y - 1][0]) {
                    costs[x][y - 1][0] = c + (x + 1) * y;
                    PQ.offer(new Node(x, y - 1, c + (x + 1) * y, 0));
                }
                if (y + 1 < n && c + (x + 1) * (y + 2) + penalty[x][y] < costs[x][y + 1][0]) {
                    costs[x][y + 1][0] = c + (x + 1) * (y + 2) + penalty[x][y];
                    PQ.offer(new Node(x, y + 1, c + (x + 1) * (y + 2) + penalty[x][y], 0));
                }
                if (c + penalty[x][y] < costs[x][y][0]) {
                    costs[x][y][0] = c + penalty[x][y];
                    PQ.offer(new Node(x, y, c + penalty[x][y], 0));
                }
            }
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    long c;
    int stp;

    public Node(int x, int y, long c, int stp) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.stp = stp;
    }
}
