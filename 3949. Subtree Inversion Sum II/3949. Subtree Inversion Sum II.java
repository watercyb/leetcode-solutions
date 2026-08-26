/*
 * Problem: 3949. Subtree Inversion Sum II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subtree-inversion-sum-ii/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public int subtreeInversionSum(int[][] edges, int[] nums, int k) {
        if (k == 1) {
            int res = 0;
            for (int num : nums) {
                res += Math.abs(num);
            }
            return res;
        }
        int[] counts = new int[edges.length + 1];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[counts.length][];
        for (int i = 0; i < counts.length; i++) {
            links[i] = new int[counts[i]];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        ranges1 = new int[k][2];
        ranges2 = new int[k][2];
        int[][] re = dfs(links, nums, 0, -1, k);
        int res = Integer.MIN_VALUE;
        for (int[] pair : re) {
            res = Math.max(res, pair[0]);
        }
        return res;
    }

    int[][] ranges1;
    int[][] ranges2;
    int max_val = Integer.MAX_VALUE / 2;
    int min_val = Integer.MIN_VALUE / 2;

    public int[][] dfs(int[][] links, int[] nums, int i, int prv, int k) {
        int[][] res = null;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            int[][] re = dfs(links, nums, next, i, k);
            if (res == null) {
                res = re;
            } else {
                int max1 = re[0][0];
                int min1 = re[0][1];
                int max2 = res[0][0];
                int min2 = res[0][1];
                for (int l = k - 1; l > 0; l--) {
                    max1 = Math.max(max1, re[l][0]);
                    min1 = Math.min(min1, re[l][1]);
                    ranges1[l][0] = max1;
                    ranges1[l][1] = min1;
                    max2 = Math.max(max2, res[l][0]);
                    min2 = Math.min(min2, res[l][1]);
                    ranges2[l][0] = max2;
                    ranges2[l][1] = min2;
                }
                for (int l = 1; l < k; l++) {
                    int idx = Math.max(l, k - l);
                    res[l][0] = Math.max(res[l][0] + ranges1[idx][0], re[l][0] + ranges2[idx][0]);
                    res[l][1] = Math.min(res[l][1] + ranges1[idx][1], re[l][1] + ranges2[idx][1]);
                }
                res[0][0] += re[0][0];
                res[0][1] += re[0][1];
            }
        }
        if (res == null) {
            res = new int[k][2];
            for (int l = 0; l < k; l++) {
                res[l][0] = min_val;
                res[l][1] = max_val;
            }
            res[0][0] = res[0][1] = nums[i];
            res[1][0] = Math.abs(nums[i]);
            res[1][1] = -Math.abs(nums[i]);
        } else {
            res[k - 1][0] = Math.max(res[k - 1][0], res[0][0]);
            res[k - 1][1] = Math.min(res[k - 1][1], res[0][1]);
            for (int l = k - 2; l >= 1; l--) {
                res[l][0] = Math.max(res[l][0], res[l + 1][0]);
                res[l][1] = Math.min(res[l][1], res[l + 1][1]);
            }
            res[0][0] += nums[i];
            res[0][1] += nums[i];
            int temp0 = -res[0][1];
            int temp1 = -res[0][0];
            res[0][0] = Math.max(res[0][0], res[k - 1][0] + nums[i]);
            res[0][1] = Math.min(res[0][1], res[k - 1][1] + nums[i]);
            for (int l = k - 2; l >= 1; l--) {
                res[l + 1][0] = res[l][0] + nums[i];
                res[l + 1][1] = res[l][1] + nums[i];
            }
            res[1][0] = temp0;
            res[1][1] = temp1;
        }
        return res;
    }
}
