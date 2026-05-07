/*
 * Problem: 3486. Longest Special Path II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-special-path-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        List<int[]>[] lists = new ArrayList[nums.length];
        int maxNum = 0;
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            maxNum = Math.max(nums[i], maxNum);
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int[] maxIdx = new int[maxNum + 1];
        Arrays.fill(maxIdx, -1);
        dfs(lists, nums, 0, -1, new int[50000], new TreeSet<>(), maxIdx, 0);
        return new int[] { max, min };
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void dfs(List<int[]>[] lists, int[] nums, int i, int prv, int[] sums, TreeSet<Integer> TS, int[] maxIdx,
            int lv) {
        int prvIdx = maxIdx[nums[i]];
        maxIdx[nums[i]] = lv;
        if (prvIdx >= 0)
            TS.add(prvIdx);
        if (TS.size() < 2) {
            if (sums[lv] > max) {
                max = sums[lv];
                min = lv + 1;
            } else if (sums[lv] == max && lv + 1 < min) {
                min = lv + 1;
            }
        } else {
            int idx = TS.floor(TS.last() - 1);
            int sum = sums[lv] - sums[idx + 1];
            if (sum > max) {
                max = sum;
                min = lv - idx;
            } else if (sum == max && lv - idx < min) {
                min = lv - idx;
            }
        }
        for (int[] next : lists[i]) {
            if (next[0] == prv)
                continue;
            sums[lv + 1] = sums[lv] + next[1];
            dfs(lists, nums, next[0], i, sums, TS, maxIdx, lv + 1);
        }
        if (prvIdx >= 0)
            TS.remove(prvIdx);
        maxIdx[nums[i]] = prvIdx;
    }
}
