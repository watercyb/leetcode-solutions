/*
 * Problem: 3910. Count Connected Subgraphs with Even Node Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-connected-subgraphs-with-even-node-sum/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int[] DP = new int[1 << nums.length];
        int[] links = new int[nums.length];
        for (int[] edge : edges) {
            links[edge[0]] |= 1 << edge[1];
            links[edge[1]] |= 1 << edge[0];
        }
        boolean[] used = new boolean[DP.length];
        int[] arr = new int[DP.length];
        int[] nexts = new int[DP.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = 1 << i;
            used[idx] = true;
            arr[r] = idx;
            nexts[r++] = links[i];
            DP[idx] = nums[i] & 1;
        }
        int res = 0;
        while (l < r) {
            int current = arr[l];
            int next = nexts[l++];
            if (DP[current] == 0)
                res++;
            for (int i = 0; i < nums.length; i++) {
                if ((next & (1 << i)) != 0) {
                    int nextIdx = current | (1 << i);
                    if (!used[nextIdx]) {
                        used[nextIdx] = true;
                        DP[nextIdx] = (DP[current] + nums[i]) & 1;
                        arr[r] = nextIdx;
                        nexts[r] = getH(nextIdx, next | links[i]);
                        r++;
                    }
                }
            }
        }
        return res;
    }

    public int getH(int a, int b) {
        return (~a & (Integer.highestOneBit(a) - 1)) & b;
    }
}
