/*
 * Problem: 3425. Longest Special Path
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-special-path/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        List<int[]>[] lists = new ArrayList[nums.length];
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            lists[i] = new ArrayList<>();
            maxNum = Math.max(nums[i], maxNum);
        }
        int[] counts = new int[nums.length];
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][][] links = new int[nums.length][][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        int[] levels = new int[maxNum + 1];
        Arrays.fill(levels, -1);
        dfs(links, levels, new int[nums.length], 0, 0, -1, nums, 0);
        return res;
    }

    int[] res = { 0, 1 };

    public void dfs(int[][][] links, int[] levels, int[] sums, int minLv, int i, int prvIdx, int[] nums, int lv) {
        int num = nums[i];
        int prvLv = levels[num];
        int prvMinLv = minLv;
        minLv = Math.max(levels[num] + 1, minLv);
        levels[num] = lv;
        if (sums[lv] - sums[minLv] > res[0]) {
            res[0] = sums[lv] - sums[minLv];
            res[1] = lv - minLv + 1;
        } else if (sums[lv] - sums[minLv] == res[0] && lv - minLv + 1 < res[1]) {
            res[1] = lv - minLv + 1;
        }
        for (int[] next : links[i]) {
            if (next[0] == prvIdx)
                continue;
            sums[lv + 1] = sums[lv] + next[1];
            dfs(links, levels, sums, minLv, next[0], i, nums, lv + 1);
        }
        levels[num] = prvLv;
        minLv = prvMinLv;
    }
}
