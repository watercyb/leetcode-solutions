/*
 * Problem: 3321. Find X-Sum of All K-Long Subarrays II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer, Node> HM = new HashMap<>();
        TreeSet<Node> PQ = new TreeSet<>((a, b) -> a.count == b.count ? a.num - b.num : a.count - b.count);
        TreeSet<Node> PQ1 = new TreeSet<>((a, b) -> a.count == b.count ? b.num - a.num : b.count - a.count);
        long sum = 0;
        for (int i = 0; i < Math.min(k, nums.length); i++) {
            sum = inc(nums, HM, PQ, PQ1, sum, i, x);
        }
        long[] res = new long[nums.length - k + 1];
        res[0] = sum;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] != nums[i - k]) {
                sum = inc(nums, HM, PQ, PQ1, sum, i, x);
                sum = dec(nums, HM, PQ, PQ1, sum, i - k, x);
            }
            res[i - k + 1] = sum;
        }
        return res;
    }

    public long inc(int[] nums, HashMap<Integer, Node> HM, TreeSet<Node> PQ, TreeSet<Node> PQ1,
            long sum, int i, int x) {
        if (!HM.containsKey(nums[i])) {
            Node node = new Node(nums[i]);
            HM.put(nums[i], node);
            if (PQ.size() < x) {
                PQ.add(node);
                sum += nums[i];
                node.isInPQ = true;
            } else {
                Node nodePQ = PQ.first();
                if (nodePQ.count == 1 && nodePQ.num < nums[i]) {
                    PQ.removeFirst();
                    PQ1.add(nodePQ);
                    PQ.add(node);
                    sum += nums[i] - nodePQ.num;
                    node.isInPQ = true;
                    nodePQ.isInPQ = false;
                } else {
                    PQ1.add(node);
                    node.isInPQ = false;
                }
            }
        } else {
            Node node = HM.get(nums[i]);
            if (node.isInPQ) {
                PQ.remove(node);
                node.inc();
                PQ.add(node);
                sum += nums[i];
            } else {
                PQ1.remove(node);
                node.inc();
                Node nodePQ = PQ.first();
                if (nodePQ.count < node.count || (nodePQ.count == node.count && nodePQ.num < nums[i])) {
                    PQ.removeFirst();
                    PQ1.add(nodePQ);
                    PQ.add(node);
                    sum += node.sum - nodePQ.sum;
                    node.isInPQ = true;
                    nodePQ.isInPQ = false;
                } else {
                    PQ1.add(node);
                }
            }
        }
        return sum;
    }

    public long dec(int[] nums, HashMap<Integer, Node> HM, TreeSet<Node> PQ, TreeSet<Node> PQ1,
            long sum, int i, int x) {
        Node node = HM.get(nums[i]);
        if (node.isInPQ) {
            PQ.remove(node);
            sum -= node.sum;
            node.dec();
            Node nodePQ1 = PQ1.isEmpty() ? null : PQ1.first();
            if (nodePQ1 != null && (nodePQ1.count > node.count
                    || (nodePQ1.count == node.count && nodePQ1.num > nums[i]))) {
                PQ1.removeFirst();
                if (node.count > 0)
                    PQ1.add(node);
                PQ.add(nodePQ1);
                node.isInPQ = false;
                nodePQ1.isInPQ = true;
                sum += nodePQ1.sum;
            } else {
                if (node.count > 0) {
                    PQ.add(node);
                    sum += node.sum;
                }
            }
        } else {
            PQ1.remove(node);
            node.dec();
            if (node.count > 0)
                PQ1.add(node);
        }
        if (node.count == 0)
            HM.remove(nums[i]);
        return sum;
    }
}

class Node {
    int num;
    int count = 1;
    long sum;
    boolean isInPQ;

    public Node(int num) {
        this.num = num;
        sum = num;
    }

    public void dec() {
        count--;
        sum -= num;
    }

    public void inc() {
        count++;
        sum += num;
    }
}
