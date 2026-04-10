/*
 * Problem: 934. Shortest Bridge
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-bridge/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;
    public int shortestBridge(int[][] grid) {
        int res = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        int flag = 1;
        for(int i = 0; i < m && flag == 1; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                    continue;
                int curr = j + i * n;
                dfs(grid, i, j, dq);
                flag = 0;
                break;
            }
        }
        while(!dq.isEmpty()){
            int size = dq.size();
            res++;
            for(int i = 0; i < size; i++){
                int[] curr = dq.pollFirst();
                int currI = curr[0], currJ = curr[1];
                for(int[] dir : dirs){
                    int nextI = currI + dir[0], nextJ = currJ + dir[1];
                    if(nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n)
                        continue;
                    if(grid[nextI][nextJ] == 2)
                        continue;
                    if(grid[nextI][nextJ] == 1)
                        return res;
                    dq.addLast(new int[]{nextI, nextJ});
                    grid[nextI][nextJ] = 2;
                }
            }
        }
        // for(int[] gr : grid){
        //     for(int g : gr){
        //         System.out.print(g + ", ");
        //     }
        //     System.out.println();
        // }
        return -1;
    }
    public void dfs(int[][] grid, int i, int j, Deque<int[]> dq){
        if(grid[i][j] == 2)
            return;
        if(grid[i][j] == 0){
            dq.addLast(new int[]{i, j});
            grid[i][j] = 2;
            return;
        }
        grid[i][j] = 2;
        for(int[] dir : dirs){
            int nextI = i + dir[0], nextJ = j + dir[1];
            if(nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n)
                continue;
            dfs(grid, nextI, nextJ, dq);
        }

    }
}
