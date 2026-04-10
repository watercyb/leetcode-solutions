/*
 * Problem: 909. Snakes and Ladders
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/snakes-and-ladders/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int n2 = 2 * n;
        int l = n * n;
        int[] arr = new int[l + 1];
        for (int i = 1; i < arr.length; i++) {
            int x = n - 1 - (i - 1) / n;
            int y = (i - 1) % n2;
            if (y >= n)
                y = n2 - y - 1;
            arr[i] = board[x][y];
        }
        Queue<Integer> Qu = new LinkedList<>();
        Qu.offer(1);
        boolean[] seens = new boolean[l + 1];
        seens[1] = true;
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int tmp = Qu.poll();
                for (int j = tmp + 1; j <= Math.min(tmp + 6, l); j++) {
                    if (seens[j])
                        continue;
                    seens[j] = true;
                    if (arr[j] == -1) {
                        if (j == l)
                            return stp;
                        Qu.offer(j);
                    } else {
                        if (arr[j] == l)
                            return stp;
                        Qu.offer(arr[j]);
                    }
                }
            }
            stp++;
        }
        return -1;
    }
}
