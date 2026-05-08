/*
 * Problem: 3529. Count Cells in Overlapping Horizontal and Vertical Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-cells-in-overlapping-horizontal-and-vertical-substrings/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int countCells(char[][] grid, String pattern) {
        char[] chrs = pattern.toCharArray();
        int[] LPS = getLPS(chrs);
        boolean[] has1 = new boolean[grid.length * grid[0].length];
        char[] arr1 = new char[grid.length * grid[0].length];
        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr1[idx++] = grid[i][j];
            }
        }
        idx = 0;
        int len = 0;
        while (idx < arr1.length) {
            if (arr1[idx] == chrs[len]) {
                if (++len == chrs.length) {
                    for (int i = idx; i > idx - chrs.length && !has1[i]; i--) {
                        has1[i] = true;
                    }
                    len = LPS[len - 1];
                }
                idx++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
        boolean[] has2 = new boolean[grid.length * grid[0].length];
        char[] arr2 = new char[grid.length * grid[0].length];
        idx = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                arr2[idx++] = grid[i][j];
            }
        }
        idx = 0;
        len = 0;
        while (idx < arr2.length) {
            if (arr2[idx] == chrs[len]) {
                if (++len == chrs.length) {
                    for (int i = idx; i > idx - chrs.length && !has2[i]; i--) {
                        has2[i] = true;
                    }
                    len = LPS[len - 1];
                }
                idx++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (has1[i * grid[0].length + j] && has2[j * grid.length + i])
                    res++;
            }
        }
        return res;
    }

    public int[] getLPS(char[] chrs) {
        int[] res = new int[chrs.length];
        int len = 0;
        int idx = 1;
        while (idx < chrs.length) {
            if (chrs[idx] == chrs[len]) {
                res[idx++] = ++len;
            } else {
                if (len != 0) {
                    len = res[len - 1];
                } else {
                    idx++;
                }
            }
        }
        return res;
    }
}
