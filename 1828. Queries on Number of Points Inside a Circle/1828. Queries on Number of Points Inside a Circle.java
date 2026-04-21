/*
 * Problem: 1828. Queries on Number of Points Inside a Circle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        for (int[] point : points) {
            xMax = Math.max(xMax, point[0]);
            xMin = Math.min(xMin, point[0]);
            yMax = Math.max(xMax, point[1]);
            yMin = Math.min(xMin, point[1]);
        }
        Node root = new Node(new int[] { (xMax + xMin) / 2, (yMax + yMin) / 2 }, 0);
        for (int[] point : points) {
            insert(root, point, 0);
        }
        int[] res = new int[queries.length];
        int[][] range = { { 0, 500 }, { 0, 500 } };
        for (int i = 0; i < queries.length; i++) {
            res[i] = get(root, range, queries[i], queries[i][2] * queries[i][2], 0);
        }
        return res;
    }

    public int get(Node node, int[][] range, int[] pos, int r2, int turn) {
        if (node == null)
            return 0;
        int[] dists = getRange(range, pos);
        if (dists[0] > r2)
            return 0;
        if (dists[1] <= r2)
            return node.sum;
        int res = getDist(node.pos, pos) <= r2 ? node.count : 0;
        int temp = range[turn][1];
        range[turn][1] = Math.min(range[turn][1], node.pos[turn] - 1);
        res += get(node.left, range, pos, r2, 1 - turn);
        range[turn][1] = temp;
        temp = range[turn][0];
        range[turn][0] = Math.max(range[turn][0], node.pos[turn]);
        res += get(node.right, range, pos, r2, 1 - turn);
        range[turn][0] = temp;
        return res;
    }

    public int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public int[] getRange(int[][] range, int[] pos) {
        int x1 = range[0][0];
        int x2 = range[0][1];
        int y1 = range[1][0];
        int y2 = range[1][1];
        int x = pos[0];
        int y = pos[1];
        int xMin = 0;
        int xMax = 0;
        int yMin = 0;
        int yMax = 0;
        if (x1 >= x) {
            xMin = x1 - x;
            xMax = x2 - x;
        } else if (x2 <= x) {
            xMin = x - x2;
            xMax = x - x1;
        } else {
            xMax = Math.max(x - x1, x2 - x);
        }
        if (y1 >= y) {
            yMin = y1 - y;
            yMax = y2 - y;
        } else if (y2 <= y) {
            yMin = y - y2;
            yMax = y - y1;
        } else {
            yMax = Math.max(y - y1, y2 - y);
        }
        return new int[] { xMin * xMin + yMin * yMin, xMax * xMax + yMax * yMax };
    }

    public int insert(Node node, int[] pos, int turn) {
        if (node.pos[0] == pos[0] && node.pos[1] == pos[1]) {
            node.count++;
            node.sum++;
        } else if (node.pos[turn] > pos[turn]) {
            if (node.left == null) {
                node.left = new Node(pos, 1);
                node.sum++;
            } else {
                node.sum = node.count + insert(node.left, pos, 1 - turn) + (node.right == null ? 0 : node.right.sum);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(pos, 1);
                node.sum++;
            } else {
                node.sum = node.count + insert(node.right, pos, 1 - turn) + (node.left == null ? 0 : node.left.sum);
            }
        }
        return node.sum;
    }
}

class Node {
    Node left;
    Node right;
    int[] pos;
    int count;
    int sum;

    public Node(int[] pos, int num) {
        this.pos = pos;
        count = sum = num;
    }
}
