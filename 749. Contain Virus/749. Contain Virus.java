/*
 * Problem: 749. Contain Virus
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/contain-virus/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int containVirus(int[][] isInfected) {
        int x = -1;
        int y = -1;
        int max = 0;
        int countWall = 0;
        int[][] seens = new int[isInfected.length][isInfected[0].length];
        int n = 1;
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                if (isInfected[i][j] == 1) {
                    count = 0;
                    int countInf = dfs(isInfected, seens, i, j, n);
                    if (countInf > max) {
                        max = countInf;
                        countWall = count;
                        x = i;
                        y = j;
                    }
                    n++;
                }
            }
        }
        if (countWall == 0)
            return 0;
        dfs(isInfected, x, y);
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                if (isInfected[i][j] == 1 && seens[i][j] != 0) {
                    dfsInfect(isInfected, seens, i, j);
                }
            }
        }
        //for (int[] row : isInfected) {
            //System.out.println(Arrays.toString(row));
        //}
        //System.out.println(max + " " + countWall);
        return containVirus(isInfected) + countWall;
    }

    public void dfsInfect(int[][] isInfected, int[][] seens, int i, int j) {
        seens[i][j] = 0;
        if (i > 0 && seens[i - 1][j] != 0) {
            if (isInfected[i - 1][j] == 1) {
                dfsInfect(isInfected, seens, i - 1, j);
            } else if (isInfected[i - 1][j] == 0) {
                isInfected[i - 1][j] = 1;
                seens[i - 1][j] = 0;
            }
        }
        if (i < isInfected.length - 1 && seens[i + 1][j] != 0) {
            if (isInfected[i + 1][j] == 1) {
                dfsInfect(isInfected, seens, i + 1, j);
            } else if (isInfected[i + 1][j] == 0) {
                isInfected[i + 1][j] = 1;
                seens[i + 1][j] = 0;
            }
        }
        if (j > 0 && seens[i][j - 1] != 0) {
            if (isInfected[i][j - 1] == 1) {
                dfsInfect(isInfected, seens, i, j - 1);
            } else if (isInfected[i][j - 1] == 0) {
                isInfected[i][j - 1] = 1;
                seens[i][j - 1] = 0;
            }
        }
        if (j < isInfected[0].length - 1 && seens[i][j + 1] != 0) {
            if (isInfected[i][j + 1] == 1) {
                dfsInfect(isInfected, seens, i, j + 1);
            } else if (isInfected[i][j + 1] == 0) {
                isInfected[i][j + 1] = 1;
                seens[i][j + 1] = 0;
            }
        }
    }

    public void dfs(int[][] isInfected, int i, int j) {
        isInfected[i][j] = -1;
        if (i > 0 && isInfected[i - 1][j] == 1) {
            dfs(isInfected, i - 1, j);
        }
        if (i < isInfected.length - 1 && isInfected[i + 1][j] == 1) {
            dfs(isInfected, i + 1, j);
        }
        if (j > 0 && isInfected[i][j - 1] == 1) {
            dfs(isInfected, i, j - 1);
        }
        if (j < isInfected[0].length - 1 && isInfected[i][j + 1] == 1) {
            dfs(isInfected, i, j + 1);
        }
    }

    int count = 0;

    public int dfs(int[][] isInfected, int[][] seens, int i, int j, int n) {
        if (isInfected[i][j] == 0) {
            count++;
            if (seens[i][j] != n) {
                seens[i][j] = n;
                return 1;
            }
            return 0;
        } else if (seens[i][j] == 0) {
            seens[i][j] = n;
            int res = 0;
            if (i > 0 && isInfected[i - 1][j] >= 0) {
                res += dfs(isInfected, seens, i - 1, j, n);
            }
            if (i < isInfected.length - 1 && isInfected[i + 1][j] >= 0) {
                res += dfs(isInfected, seens, i + 1, j, n);
            }
            if (j > 0 && isInfected[i][j - 1] >= 0) {
                res += dfs(isInfected, seens, i, j - 1, n);
            }
            if (j < isInfected[0].length - 1 && isInfected[i][j + 1] >= 0) {
                res += dfs(isInfected, seens, i, j + 1, n);
            }
            return res;
        }
        return 0;
    }
}
