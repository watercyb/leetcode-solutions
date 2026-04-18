/*
 * Problem: 1569. Number of Ways to Reorder Array to Get Same BST
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    int mod = 1_000_000_007;

    public int numOfWays(int[] nums) {
        Node root = new Node(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insert(root, nums[i]);
        }
        return (int) dfs(root)[0] - 1;
    }

    public long c(int a, int b) {
        long res = 1;
        long div = 1;
        for (int i = 1; i <= a; i++) {
            res = (res * b--) % mod;
            div = (div * i) % mod;
        }
        return res * reverse(div) % mod;
    }

    public long reverse(long a) {
        if (a == 1)
            return a;
        return (mod - mod / a) * reverse(mod % a) % mod;
    }

    public void insert(Node node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new Node(val);
            } else {
                insert(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(val);
            } else {
                insert(node.right, val);
            }
        }
    }

    public int[] dfs(Node node) {
        if (node == null)
            return new int[] { 1, 0 };
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        return new int[] { (int) ((c(l[1], l[1] + r[1]) * l[0] % mod * r[0]) % mod), l[1] + r[1] + 1 };
    }
}

class Node {
    Node left;
    Node right;
    int val = 0;

    public Node(int val) {
        this.val = val;
    }
}
