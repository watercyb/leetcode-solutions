/*
 * Problem: 3165. Maximum Sum of Subsequence With Non-adjacent Elements
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-of-subsequence-with-non-adjacent-elements/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;
        int size = (int) Math.pow(2, Math.ceil(Math.log(nums.length) / Math.log(2)) + 1) - 1;
        int start = size / 2;
        Seg = new Node[size];
        for (int i = 0; i < nums.length; i++) {
            Seg[i + start] = new Node(nums[i]);
        }
        for (int i = start + nums.length; i < Seg.length; i++) {
            Seg[i] = new Node();
        }
        buildSeg(start);
        long res = 0;
        for (int[] query : queries) {
            insert(query[0] + start, query[1]);
            res += Seg[0].getMax();
        }
        return (int) (res % mod);
    }

    Node[] Seg;

    public void buildSeg(int start) {
        for (int i = start - 1; i >= 0; i--) {
            Seg[i] = combine(Seg[2 * i + 1], Seg[2 * i + 2]);
        }
    }

    public void insert(int i, int num) {
        if (Seg[i].TT == num)
            return;
        Seg[i] = new Node(num);
        if (i == 0)
            return;
        do {
            i = (i - 1) / 2;
            combine(Seg[i], Seg[2 * i + 1], Seg[2 * i + 2]);
        } while (i > 0);
    }

    public void combine(Node node, Node left, Node right) {
        node.TT = Math.max(left.TF + Math.max(right.TT, right.FT), left.TT + right.FT);
        node.TF = Math.max(left.TF + Math.max(right.TF, right.FF), left.TT + right.FF);
        node.FT = Math.max(left.FF + Math.max(right.TT, right.FT), left.FT + right.FT);
        node.FF = Math.max(left.FF + Math.max(right.TF, right.FF), left.FT + right.FF);
    }

    public Node combine(Node left, Node right) {
        Node node = new Node();
        node.TT = Math.max(left.TF + Math.max(right.TT, right.FT), left.TT + right.FT);
        node.TF = Math.max(left.TF + Math.max(right.TF, right.FF), left.TT + right.FF);
        node.FT = Math.max(left.FF + Math.max(right.TT, right.FT), left.FT + right.FT);
        node.FF = Math.max(left.FF + Math.max(right.TF, right.FF), left.FT + right.FF);
        return node;
    }
}

class Node {
    long TT = 0;
    long TF = 0;
    long FT = 0;
    long FF = 0;

    public Node() {
    }

    public Node(long TT) {
        this.TT = TT;
    }

    public long getMax() {
        return Math.max(Math.max(TT, TF), Math.max(FT, FF));
    }
}
