/*
 * Problem: 1766. Tree of Coprimes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/tree-of-coprimes/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        List<List<Integer>> copsList = new ArrayList<>();
        int[][] lasts = new int[51][2];
        for (int i = 0; i <= 50; i++) {
            copsList.add(new ArrayList<>());
            lasts[i][1] = -1;
        }
        copsList.get(1).add(1);
        for (int i = 1; i < 50; i++) {
            for (int j = i + 1; j <= 50; j++) {
                if (GCD(i, j) == 1) {
                    copsList.get(i).add(j);
                    copsList.get(j).add(i);
                }
            }
        }
        int[][] cops = new int[51][];
        for (int i = 1; i <= 50; i++) {
            List<Integer> list = copsList.get(i);
            cops[i] = new int[list.size()];
            for (int j = 0; j < cops[i].length; j++) {
                cops[i][j] = list.get(j);
            }
        }
        int[] res = new int[nums.length];
        Arrays.fill(res, -2);
        List<List<Integer>> linksList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            linksList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            linksList.get(edge[0]).add(edge[1]);
            linksList.get(edge[1]).add(edge[0]);
        }
        int[][] links = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = linksList.get(i);
            links[i] = new int[list.size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = list.get(j);
            }
        }
        dfs(links, res, lasts, cops, nums, 0, 1);
        return res;
    }

    public void dfs(int[][] links, int[] res, int[][] lasts, int[][] cops, int[] nums,
            int i, int n) {
        int max = -1;
        int idx = -1;
        for (int cop : cops[nums[i]]) {
            if (lasts[cop][0] > max) {
                max = lasts[cop][0];
                idx = lasts[cop][1];
            }
        }
        res[i] = idx;
        int[] prv = lasts[nums[i]];
        lasts[nums[i]] = new int[] { n, i };
        for (int next : links[i]) {
            if (res[next] == -2)
                dfs(links, res, lasts, cops, nums, next, n + 1);
        }
        lasts[nums[i]] = prv;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
