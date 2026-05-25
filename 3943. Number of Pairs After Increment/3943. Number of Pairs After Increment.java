/*
 * Problem: 3943. Number of Pairs After Increment
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-pairs-after-increment/
 * Language: java
 * Date: 2026-05-25
 */

class Solution {
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        int max = 0;
        Node root = new Node();
        for (int i = 0; i < nums2.length; i++) {
            max = Math.max(max, nums2[i]);
            insert(root, 0, nums2.length - 1, i, nums2[i]);
        }
        int count = 0;
        for (int[] query : queries) {
            if (query[0] == 2)
                count++;
        }
        int[] res = new int[count];
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                update(root, 0, nums2.length - 1, query[1], query[2], query[3]);
            } else {
                int sum = 0;
                for (int num : nums1) {
                    sum += get(root, 0, nums2.length - 1, query[1] - num);
                }
                res[idx++] = sum;
            }
        }
        return res;
    }

    public void insert(Node node, int l, int r, int i, int num) {
        if (l > i || r < i)
            return;
        if (l == r) {
            node.HM.put(num, 1);
            node.max = node.min = num;
        } else {
            node.HM.put(num, node.HM.getOrDefault(num, 0) + 1);
            node.max = Math.max(node.max, num);
            node.min = Math.min(node.min, num);
            if (node.left == null) {
                node.left = new Node();
                node.right = new Node();
            }
            int mid = (l + r) >>> 1;
            insert(node.left, l, mid, i, num);
            insert(node.right, mid + 1, r, i, num);
        }
    }

    public void update(Node node, int l, int r, int left, int right, int num) {
        if (l >= left && r <= right) {
            node.max += num;
            node.min += num;
            node.cache += num;
        } else {
            int mid = (l + r) >>> 1;
            node.left.cache += node.cache;
            node.right.cache += node.cache;
            node.left.max += node.cache;
            node.left.min += node.cache;
            node.right.max += node.cache;
            node.right.min += node.cache;
            node.cache = 0;
            node.HM = null;
            if (left <= mid)
                update(node.left, l, mid, left, right, num);
            if (right > mid)
                update(node.right, mid + 1, r, left, right, num);
            node.max = Math.max(node.left.max, node.right.max);
            node.min = Math.min(node.left.min, node.right.min);
        }
    }

    public int get(Node node, int l, int r, int target) {
        if (node.min > target || node.max < target)
            return 0;
        if (l == r)
            return node.HM.getOrDefault(target - node.cache, 0);
        if (node.HM == null) {
            int mid = (l + r) >>> 1;
            node.left.cache += node.cache;
            node.right.cache += node.cache;
            node.left.max += node.cache;
            node.left.min += node.cache;
            node.right.max += node.cache;
            node.right.min += node.cache;
            node.cache = 0;
            return get(node.left, l, mid, target) + get(node.right, mid + 1, r, target);
        } else {
            return node.HM.getOrDefault(target - node.cache, 0);
        }
    }
}

class Node {
    HashMap<Integer, Integer> HM = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int cache = 0;
    Node left;
    Node right;
}
