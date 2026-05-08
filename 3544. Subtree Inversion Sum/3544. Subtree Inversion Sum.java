/*
 * Problem: 3544. Subtree Inversion Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subtree-inversion-sum/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        List<Integer>[] lists = new ArrayList[nums.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        Node res = dfs(links, nums, 0, -1, k);
        return res.max[0];
    }

    public Node dfs(int[][] links, int[] nums, int i, int prv, int k) {
        if (links[i].length == 1 && prv != -1)
            return new Node(nums[i], k + 1, true);
        Node res = new Node(nums[i], k + 1, false);
        for (int next : links[i]) {
            if (next == prv)
                continue;
            Node resNext = dfs(links, nums, next, i, k);
            long max = resNext.max[k] + res.max[k];
            long min = resNext.min[k] + res.min[k];
            for (int j = k; j > 0; j--) {
                max = Math.max(resNext.max[j - 1] + res.max[j], max);
                min = Math.min(resNext.min[j - 1] + res.min[j], min);
                res.max[j] = max;
                res.min[j] = min;
            }
            res.max[0] = Math.max(max, res.max[0]);
            res.min[0] = Math.min(min, res.min[0]);
        }
        res.max[0] = Math.max(-res.min[k], res.max[0]);
        res.min[0] = Math.min(-res.max[k], res.min[0]);
        return res;
    }
}

class Node {
    long[] max;
    long[] min;

    public Node(int num, int n, boolean isLeaf) {
        max = new long[n];
        min = new long[n];
        Arrays.fill(max, num);
        Arrays.fill(min, num);
        if (!isLeaf)
            return;
        if (num > 0) {
            max[0] = num;
            min[0] = -num;
        } else {
            max[0] = -num;
            min[0] = num;
        }
    }
}
