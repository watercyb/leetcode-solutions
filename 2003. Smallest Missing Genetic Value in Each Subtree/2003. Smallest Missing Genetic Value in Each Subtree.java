/*
 * Problem: 2003. Smallest Missing Genetic Value in Each Subtree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int[] numsToIdx = new int[100002];
        Arrays.fill(numsToIdx, -1);
        for (int i = 0; i < nums.length; i++) {
            numsToIdx[nums[i]] = i;
        }
        int[] res = new int[parents.length];
        Arrays.fill(res, 1);
        if (numsToIdx[1] == -1)
            return res;
        int idx = numsToIdx[1];
        int prv = -1;
        while (idx >= 0) {
            res[idx] = Integer.MAX_VALUE;
            int temp = idx;
            idx = parents[idx];
            parents[temp] = prv;
            prv = temp;
        }
        int min = 2;
        boolean[] seens = new boolean[100002];
        while (numsToIdx[min] != -1) {
            idx = numsToIdx[min];
            while (res[idx] == 1 && !seens[idx]) {
                seens[idx] = true;
                idx = parents[idx];
            }
            if (res[idx] != 1) {
                while (parents[idx] != -1 && !seens[parents[idx]]) {
                    idx = parents[idx];
                    seens[idx] = true;
                    res[idx] = min;
                }
            }
            min++;
        }
        idx = 0;
        while (idx != -1 && !seens[idx]) {
            res[idx] = min;
            idx = parents[idx];
        }
        return res;
    }
}
