/*
 * Problem: 3551. Minimum Swaps to Sort by Digit Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minSwaps(int[] nums) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        Arrays.sort(nodes);
        int res = 0;
        for (int i = 0; i < nodes.length; i++) {
            while (nodes[i].idx != i) {
                nodes[i].swap(nodes[nodes[i].idx]);
                res++;
            }
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    long num;
    int idx;

    public Node(int num, int idx) {
        int n = num;
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        this.num = sum * 1_000_000_001 + num;
        this.idx = idx;
    }

    public void swap(Node node) {
        int idx = this.idx;
        this.idx = node.idx;
        node.idx = idx;
    }

    @Override
    public int compareTo(Node node) {
        if (this.num > node.num)
            return 1;
        return -1;
    }
}
