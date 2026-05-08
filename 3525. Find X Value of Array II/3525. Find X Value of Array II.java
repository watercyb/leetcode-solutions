/*
 * Problem: 3525. Find X Value of Array II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-x-value-of-array-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        if (k == 1)
            return resultArrayOne(nums, queries);
        Node segment = build(nums, 0, nums.length - 1, k);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            insert(segment, queries[i][0], queries[i][1] % k, 0, nums.length - 1, k);
            Node node = get(segment, queries[i][2], nums.length - 1, 0, nums.length - 1, k);
            res[i] = node.counts[queries[i][3] % k];
        }
        return res;
    }

    public int[] resultArrayOne(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = nums.length - queries[i][2];
        }
        return res;
    }

    public void insert(Node node, int i, int num, int left, int right, int k) {
        if (i < left || i > right)
            return;
        if (left == right) {
            Arrays.fill(node.counts, 0);
            node.counts[num] = 1;
            node.rem = num;
        } else {
            int mid = (left + right) >>> 1;
            if (node.left == null) {
                node.left = new Node(k);
                node.right = new Node(k);
            }
            insert(node.left, i, num, left, mid, k);
            insert(node.right, i, num, mid + 1, right, k);
            merge(node, k);
        }
    }

    public void merge(Node node, int k) {
        int[] a = node.left.counts;
        int[] b = node.right.counts;
        int rem = node.left.rem;
        for (int i = 0; i < a.length; i++) {
            node.counts[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            node.counts[i * rem % k] += b[i];
        }
        node.rem = rem * node.right.rem % k;
    }

    public Node get(Node node, int l, int r, int left, int right, int k) {
        if (l <= left && r >= right)
            return node;
        int mid = (left + right) >>> 1;
        if (l > mid)
            return get(node.right, l, r, mid + 1, right, k);
        Node res = new Node(k);
        res.left = get(node.left, l, r, left, mid, k);
        res.right = get(node.right, l, r, mid + 1, right, k);
        merge(res, k);
        return res;
    }

    public Node build(int[] nums, int left, int right, int k) {
        Node res = new Node(k);
        if (left == right) {
            res.rem = nums[left] % k;
            res.counts[res.rem] = 1;
        } else {
            int mid = (left + right) >>> 1;
            res.left = build(nums, left, mid, k);
            res.right = build(nums, mid + 1, right, k);
            merge(res, k);
        }
        return res;
    }
}

class Node {
    int[] counts;
    int rem = 1;
    Node left;
    Node right;

    public Node(int k) {
        counts = new int[k];
    }
}
