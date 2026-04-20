/*
 * Problem: 1728. Cat and Mouse II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cat-and-mouse-ii/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        char[][] grids = new char[grid.length][];
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0, xF = 0, yF = 0;
        for (int i = 0; i < grids.length; i++) {
            grids[i] = grid[i].toCharArray();
        }
        counts = new int[grids.length][grids[0].length][grids.length][grids[0].length];
        seens = new boolean[grids.length][grids[0].length][grids.length][grids[0].length];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == '#')
                    continue;
                for (int k = 0; k < grids.length; k++) {
                    for (int l = 0; l < grids[0].length; l++) {
                        if (grids[k][l] == '#')
                            continue;
                        counts[i][j][k][l] = countTotal(grids, i, j, k, l, catJump);
                    }
                }
                if (grids[i][j] == 'M') {
                    x2 = i;
                    y2 = j;
                } else if (grids[i][j] == 'C') {
                    x1 = i;
                    y1 = j;
                } else if (grids[i][j] == 'F') {
                    xF = i;
                    yF = j;
                }
            }
        }
        Dq = new int[grids.length * grids[0].length * grids.length * grids[0].length][];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == '#')
                    continue;
                Dq[r++] = new int[] { i, j, xF, yF };
            }
        }
        int stp = 0;
        while (l < r && stp < 1000) {
            int size = r;
            while (l < size) {
                int[] arr = Dq[l++];
                if (arr[0] == x1 && arr[1] == y1 && arr[2] == x2 && arr[3] == y2)
                    return true;
                if (!seens[arr[0]][arr[1]][arr[2]][arr[3]]) {
                    seens[arr[0]][arr[1]][arr[2]][arr[3]] = true;
                    count(grids, arr[0], arr[1], arr[2], arr[3], catJump);
                }
                for (int[] direction : directions) {
                    int x2Next = arr[2];
                    int y2Next = arr[3];
                    for (int j = 0; j < mouseJump; j++) {
                        x2Next += direction[0];
                        y2Next += direction[1];
                        if (arr[0] == x1 && arr[1] == y1 && x2Next == x2 && y2Next == y2)
                            return true;
                        if (x2Next < 0 || x2Next == grids.length || y2Next < 0 || y2Next == grids[0].length
                                || grids[x2Next][y2Next] == '#')
                            break;
                        if (!seens[arr[0]][arr[1]][x2Next][y2Next]) {
                            seens[arr[0]][arr[1]][x2Next][y2Next] = true;
                            count(grids, arr[0], arr[1], x2Next, y2Next, catJump);
                        }
                    }
                }
            }
            stp++;
        }
        return false;
    }

    int[][][][] counts;
    boolean[][][][] seens;
    int[][] Dq;
    int l = 0;
    int r = 0;

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int countTotal(char[][] grids, int x1, int y1, int x2, int y2, int jump) {
        if (x1 == x2 && y1 == y2)
            return Integer.MAX_VALUE;
        int res = 1;
        for (int[] direction : directions) {
            int x1Next = x1;
            int y1Next = y1;
            for (int i = 0; i < jump; i++) {
                x1Next += direction[0];
                y1Next += direction[1];
                if (x1Next < 0 || x1Next == grids.length || y1Next < 0 || y1Next == grids[0].length
                        || grids[x1Next][y1Next] == '#')
                    break;
                if (x1Next == x2 && y1Next == y2 || grids[x1Next][y1Next] == 'F')
                    return Integer.MAX_VALUE;
                res++;
            }
        }
        return res;
    }

    public void count(char[][] grids, int x1, int y1, int x2, int y2, int jump) {
        if (counts[x1][y1][x2][y2]-- == 1)
            Dq[r++] = new int[] { x1, y1, x2, y2 };
        for (int[] direction : directions) {
            int x1Next = x1;
            int y1Next = y1;
            for (int i = 0; i < jump; i++) {
                x1Next += direction[0];
                y1Next += direction[1];
                if (x1Next < 0 || x1Next == grids.length || y1Next < 0 || y1Next == grids[0].length
                        || grids[x1Next][y1Next] == '#')
                    break;
                if (counts[x1Next][y1Next][x2][y2]-- == 1)
                    Dq[r++] = new int[] { x1Next, y1Next, x2, y2 };
            }
        }
    }
}
