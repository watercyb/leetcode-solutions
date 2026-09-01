/*
 * Problem: 3568. Minimum Moves to Clean the Classroom
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/?envType=daily-question&envId=2026-09-01
 * Language: java
 * Date: 2026-09-01
 */

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int x = -1;
        int y = -1;
        char[][] chrs = new char[classroom.length][];
        for (int i = 0; i < chrs.length; i++) {
            chrs[i] = classroom[i].toCharArray();
        }
        int count = 0;
        int[][] arr = new int[chrs.length][chrs[0].length];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j < chrs[0].length; j++) {
                if (chrs[i][j] == 'S') {
                    x = i;
                    y = j;
                } else if (chrs[i][j] == 'L') {
                    arr[i][j] = idx++;
                    count++;
                }
            }
        }
        if (count == 0)
            return 0;
        int n = chrs[0].length;
        a = n * (1 << count);
        b = (1 << count);
        c = energy + 1;
        int[] energys = new int[chrs.length * n * (1 << count)];
        int target = (1 << count) - 1;
        Deque<Integer> Dq = new ArrayDeque<>();
        int h = getH(x, y, 0);
        Dq.offerLast(h * c + energy);
        energys[h] = energy;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int stp = 0;
        while (!Dq.isEmpty()) {
            int lim = Dq.size();
            for (int i = 0; i < lim; i++) {
                int[] pair = getPair(Dq.pollFirst());
                x = pair[0];
                y = pair[1];
                for (int[] direction : directions) {
                    int xNext = x + direction[0];
                    int yNext = y + direction[1];
                    if (xNext < 0 || xNext == chrs.length || yNext < 0 || yNext == chrs[0].length
                            || chrs[xNext][yNext] == 'X')
                        continue;
                    if (pair[3] == 0)
                        continue;
                    int eNext = pair[3] - 1;
                    int hNext = pair[2];
                    if (chrs[xNext][yNext] == 'R') {
                        eNext = energy;
                    } else if (chrs[xNext][yNext] == 'L') {
                        hNext = pair[2] | (1 << arr[xNext][yNext]);
                        if (hNext == target)
                            return stp + 1;
                    }
                    h = getH(xNext, yNext, hNext);
                    if (energys[h] < eNext) {
                        energys[h] = eNext;
                        Dq.offerLast(h * c + eNext);
                    }
                }
            }
            stp++;
        }
        return -1;
    }

    int a;
    int b;
    int c;

    public int getH(int x, int y, int l) {
        return x * a + y * b + l;
    }

    public int[] getPair(int h) {
        int[] res = new int[4];
        res[3] = h % c;
        h /= c;
        res[0] = h / a;
        h %= a;
        res[1] = h / b;
        res[2] = h % b;
        return res;
    }
}
