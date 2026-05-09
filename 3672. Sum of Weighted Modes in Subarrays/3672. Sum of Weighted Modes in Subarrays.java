/*
 * Problem: 3672. Sum of Weighted Modes in Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-weighted-modes-in-subarrays/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long modeWeight(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            PQ.offer(new Node(++counts[nums[i]], nums[i]));
        }
        long res = PQ.peek().getW();
        for (int i = k; i < nums.length; i++) {
            PQ.offer(new Node(++counts[nums[i]], nums[i]));
            PQ.offer(new Node(--counts[nums[i - k]], nums[i - k]));
            while (!PQ.peek().chk(counts)) {
                PQ.poll();
            }
            res += PQ.peek().getW();
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    int count = 0;
    int num = 0;

    public Node(int count, int num) {
        this.count = count;
        this.num = num;
    }

    public long getW() {
        return (long) this.count * this.num;
    }

    public boolean chk(int[] counts) {
        return counts[num] == count;
    }

    @Override
    public int compareTo(Node node) {
        if (count == node.count)
            return num - node.num;
        return node.count - count;
    }
}
