/*
 * Problem: 1707. Maximum XOR With an Element From Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        PairNode[] pairs = new PairNode[queries.length];
        for (int i = 0; i < queries.length; i++) {
            pairs[i] = new PairNode(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(pairs, (a, b) -> (a.lim - b.lim));
        int[] res = new int[queries.length];
        int idx = 0;
        TrieNode node = new TrieNode();
        for (int i = 0; i < queries.length; i++) {
            while (idx < nums.length && nums[idx] <= pairs[i].lim) {
                insert(node, nums[idx]);
                idx++;
            }
            if (idx == 0) {
                res[pairs[i].idx] = -1;
            } else {
                res[pairs[i].idx] = getMax(node, pairs[i].target);
            }
        }
        return res;
    }

    public int getMax(TrieNode node, int target) {
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if (((target >> i) & 1) == 0) {
                if (node.one != null) {
                    node = node.one;
                    res += 1 << i;
                } else {
                    node = node.zero;
                }
            } else {
                if (node.zero != null) {
                    node = node.zero;
                    res += 1 << i;
                } else {
                    node = node.one;
                }
            }
        }
        return res;
    }

    public void insert(TrieNode node, int num) {
        for (int i = 30; i >= 0; i--) {
            if (((num >> i) & 1) == 0) {
                if (node.zero == null)
                    node.zero = new TrieNode();
                node = node.zero;
            } else {
                if (node.one == null)
                    node.one = new TrieNode();
                node = node.one;
            }
        }
    }
}

class TrieNode {
    TrieNode zero;
    TrieNode one;
}

class PairNode {
    int target = 0;
    int lim = 0;
    int idx = 0;

    public PairNode(int target, int lim, int idx) {
        this.target = target;
        this.lim = lim;
        this.idx = idx;
    }
}
