/*
 * Problem: 3534. Path Existence Queries in a Graph II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arrSort = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrSort[i][0] = nums[i];
            arrSort[i][1] = i;
        }
        Arrays.sort(arrSort, (a, b) -> a[0] - b[0]);
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[arrSort[i][1]] = i;
        }
        int[] groups = new int[n];
        int count = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (arrSort[i][0] - arrSort[i - 1][0] <= maxDiff) {
                groups[i] = groups[i - 1];
                if (++count > max)
                    max = count;
            } else {
                groups[i] = groups[i - 1] + 1;
                count = 1;
            }
        }
        int len = (int) (Math.log(max) / Math.log(2)) + 1;
        int[][] BLT = new int[len][n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && arrSort[r][0] - arrSort[i][0] <= maxDiff) {
                r++;
            }
            BLT[0][i] = r - 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < n; j++) {
                BLT[i][j] = BLT[i - 1][BLT[i - 1][j]];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = indexes[queries[i][0]];
            int b = indexes[queries[i][1]];
            if (a == b) {
                res[i] = 0;
            } else if (groups[a] != groups[b]) {
                res[i] = -1;
            } else {
                res[i] = getStp(BLT, a, b);
            }
        }
        return res;
    }

    public int getStp(int[][] BLT, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int res = 0;
        for (int j = BLT.length - 1; j >= 0 && a < b; j--) {
            if (BLT[j][a] < b) {
                a = BLT[j][a];
                res += 1 << j;
            }
        }
        if (a < b)
            res++;
        return res;
    }
}
