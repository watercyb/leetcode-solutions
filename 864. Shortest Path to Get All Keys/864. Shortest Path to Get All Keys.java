/*
 * Problem: 864. Shortest Path to Get All Keys
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-path-to-get-all-keys/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int x = 0;
        int y = 0;
        char[][] chrs = new char[grid.length + 2][grid[0].length() + 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < chrs[0].length - 2; j++) {
                char chr = grid[i].charAt(j);
                chrs[i + 1][j + 1] = chr;
                if (Character.isUpperCase(chr)) {
                    n++;
                } else if (chr == '@') {
                    x = i + 1;
                    y = j + 1;
                }
                chrs[i + 1][0] = chrs[i + 1][chrs[0].length - 1] = '#';
            }
        }
        Arrays.fill(chrs[0], '#');
        Arrays.fill(chrs[chrs.length - 1], '#');
        boolean[] steps = new boolean[chrs.length << (5 + n)];
        int[] arr = new int[chrs.length * chrs[0].length * (1 << n)];
        int l = 0;
        int r = 1;
        arr[0] = getH(x, y, 0);
        steps[arr[0]] = true;
        target = (1 << n) - 1;
        int stp = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int[] current = getPair(arr[l++]);
                for (int[] direction : directions) {
                    int xNext = current[0] + direction[0];
                    int yNext = current[1] + direction[1];
                    int hNext = chk(chrs, steps, xNext, yNext, current[2]);
                    if (hNext == target)
                        return stp + 1;
                    if (hNext >= 0)
                        arr[r++] = hNext;
                }
            }
            stp++;
        }
        return -1;
    }

    int n = 0;
    int target = 0;

    public int getH(int x, int y, int k) {
        return (((x << 5) + y) << n) + k;
    }

    public int[] getPair(int h) {
        int[] res = new int[3];
        res[0] = h / (1 << (5 + n));
        h %= 1 << (5 + n);
        res[1] = h / (1 << n);
        res[2] = h % (1 << n);
        return res;
    }

    public int chk(char[][] chrs, boolean[] steps, int i, int j, int k) {
        if (chrs[i][j] == '#' || (Character.isUpperCase(chrs[i][j]) && ((1 << (chrs[i][j] - 'A') & k) == 0)))
            return -1;
        if (Character.isLowerCase(chrs[i][j])) {
            k = k | (1 << (chrs[i][j] - 'A'));
            if (k == target)
                return target;
        }
        int h = getH(i, j, k);
        if (!steps[h]) {
            steps[h] = true;
            return h;
        }
        return -1;
    }
}
