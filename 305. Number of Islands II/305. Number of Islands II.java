/*
 * Problem: 305. Number of Islands II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-islands-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] islands = new int[m][n];
        int[] Links = new int[positions.length + 1];
        for (int i = 0; i < Links.length; i++) {
            Links[i] = i;
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int idx = 1;
        for (int[] position : positions) {
            if (islands[position[0]][position[1]] == 0)
                count += chk(islands, Links, position[0], position[1], idx++);
            res.add(count);
        }
        return res;
    }

    public int chk(int[][] islands, int[] Links, int i, int j, int n) {
        int res = 1;
        islands[i][j] = n;
        if (i > 0) {
            if (islands[i - 1][j] != 0) {
                Links[unionFind(Links, islands[i - 1][j])] = n;
                res--;
            }
        }
        if (i < islands.length - 1) {
            if (islands[i + 1][j] != 0) {
                if (unionFind(Links, islands[i + 1][j]) != n) {
                    Links[unionFind(Links, islands[i + 1][j])] = n;
                    res--;
                }
            }
        }
        if (j > 0) {
            if (islands[i][j - 1] != 0) {
                if (unionFind(Links, islands[i][j - 1]) != n) {
                    Links[unionFind(Links, islands[i][j - 1])] = n;
                    res--;
                }
            }
        }
        if (j < islands[0].length - 1) {
            if (islands[i][j + 1] != 0) {
                if (unionFind(Links, islands[i][j + 1]) != n) {
                    Links[unionFind(Links, islands[i][j + 1])] = n;
                    res--;
                }
            }
        }
        return res;
    }

    public int unionFind(int[] Links, int i) {
        if (Links[i] != i)
            Links[i] = unionFind(Links, Links[i]);
        return Links[i];
    }
}
