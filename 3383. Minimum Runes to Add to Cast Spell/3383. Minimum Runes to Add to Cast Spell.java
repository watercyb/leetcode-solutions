/*
 * Problem: 3383. Minimum Runes to Add to Cast Spell
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-runes-to-add-to-cast-spell/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minRunesToAdd(int n, int[] crystals, int[] flowFrom, int[] flowTo) {
        boolean[] isCrystals = new boolean[n];
        boolean[] covers = new boolean[n];
        for (int crystal : crystals) {
            isCrystals[crystal] = true;
            covers[crystal] = true;
        }
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] counts = new int[n];
        for (int i = 0; i < flowFrom.length; i++) {
            lists[flowFrom[i]].add(flowTo[i]);
            counts[flowTo[i]]++;
        }
        int[] seens = new int[n];
        Arrays.fill(seens, -1);
        int res = 0;
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            if (counts[i] == 0) {
                dfs(lists, seens, i);
                if (!covers[i])
                    res++;
            }
            if (seens[i] == -1 && covers[i]) {
                dfs(lists, seens, i);
            }
            links[i] = i;
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (seens[i] == -1) {
                dfs(lists, links, seens, i, idx);
                idx++;
            }
        }
        for (int i = 0; i < idx; i++) {
            if (links[i] == i)
                res++;
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public void dfs(List<Integer>[] lists, int[] seens, int i) {
        if (seens[i] != -1)
            return;
        seens[i] = -2;
        for (int next : lists[i]) {
            dfs(lists, seens, next);
        }
    }

    public void dfs(List<Integer>[] lists, int[] links, int[] seens, int i, int idx) {
        if (seens[i] == -1) {
            seens[i] = idx;
        } else if (seens[i] == -2) {
            return;
        } else if (seens[i] >= 0) {
            int a = find(links, idx);
            int b = find(links, seens[i]);
            if (a != b) {
                links[b] = a;
            } else {
                return;
            }
        }
        for (int next : lists[i]) {
            dfs(lists, links, seens, next, idx);
        }
    }
}
