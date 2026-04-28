/*
 * Problem: 2536. Increment Submatrices by One
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/increment-submatrices-by-one/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n + 1][n + 1];
        for (int[] query : queries) {
            arr[query[0]][query[1]]++;
            arr[query[0]][query[3] + 1]--;
            arr[query[2] + 1][query[1]]--;
            arr[query[2] + 1][query[3] + 1]++;
        }
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
                arr[i + 1][j] += arr[i][j];
                res[i][j] = sum;
            }
        }
        return res;
    }
}
