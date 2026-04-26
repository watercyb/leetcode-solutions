/*
 * Problem: 2322. Minimum Score After Removals on a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        List<Integer>[] lists = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
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
        for (int num : nums) {
            XOR ^= num;
        }
        XORs = new int[nums.length];
        dfs(links, nums, 0, -1);
        return res;
    }

    int XOR = 0;
    int[] XORs;
    int res = Integer.MAX_VALUE;

    public int dfs(int[][] lists, int[] nums, int i, int prv) {
        int res = nums[i];
        for (int next : lists[i]) {
            if (next == prv)
                continue;
            res ^= dfs(lists, nums, next, i);
        }
        if (i != 0)
            dfs(lists, nums, 0, -1, i, res);
        return res;
    }

    public int dfs(int[][] lists, int[] nums, int i, int prv, int target, int targetXOR) {
        int res = nums[i];
        for (int next : lists[i]) {
            if (next == prv || next == target)
                continue;
            res ^= dfs(lists, nums, next, i, target, targetXOR);
        }
        if (i != 0) {
            int a = XOR ^ res ^ targetXOR;
            int max = Math.max(Math.max(a, res), targetXOR);
            int min = Math.min(Math.min(a, res), targetXOR);
            this.res = Math.min(this.res, max - min);
        }
        return res;
    }

}
