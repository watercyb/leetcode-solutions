/*
 * Problem: 2454. Next Greater Element IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/next-greater-element-iv/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        Node head = new Node(-1, -1);
        head.next = new Node(Integer.MAX_VALUE, -1, null);
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            Node node = head.next;
            Node prv = head;
            while (nums[i] > node.val) {
                if (node.count++ == 1) {
                    res[node.idx] = nums[i];
                    prv.next = node.next;
                } else {
                    prv = prv.next;
                }
                node = node.next;
            }
            prv.next = new Node(nums[i], i, prv.next);
        }
        return res;
    }
}

class Node {
    int val;
    int idx;
    int count = 0;
    Node next;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }

    public Node(int val, int idx, Node next) {
        this.val = val;
        this.idx = idx;
        this.next = next;
    }
}
