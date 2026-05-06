/*
 * Problem: 3385. Minimum Time to Break Locks II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-break-locks-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int findMinimumTime(int[] strength) {
        int[][] arr = new int[strength.length][strength.length];
        int[][] arr1 = new int[strength.length][strength.length];
        boolean[] cols = new boolean[strength.length];
        for (int i = 0; i < arr.length; i++) {
            int x = i + 1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = (strength[j] + x - 1) / x;
                min = Math.min(min, arr[i][j]);
            }
            for (int j = 0; j < arr[0].length; j++) {
                arr1[i][j] = arr[i][j] - min;
                if (arr[i][j] == min && !cols[j]) {
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < strength.length; i++) {
            if (!cols[i]) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < arr.length; j++) {
                    min = Math.min(min, arr1[j][i]);
                }
                for (int j = 0; j < arr.length; j++) {
                    arr1[j][i] = arr1[j][i] - min;
                }
            }
        }
        return dfs(arr, arr1);
    }

    public int dfs(int[][] arr, int[][] arr1) {
        Result result = findMinCover(arr1);
        int count = result.minCoverCount;
        boolean[] usedRows = result.coverRows;
        boolean[] usedCols = result.coverCols;
        if (count == arr.length)
            return getRes(arr, arr1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (usedRows[i])
                continue;
            for (int j = 0; j < arr[0].length; j++) {
                if (usedCols[j])
                    continue;
                min = Math.min(min, arr1[i][j]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!usedRows[i]) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr1[i][j] -= min;
                }
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            if (usedCols[i]) {
                for (int j = 0; j < arr.length; j++) {
                    arr1[j][i] += min;
                }
            }
        }
        return dfs(arr, arr1);
    }

    public int getRes(int[][] arr, int[][] arr1) {
        return dfsRes(arr, arr1, new boolean[arr1[0].length], 0, 0);
    }

    public int dfsRes(int[][] arr, int[][] arr1, boolean[] cols, int i, int sum) {
        if (i == arr.length)
            return sum;
        for (int j = 0; j < arr1[0].length; j++) {
            if (!cols[j] && arr1[i][j] == 0) {
                cols[j] = true;
                int res = dfsRes(arr, arr1, cols, i + 1, sum + arr[i][j]);
                if (res > 0)
                    return res;
                cols[j] = false;
            }
        }
        return -1;
    }

    public Result findMinCover(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Build bipartite graph: edges[i] = list of columns j where matrix[i][j] == 0
        List<Integer>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    edges[i].add(j);
            }
        }

        // Kuhn's algorithm for maximum matching
        int[] matchToCol = new int[n]; // row → column
        int[] matchToRow = new int[m]; // column → row
        Arrays.fill(matchToCol, -1);
        Arrays.fill(matchToRow, -1);

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[m];
            dfsMatch(i, edges, visited, matchToCol, matchToRow);
        }

        // Step 2: find unmatched rows and perform BFS for alternating paths
        boolean[] visitedRows = new boolean[n];
        boolean[] visitedCols = new boolean[m];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (matchToCol[i] == -1) { // unmatched row
                queue.add(i);
                visitedRows[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.poll();
            for (int col : edges[row]) {
                if (visitedCols[col])
                    continue;
                if (matchToCol[row] != col) { // unmatched edge
                    visitedCols[col] = true;
                    int matchedRow = matchToRow[col];
                    if (matchedRow != -1 && !visitedRows[matchedRow]) {
                        visitedRows[matchedRow] = true;
                        queue.add(matchedRow);
                    }
                }
            }
        }

        // Step 3: construct minimum vertex cover
        boolean[] coverRows = new boolean[n];
        boolean[] coverCols = new boolean[m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            coverRows[i] = !visitedRows[i];
            if (coverRows[i])
                count++;
        }
        for (int j = 0; j < m; j++) {
            coverCols[j] = visitedCols[j];
            if (coverCols[j])
                count++;
        }

        Result res = new Result();
        res.minCoverCount = count;
        res.coverRows = coverRows;
        res.coverCols = coverCols;
        return res;
    }

    // Kuhn DFS to find augmenting path
    private boolean dfsMatch(int row, List<Integer>[] edges, boolean[] visited,
            int[] matchToCol, int[] matchToRow) {
        for (int col : edges[row]) {
            if (visited[col])
                continue;
            visited[col] = true;
            if (matchToRow[col] == -1 || dfsMatch(matchToRow[col], edges, visited, matchToCol, matchToRow)) {
                matchToCol[row] = col;
                matchToRow[col] = row;
                return true;
            }
        }
        return false;
    }

    // DFS for alternating paths (used in König’s theorem)
    private void dfsAlt(int row, List<Integer>[] edges, boolean[] visitedRows, boolean[] visitedCols,
            int[] matchToCol, int[] matchToRow) {
        visitedRows[row] = true;
        for (int col : edges[row]) {
            if (visitedCols[col])
                continue;
            if (matchToCol[row] != col) { // unmatched edge
                visitedCols[col] = true;
                if (matchToRow[col] != -1) {
                    dfsAlt(matchToRow[col], edges, visitedRows, visitedCols, matchToCol, matchToRow);
                }
            }
        }
    }
}

class Result {
    int minCoverCount;
    boolean[] coverRows;
    boolean[] coverCols;
}
