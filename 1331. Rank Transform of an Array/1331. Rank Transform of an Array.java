/*
 * Problem: 1331. Rank Transform of an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rank-transform-of-an-array/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], i);
        }
        Arrays.sort(nodes, (a, b) -> a.val - b.val);
        int idx = 0;
        int prev = Integer.MIN_VALUE;
        for (Node node : nodes) {
            if (node.val == prev) {
                arr[node.idx] = idx;
            } else {
                arr[node.idx] = ++idx;
                prev = node.val;
            }
        }
        return arr;
    }
}

class Node {
    int val;
    int idx;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
