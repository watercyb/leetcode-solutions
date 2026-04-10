/*
 * Problem: 959. Regions Cut By Slashes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/regions-cut-by-slashes/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int regionsBySlashes(String[] grid) {
        int l = grid.length + 1;
        int[] links = new int[l * l];
        int idx = 0;
        for (int i = 0; i <= grid.length; i++) {
            for (int j = 0; j <= grid.length; j++) {
                if (i == 0 || j == 0 || i == grid.length || j == grid.length) {
                    links[idx] = 0;
                } else {
                    links[idx] = idx;
                }
                idx++;
            }
        }
        idx = 0;
        int res = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                char chr = grid[i].charAt(j);
                if (chr == '/') {
                    int a = unionFind(links, idx + 1);
                    int b = unionFind(links, idx + l);
                    if (a == b) {
                        res++;
                    } else {
                        links[a] = b;
                    }
                } else if (chr == '\\') {
                    int a = unionFind(links, idx);
                    int b = unionFind(links, idx + l + 1);
                    if (a == b) {
                        res++;
                    } else {
                        links[a] = b;
                    }
                }
                idx++;
            }
            idx++;
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
