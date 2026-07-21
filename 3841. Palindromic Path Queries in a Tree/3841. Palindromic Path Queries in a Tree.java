/*
 * Problem: 3841. Palindromic Path Queries in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindromic-path-queries-in-a-tree/
 * Language: java
 * Date: 2026-07-21
 */

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[n][];
        int[] chrs = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]];
            chrs[i] = s.charAt(i) - 'a';
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        heavies = new int[n];
        dfsHeavy(links, 0, -1);
        BIT = new int[n + 1];
        treeToGroupIndexes = new int[n];
        tops = new int[n];
        prvs = new int[n];
        levels = new int[n];
        groupToTreeIndex = new int[n];
        idx = n - 1;
        dfsGroup(links, 0, -1, n, -1, 0);
        for (int i = 0; i < n; i++) {
            int h = 1 << chrs[i];
            insert(treeToGroupIndexes[i], h);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String[] strs = queries[i].split(" ");
            if (strs[0].equals("update")) {
                int idx = Integer.valueOf(strs[1]);
                int chr = strs[2].charAt(0) - 'a';
                if (chrs[idx] == chr)
                    continue;
                int h = (1 << chrs[idx]) + (1 << chr);
                chrs[idx] = chr;
                insert(treeToGroupIndexes[idx], h);
            } else {
                int a = treeToGroupIndexes[Integer.valueOf(strs[1])];
                int b = treeToGroupIndexes[Integer.valueOf(strs[2])];
                int h = 0;
                while (tops[a] != tops[b]) {
                    if (levels[tops[a]] < levels[tops[b]]) {
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    int top = tops[a];
                    if (top == a) {
                        h ^= 1 << chrs[groupToTreeIndex[a]];
                    } else {
                        h ^= get(a - 1);
                        h ^= get(top);
                    }
                    a = prvs[top];
                }
                if (levels[a] < levels[b]) {
                    h ^= get(a);
                    h ^= get(b - 1);
                } else {
                    h ^= get(b);
                    h ^= get(a - 1);
                }
                res.add(Integer.bitCount(h) <= 1);
            }
        }
        return res;
    }

    int[] heavies;
    int[] BIT;
    int[] treeToGroupIndexes;
    int[] tops;
    int[] prvs;
    int[] levels;
    int[] groupToTreeIndex;
    int idx;

    public void insert(int i, int n) {
        i++;
        while (i < BIT.length) {
            BIT[i] ^= n;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res ^= BIT[i];
            i -= i & -i;
        }
        return res;
    }

    public int dfsHeavy(int[][] links, int i, int prv) {
        int count = 1;
        int maxCount = 0;
        int maxIdx = -1;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            int c = dfsHeavy(links, next, i);
            count += c;
            if (c > maxCount) {
                maxCount = c;
                maxIdx = next;
            }
        }
        heavies[i] = maxIdx;
        return count;
    }

    public void dfsGroup(int[][] links, int i, int prv, int prvIdx, int g, int lv) {
        if (i == -1)
            return;
        if (g == -1)
            g = idx;
        tops[idx] = g;
        prvs[idx] = prvIdx;
        levels[idx] = lv;
        treeToGroupIndexes[i] = idx;
        groupToTreeIndex[idx--] = i;
        dfsGroup(links, heavies[i], i, treeToGroupIndexes[i], g, lv + 1);
        for (int next : links[i]) {
            if (next == prv || next == heavies[i])
                continue;
            dfsGroup(links, next, i, treeToGroupIndexes[i], -1, lv + 1);
        }
    }
}
