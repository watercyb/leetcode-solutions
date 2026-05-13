/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/power-update-after-k-th-largest-insertion-ii/
 * Language: java
 * Date: 2026-05-13
 */

class Solution {
    int mod = 1_000_000_007;

    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        Node root = new Node(-1, 0);
        for (int num : nums) {
            insert(root, 0, 1000000000, num);
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            insert(root, 0, 1000000000, query[0]);
            int num = get(root, 0, 1000000000, root.count - query[1] + 1);
            p = pow(p, num);
            res.add(p);
        }
        return res;
    }

    public void insert(Node node, int l, int r, int val) {
        if (l == r || node.val == val) {
            node.count++;
            return;
        }
        int mid = (l + r) >>> 1;
        if (node.val >= 0) {
            if (mid >= node.val) {
                node.left = new Node(node.val, node.count);
            } else {
                node.right = new Node(node.val, node.count);
            }
            node.val = -1;
        }
        node.count++;
        if (mid >= val) {
            if (node.left == null) {
                node.left = new Node(val, 1);
            } else {
                insert(node.left, l, mid, val);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(val, 1);
            } else {
                insert(node.right, mid + 1, r, val);
            }
        }
    }

    public int get(Node node, int l, int r, int sum) {
        if (l == r || node.val >= 0)
            return node.val;
        int mid = (l + r) >>> 1;
        if (node.left != null && sum <= node.left.count) {
            return get(node.left, l, mid, sum);
        } else {
            return get(node.right, mid + 1, r, sum - (node.left == null ? 0 : node.left.count));
        }
    }

    public int pow(long a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return (int) res;
    }
}

class Node {
    Node left;
    Node right;
    int val;
    int count;

    public Node(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
