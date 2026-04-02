/*
 * Problem: 3888. Minimum Operations to Make All Grid Elements Equal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-all-grid-elements-equal/
 * Language: java
 * Date: 2026-04-02
 */

class Solution {
    public long minOperations(int[][] grid, int k) {
        Sum[] sums = new Sum[grid[0].length];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = new Sum(grid.length, k);
        }
        long res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            Sum sum = new Sum(grid[0].length, k);
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += sums[j].sum + sum.sum;
                if (i % k == 0 && j % k == 0) {
                    sums[j].next(sum.sum);
                    sum.next(0);
                } else {
                    int target = 0;
                    if (i % k == 0) {
                        target = grid[i][j - 1];
                    } else {
                        target = grid[i - 1][j];
                    }
                    if (grid[i][j] == target) {
                        sums[j].next(sum.sum);
                        sum.next(0);
                    } else if (i + k <= grid.length && j + k <= grid[0].length && grid[i][j] < target) {
                        int num = target - grid[i][j];
                        sums[j].next(num + sum.sum);
                        sum.next(num);
                        grid[i][j] = target;
                        res += num;
                    } else {
                        return -1;
                    }
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        for (int i = 0; i < grid.length; i += k) {
            for (int j = 0; j < grid[0].length; j += k) {
                if (grid[i][j] != max) {
                    if (i + k <= grid.length && j + k <= grid[0].length) {
                        res += max - grid[i][j];
                    } else {
                        return -1;
                    }
                }
            }
        }
        return res;
    }
}

class Sum {
    int[] arr;
    int l = 0;
    int r = 0;
    int sum = 0;
    int k;

    public Sum(int n, int k) {
        arr = new int[n];
        this.k = k;
    }

    public void next(int num) {
        sum += num;
        arr[r++] = num;
        if (r - l == k)
            sum -= arr[l++];
    }
}
