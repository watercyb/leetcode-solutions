/*
 * Problem: 3526. Range XOR Queries with Subarray Reversals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/range-xor-queries-with-subarray-reversals/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] getResults(int[] nums, int[][] queries) {
        Tree tree = new Tree(nums);
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                tree.update(query[1], query[2]);
            } else if (query[0] == 2) {
                res.add(tree.getRange(query[1], query[2]));
            } else {
                if (query[1] != query[2])
                    tree.reverse(query[1], query[2]);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
}

class Tree {
    class Node {
        Node left;
        Node right;
        int size = 1;
        int val;
        int xor;
        boolean rev = false;

        public Node(int val) {
            this.val = val;
            this.xor = val;
        }
    }

    Node root;

    public Tree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            root = merge(root, new Node(nums[i]));
        }
    }

    public int getRange(int l, int r) {
        int left = l == 0 ? 0 : getXor(root, 0, l);
        int right = getXor(root, 0, r + 1);
        return left ^ right;
    }

    public void update(int idx, int num) {
        update(root, 0, idx + 1, num);
    }

    public void reverse(int l, int r) {
        Node[] nodes = split(root, 0, r + 2);
        Node right = nodes[1];
        nodes = split(nodes[0], 0, l + 1);
        Node left = nodes[0];
        Node mid = nodes[1];
        mid.rev = !mid.rev;
        root = merge(merge(left, mid), right);
    }

    public void cache(Node node) {
        if (node.rev) {
            node.rev = false;
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null)
                node.left.rev = !node.left.rev;
            if (node.right != null)
                node.right.rev = !node.right.rev;
        }
    }

    public Node[] split(Node node, int prv, int target) {
        if (node == null)
            return new Node[] { null, null };
        cache(node);
        int idx = prv + getSize(node.left) + 1;
        if (idx >= target) {
            Node[] res = split(node.left, prv, target);
            node.left = res[1];
            node.size = getSize(node.left) + getSize(node.right) + 1;
            node.xor = node.val ^ getXor(node.left) ^ getXor(node.right);
            res[1] = node;
            return res;
        } else {
            Node[] res = split(node.right, idx, target);
            node.right = res[0];
            node.size = getSize(node.left) + getSize(node.right) + 1;
            node.xor = node.val ^ getXor(node.left) ^ getXor(node.right);
            res[0] = node;
            return res;
        }
    }

    public Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        Node maxNode = left;
        cache(maxNode);
        int prv = 0;
        while (maxNode.right != null) {
            prv += getSize(maxNode.left) + 1;
            maxNode = maxNode.right;
            cache(maxNode);
        }
        Node[] res = split(left, 0, prv + getSize(maxNode.left) + 1);
        maxNode.left = res[0];
        maxNode.right = right;
        maxNode.size = getSize(maxNode.left) + getSize(maxNode.right) + 1;
        maxNode.xor = maxNode.val ^ getXor(maxNode.left) ^ getXor(maxNode.right);
        return maxNode;
    }

    public int getSize(Node node) {
        return node == null ? 0 : node.size;
    }

    public int getXor(Node node) {
        return node == null ? 0 : node.xor;
    }

    public int getXor(Node node, int prv, int target) {
        cache(node);
        int idx = prv + getSize(node.left) + 1;
        if (idx < target) {
            return getXor(node.left) ^ node.val ^ getXor(node.right, idx, target);
        } else if (idx > target) {
            return getXor(node.left, prv, target);
        } else {
            return getXor(node.left) ^ node.val;
        }
    }

    public void update(Node node, int prv, int target, int num) {
        cache(node);
        int idx = prv + getSize(node.left) + 1;
        if (idx < target) {
            update(node.right, idx, target, num);
        } else if (idx > target) {
            update(node.left, prv, target, num);
        } else {
            node.val = num;
        }
        node.xor = node.val ^ getXor(node.left) ^ getXor(node.right);
    }
}
