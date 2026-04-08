/*
 * Problem: 711. Number of Distinct Islands II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-distinct-islands-ii/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int numDistinctIslands2(int[][] grid) {
        int[] links = new int[grid.length * grid[0].length / 2 + 3];
        for (int i = 2; i < links.length; i++) {
            links[i] = i;
        }
        int n = 2;
        HashMap<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder SB = new StringBuilder();
                    dfs(grid, SB, directions1, i, j, n);
                    String h = SB.toString();
                    if (HM.containsKey(h)) {
                        int idx = unionFind(links, HM.get(h));
                        links[unionFind(links, n)] = idx;
                    } else {
                        HM.put(h, unionFind(links, n));
                    }
                    n++;
                }
            }
        }
        int[][] seens = new int[grid.length][grid[0].length];
        for (int j = grid[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > 1 && seens[i][j] < 1) {
                    StringBuilder SB = new StringBuilder();
                    dfs(grid, seens, 1, SB, directions2, i, j);
                    String h = SB.toString();
                    if (HM.containsKey(h)) {
                        int a = unionFind(links, HM.get(h));
                        int b = unionFind(links, grid[i][j]);
                        if (a != b) {
                            links[b] = a;
                            HM.put(h, a);
                        }
                    } else {
                        HM.put(h, unionFind(links, grid[i][j]));
                    }
                }
            }
        }
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] > 1 && seens[i][j] < 2) {
                    StringBuilder SB = new StringBuilder();
                    dfs(grid, seens, 2, SB, directions3, i, j);
                    String h = SB.toString();
                    if (HM.containsKey(h)) {
                        int a = unionFind(links, HM.get(h));
                        int b = unionFind(links, grid[i][j]);
                        if (a != b) {
                            links[b] = a;
                            HM.put(h, a);
                        }
                    } else {
                        HM.put(h, unionFind(links, grid[i][j]));
                    }
                }
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = grid.length - 1; i >= 0; i--) {
                if (grid[i][j] > 1 && seens[i][j] < 3) {
                    StringBuilder SB = new StringBuilder();
                    dfs(grid, seens, 3, SB, directions4, i, j);
                    String h = SB.toString();
                    if (HM.containsKey(h)) {
                        int a = unionFind(links, HM.get(h));
                        int b = unionFind(links, grid[i][j]);
                        if (a != b) {
                            links[b] = a;
                            HM.put(h, a);
                        }
                    } else {
                        HM.put(h, unionFind(links, grid[i][j]));
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] > 1 && seens[i][j] < 4) {
                    StringBuilder SB = new StringBuilder();
                    dfs(grid, seens, 4, SB, directions5, i, j);
                    String h = SB.toString();
                    if (HM.containsKey(h)) {
                        int a = unionFind(links, HM.get(h));
                        int b = unionFind(links, grid[i][j]);
                        if (a != b) {
                            links[b] = a;
                            HM.put(h, a);
                        }
                    } else {
                        HM.put(h, unionFind(links, grid[i][j]));
                    }
                }
            }
        }
        /*
         * for (int j = grid[0].length - 1; j >= 0; j--) {
         * for (int i = grid.length - 1; i >= 0; i--) {
         * if (grid[i][j] > 1 && seens[i][j] < 5) {
         * StringBuilder SB = new StringBuilder();
         * dfs(grid, seens, 5, SB, directions6, i, j);
         * String h = SB.toString();
         * if (HM.containsKey(h)) {
         * int a = unionFind(links, HM.get(h));
         * int b = unionFind(links, grid[i][j]);
         * if (a != b) {
         * links[b] = a;
         * HM.put(h, a);
         * }
         * } else {
         * HM.put(h, unionFind(links, grid[i][j]));
         * }
         * }
         * }
         * }
         * for (int i = grid.length - 1; i >= 0; i--) {
         * for (int j = 0; j < grid[0].length; j++) {
         * if (grid[i][j] > 1 && seens[i][j] < 6) {
         * StringBuilder SB = new StringBuilder();
         * dfs(grid, seens, 6, SB, directions7, i, j);
         * String h = SB.toString();
         * if (HM.containsKey(h)) {
         * int a = unionFind(links, HM.get(h));
         * int b = unionFind(links, grid[i][j]);
         * if (a != b) {
         * links[b] = a;
         * HM.put(h, a);
         * }
         * } else {
         * HM.put(h, unionFind(links, grid[i][j]));
         * }
         * }
         * }
         * }
         * for (int j = 0; j < grid[0].length; j++) {
         * for (int i = 0; i < grid.length; i++) {
         * if (grid[i][j] > 1 && seens[i][j] < 7) {
         * StringBuilder SB = new StringBuilder();
         * dfs(grid, seens, 7, SB, directions8, i, j);
         * String h = SB.toString();
         * if (HM.containsKey(h)) {
         * int a = unionFind(links, HM.get(h));
         * int b = unionFind(links, grid[i][j]);
         * if (a != b) {
         * links[b] = a;
         * HM.put(h, a);
         * }
         * } else {
         * HM.put(h, unionFind(links, grid[i][j]));
         * }
         * }
         * }
         * }
         */
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (links[i] == i)
                res++;
        }
        return res;
    }

    int[][] directions1 = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
    int[][] directions2 = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    int[][] directions3 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int[][] directions4 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int[][] directions5 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int[][] directions6 = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
    int[][] directions7 = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    int[][] directions8 = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

    public void dfs(int[][] grid, StringBuilder SB, int[][] directions, int i, int j, int n) {
        grid[i][j] = n;
        SB.append('#');
        for (int k = 0; k < directions.length; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                SB.append(k);
                dfs(grid, SB, directions, x, y, n);
            }
        }
        SB.append('#');
    }

    public void dfs(int[][] grid, int[][] seens, int target, StringBuilder SB, int[][] directions, int i, int j) {
        seens[i][j] = target;
        SB.append('#');
        for (int k = 0; k < directions.length; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0 && seens[x][y] != target) {
                SB.append(k);
                dfs(grid, seens, target, SB, directions, x, y);
            }
        }
        SB.append('#');
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
