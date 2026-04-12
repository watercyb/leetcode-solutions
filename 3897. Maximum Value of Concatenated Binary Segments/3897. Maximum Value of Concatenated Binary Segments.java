/*
 * Problem: 3897. Maximum Value of Concatenated Binary Segments
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-value-of-concatenated-binary-segments/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        Node[] nodes = new Node[nums1.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(nums1[i], nums0[i]);
        }
        Arrays.sort(nodes);
        long res = 0;
        for (Node node : nodes) {
            long a = pow(node.one);
            res = (res * a + (a - 1)) % mod;
            long b = pow(node.zero);
            res = (res * b) % mod;
        }
        return (int) res;
    }

    int mod = 1_000_000_007;

    public long pow(int n) {
        long res = 1;
        long base = 2;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            n >>= 1;
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    int one;
    int zero;

    public Node(int one, int zero) {
        this.one = one;
        this.zero = zero;
    }

    @Override
    public int compareTo(Node node) {
        if (zero == 0 && node.zero == 0)
            return 0;
        if (zero == 0)
            return -1;
        if (node.zero == 0)
            return 1;
        if (one == node.one) {
            return zero - node.zero;
        }
        return node.one - one;
    }
}
