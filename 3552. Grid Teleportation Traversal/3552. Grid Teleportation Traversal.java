/*
 * Problem: 3552. Grid Teleportation Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/grid-teleportation-traversal/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minMoves(String[] matrix) {
        int[][] grid = new int[matrix.length][matrix[0].length()];
        boolean[][] seens = new boolean[grid.length][grid[0].length];
        List<int[]>[] lists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char chr = matrix[i].charAt(j);
                if (Character.isLetter(chr)) {
                    grid[i][j] = chr - 'A';
                    lists[chr - 'A'].add(new int[] { i, j });
                } else if (chr == '#') {
                    grid[i][j] = -1;
                } else {
                    grid[i][j] = 26;
                }
            }
        }
        int[] arr = new int[grid.length * grid[0].length];
        int l = 0;
        int r = 0;
        int n = grid[0].length;
        if (grid[grid.length - 1][grid[0].length - 1] == -1)
            return -1;
        if (grid[grid.length - 1][grid[0].length - 1] < 26) {
            for (int[] pair : lists[grid[grid.length - 1][grid[0].length - 1]]) {
                arr[r++] = pair[0] * n + pair[1];
                seens[pair[0]][pair[1]] = true;
            }
        } else {
            arr[r++] = grid.length * grid[0].length - 1;
            seens[grid.length - 1][grid[0].length - 1] = true;
        }
        int stp = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int current = arr[l++];
                int x = current / n;
                int y = current % n;
                if (x == 0 && y == 0)
                    return stp;
                if (x > 0 && grid[x - 1][y] != -1 && !seens[x - 1][y]) {
                    arr[r++] = (x - 1) * n + y;
                    seens[x - 1][y] = true;
                    if (grid[x - 1][y] < 26) {
                        for (int[] pair : lists[grid[x - 1][y]]) {
                            if (!seens[pair[0]][pair[1]]) {
                                arr[r++] = pair[0] * n + pair[1];
                                seens[pair[0]][pair[1]] = true;
                            }
                        }
                    }
                }
                if (x < grid.length - 1 && grid[x + 1][y] != -1 && !seens[x + 1][y]) {
                    arr[r++] = (x + 1) * n + y;
                    seens[x + 1][y] = true;
                    if (grid[x + 1][y] < 26) {
                        for (int[] pair : lists[grid[x + 1][y]]) {
                            if (!seens[pair[0]][pair[1]]) {
                                arr[r++] = pair[0] * n + pair[1];
                                seens[pair[0]][pair[1]] = true;
                            }
                        }
                    }
                }
                if (y > 0 && grid[x][y - 1] != -1 && !seens[x][y - 1]) {
                    arr[r++] = x * n + y - 1;
                    seens[x][y - 1] = true;
                    if (grid[x][y - 1] < 26) {
                        for (int[] pair : lists[grid[x][y - 1]]) {
                            if (!seens[pair[0]][pair[1]]) {
                                arr[r++] = pair[0] * n + pair[1];
                                seens[pair[0]][pair[1]] = true;
                            }
                        }
                    }
                }
                if (y < grid[0].length - 1 && grid[x][y + 1] != -1 && !seens[x][y + 1]) {
                    arr[r++] = x * n + y + 1;
                    seens[x][y + 1] = true;
                    if (grid[x][y + 1] < 26) {
                        for (int[] pair : lists[grid[x][y + 1]]) {
                            if (!seens[pair[0]][pair[1]]) {
                                arr[r++] = pair[0] * n + pair[1];
                                seens[pair[0]][pair[1]] = true;
                            }
                        }
                    }
                }
            }
            stp++;
        }
        return -1;
    }
}
