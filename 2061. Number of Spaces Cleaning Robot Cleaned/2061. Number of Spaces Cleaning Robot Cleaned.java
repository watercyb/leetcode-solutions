/*
 * Problem: 2061. Number of Spaces Cleaning Robot Cleaned
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-spaces-cleaning-robot-cleaned/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int numberOfCleanRooms(int[][] room) {
        if ((room.length == 1 || room[1][0] == 1) && (room[0].length == 1 || room[0][1] == 1))
            return 1;
        int[][] directions = { {}, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] seens = new int[room.length][room[0].length];
        int x = 0;
        int y = 0;
        int direction = 1;
        int res = 0;
        while (seens[x][y] != direction) {
            if (seens[x][y] == 0)
                res++;
            seens[x][y] = direction;
            int xNext = x + directions[direction][0];
            int yNext = y + directions[direction][1];
            while (xNext < 0 || xNext == room.length || yNext < 0 || yNext == room[0].length
                    || room[xNext][yNext] == 1) {
                direction = direction % 4 + 1;
                xNext = x + directions[direction][0];
                yNext = y + directions[direction][1];
            }
            x = xNext;
            y = yNext;
        }
        return res;
    }
}
