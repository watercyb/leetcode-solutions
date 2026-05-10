/*
 * Problem: 3721. Longest Balanced Subarray II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-balanced-subarray-ii/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int longestBalanced(int[] nums) {
        Node root = new Node();
        int res = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] indexes = new int[max + 1];
        Arrays.fill(indexes, -1);
        for (int i = 0; i < nums.length; i++) {
            insert(root, indexes[nums[i]] + 1, i, nums[i] % 2 * 2 - 1, 0, nums.length - 1);
            int idx = get(root, i, 0, nums.length - 1);
            if (idx != -1)
                res = Math.max(res, i - idx + 1);
            indexes[nums[i]] = i;
        }
        return res;
    }

    public void insert(Node node, int l, int r, int num, int left, int right) {
        if (l > right || r < left)
            return;
        if (left == right) {
            node.min += num;
            node.max += num;
            return;
        }
        if (node.left == null)
            node.left = new Node();
        if (node.right == null)
            node.right = new Node();
        if (node.cache != 0) {
            node.left.update(node.cache);
            node.right.update(node.cache);
            node.cache = 0;
        }
        if (l <= left && r >= right) {
            node.min += num;
            node.max += num;
            node.cache = num;
            return;
        }
        int mid = (left + right) >>> 1;
        insert(node.left, l, r, num, left, mid);
        insert(node.right, l, r, num, mid + 1, right);
        node.min = Math.min(node.left.min, node.right.min);
        node.max = Math.max(node.left.max, node.right.max);
    }

    public int get(Node node, int lim, int left, int right) {
        if (left >= lim)
            return -1;
        if (left == right)
            return left;
        if (node.cache != 0) {
            node.left.update(node.cache);
            node.right.update(node.cache);
            node.cache = 0;
        }
        int mid = (left + right) >>> 1;
        if (node.left.min <= 0 && node.left.max >= 0) {
            return get(node.left, lim, left, mid);
        } else if (node.right.min <= 0 && node.right.max >= 0) {
            return get(node.right, lim, mid + 1, right);
        }
        return -1;
    }
}

class Node {
    Node left;
    Node right;
    int cache = 0;
    int max = 0;
    int min = 0;

    public void update(int num) {
        max += num;
        min += num;
        cache += num;
    }
}
