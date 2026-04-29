/*
 * Problem: 2659. Make Array Empty
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/make-array-empty/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        Arrays.sort(nodes, (a, b) -> Integer.compare(a.val, b.val));
        long res = nums.length;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = nodes[i].idx;
            if (next < idx)
                res += nums.length - i;
            idx = next;
        }
        return res;
    }
}

class Node {
    int val = 0;
    int idx = 0;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
