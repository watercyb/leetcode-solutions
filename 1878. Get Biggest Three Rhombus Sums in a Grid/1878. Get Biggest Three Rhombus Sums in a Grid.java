/*
 * Problem: 1878. Get Biggest Three Rhombus Sums in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int lim = Math.min(grid.length, grid[0].length) / 2;
        for (int i = 0; i <= lim; i++) {
            int d = 2 * i + 1;
            for (int j = 0; j <= grid.length - d; j++) {
                for (int k = i; k < grid[0].length - i; k++) {
                    if (i == 0) {
                        insert(grid[j][k]);
                    } else {
                        int sum = 0;
                        int x = j;
                        int y = k;
                        for (int l = 0; l < i; l++) {
                            sum += grid[x][y];
                            x++;
                            y++;
                        }
                        for (int l = 0; l < i; l++) {
                            sum += grid[x][y];
                            x++;
                            y--;
                        }
                        for (int l = 0; l < i; l++) {
                            sum += grid[x][y];
                            x--;
                            y--;
                        }
                        for (int l = 0; l < i; l++) {
                            sum += grid[x][y];
                            x--;
                            y++;
                        }
                        insert(sum);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 3 && max[i] != 0; i++) {
            count++;
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = max[i];
        }
        return res;
    }

    int[] max = { 0, 0, 0 };

    public void insert(int sum) {
        if (sum == max[0] || sum == max[1] || sum == max[2])
            return;
        if (sum > max[0]) {
            max[2] = max[1];
            max[1] = max[0];
            max[0] = sum;
        } else if (sum > max[1]) {
            max[2] = max[1];
            max[1] = sum;
        } else if (sum > max[2]) {
            max[2] = sum;
        }
    }
}
