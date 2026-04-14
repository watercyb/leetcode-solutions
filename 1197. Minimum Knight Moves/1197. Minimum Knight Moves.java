/*
 * Problem: 1197. Minimum Knight Moves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-knight-moves/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    int[][] moves = { { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

    public int minKnightMoves(int x, int y) {
        x += 330;
        y += 330;
        Queue<int[]> Qu = new LinkedList<>();
        boolean[] seens = new boolean[660 * 660];
        Qu.offer(new int[] { 330, 330 });
        seens[330 * 660 + 330] = true;
        int stp = 0;
        while (!Qu.isEmpty()) {
            int l = Qu.size();
            for (int i = 0; i < l; i++) {
                int[] currentStp = Qu.poll();
                if (currentStp[0] == x && currentStp[1] == y)
                    return stp;
                for (int[] move : moves) {
                    int[] nextStp = new int[] { currentStp[0] + move[0], currentStp[1] + move[1] };
                    if (!seens[nextStp[0] * 660 + nextStp[1]]) {
                        seens[nextStp[0] * 660 + nextStp[1]] = true;
                        Qu.offer(nextStp);
                    }
                }
            }
            stp++;
        }
        return -1;
    }
}
