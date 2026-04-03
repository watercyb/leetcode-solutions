/*
 * Problem: 407. Trapping Rain Water II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/trapping-rain-water-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] seens = new boolean[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            PQ.offer(new Node(i, 0, heightMap[i][0]));
            PQ.offer(new Node(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
            seens[i][0] = true;
            seens[i][heightMap[0].length - 1] = true;
        }
        for (int i = 1; i < heightMap[0].length - 1; i++) {
            PQ.offer(new Node(0, i, heightMap[0][i]));
            PQ.offer(new Node(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]));
            seens[0][i] = true;
            seens[heightMap.length - 1][i] = true;
        }
        int res = 0;
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            for (int[] direction : directions) {
                int x = current.x + direction[0];
                int y = current.y + direction[1];
                if (x >= 0 && x < heightMap.length && y >= 0 && y < heightMap[0].length && !seens[x][y]) {
                    seens[x][y] = true;
                    if (current.height > heightMap[x][y]) {
                        res += current.height - heightMap[x][y];
                        heightMap[x][y] = current.height;
                    }
                    PQ.offer(new Node(x, y, heightMap[x][y]));
                }
            }
        }
        return res;
    }
}

class Node {
    int x;
    int y;
    int height;

    public Node(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}
