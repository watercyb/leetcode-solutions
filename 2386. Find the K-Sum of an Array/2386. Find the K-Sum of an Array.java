/*
 * Problem: 2386. Find the K-Sum of an Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-k-sum-of-an-array/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long kSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int idx = nums.length - 1;
        while (idx >= 0 && nums[idx] >= 0) {
            sum += nums[idx];
            idx--;
        }
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> Long.compare(b.sum, a.sum));
        PQ.offer(new Node(sum, idx, idx + 1));
        for (int i = 1; i < k; i++) {
            Node node = PQ.poll();
            if (node.idxN == idx) {
                if (node.idxP < nums.length) {
                    if (node.idxP > idx + 1)
                        PQ.offer(new Node(node.sum + nums[node.idxP - 1] - nums[node.idxP], idx, node.idxP + 1));
                    PQ.offer(new Node(node.sum - nums[node.idxP], idx, node.idxP + 1));
                }
                if (node.idxN >= 0)
                    PQ.offer(new Node(node.sum + nums[node.idxN], idx - 1, node.idxP));
            } else {
                if (node.idxN >= 0) {
                    PQ.offer(new Node(node.sum - nums[node.idxN + 1] + nums[node.idxN], node.idxN - 1, node.idxP));
                    PQ.offer(new Node(node.sum + nums[node.idxN], node.idxN - 1, node.idxP));
                }
            }
        }
        return PQ.peek().sum;
    }
}

class Node {
    long sum;
    int idxP;
    int idxN;

    public Node(long sum, int idxN, int idxP) {
        this.sum = sum;
        this.idxP = idxP;
        this.idxN = idxN;
    }
}
