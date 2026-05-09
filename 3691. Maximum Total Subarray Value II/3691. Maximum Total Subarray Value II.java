/*
 * Problem: 3691. Maximum Total Subarray Value II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-total-subarray-value-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        SparseTable ST = new SparseTable(nums);
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            PQ.offer(new Node(ST, i, nums.length - 1));
        }
        long res = 0;
        Node node = null;
        for (int i = 0; i < k; i++) {
            if (node == null)
                node = PQ.poll();
            res += node.score();
            node = node.next();
            if (node != null) {
                if (node.score() < PQ.peek().score()) {
                    Node nodeNext = PQ.poll();
                    PQ.offer(node);
                    node = nodeNext;
                }
            }
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    int l;
    int r;
    int[] arr = new int[2];
    SparseTable ST;

    public Node(SparseTable ST, int l, int r) {
        this.ST = ST;
        this.l = l;
        this.r = r;
        arr = ST.query(l, r);
    }

    public Node next() {
        if (l == r)
            return null;
        r--;
        arr = ST.query(l, r);
        return this;
    }

    public int score() {
        return arr[0] - arr[1];
    }

    @Override
    public int compareTo(Node node) {
        return node.arr[0] - node.arr[1] - arr[0] + arr[1];
    }
}

class SparseTable {
    private int n;
    private int k;
    private int[][] stMin;
    private int[][] stMax;
    private int[] log2;

    public SparseTable(int[] arr) {
        n = arr.length;
        k = (int) (Math.log(n) / Math.log(2)) + 1;

        stMin = new int[k][n];
        stMax = new int[k][n];
        log2 = new int[n + 1];

        log2[1] = 0;
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        for (int i = 0; i < n; i++) {
            stMin[0][i] = arr[i];
            stMax[0][i] = arr[i];
        }

        for (int j = 1; j < k; j++) {
            int len = 1 << j;
            int half = len >> 1;
            for (int i = 0; i + len <= n; i++) {
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][i + half]);
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][i + half]);
            }
        }
    }

    public int queryMin(int l, int r) {
        int j = log2[r - l + 1];
        return Math.min(stMin[j][l], stMin[j][r - (1 << j) + 1]);
    }

    public int queryMax(int l, int r) {
        int j = log2[r - l + 1];
        return Math.max(stMax[j][l], stMax[j][r - (1 << j) + 1]);
    }

    public int[] query(int l, int r) {
        return new int[] { queryMax(l, r), queryMin(l, r) };
    }
}
