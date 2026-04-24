/*
 * Problem: 2184. Number of Ways to Build Sturdy Brick Wall
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-build-sturdy-brick-wall/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        boolean[] has = new boolean[1 << (width - 1)];
        boolean[] seens = new boolean[11];
        for (int brick : bricks) {
            seens[brick] = true;
        }
        int count = 0;
        for (int i = 0; i < has.length; i++) {
            if (chk(seens, i, width)) {
                has[i] = true;
                count++;
            }
        }
        int[] arr = new int[count];
        int idx = 0;
        List<Integer>[] lists = new ArrayList[arr.length];
        for (int i = 0; i < has.length; i++) {
            if (has[i]) {
                arr[idx] = i;
                lists[idx++] = new ArrayList<>();
            }
        }
        long[][] meme = new long[arr.length][height];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                lists[i].add(i);
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    lists[i].add(j);
                    lists[j].add(i);
                }
            }
            Arrays.fill(meme[i], -1);
        }
        int[][] links = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += dfs(links, meme, i, height - 1);
        }
        return (int) (res % mod);
    }

    int mod = 1_000_000_007;

    public long dfs(int[][] links, long[][] meme, int i, int n) {
        if (n == 0)
            return 1;
        if (meme[i][n] != -1)
            return meme[i][n];
        long res = 0;
        for (int next : links[i]) {
            res += dfs(links, meme, next, n - 1);
        }
        return meme[i][n] = res % mod;
    }

    public boolean chk(boolean[] seens, int h, int width) {
        int l = 1;
        for (int i = 1; i < width; i++) {
            if (h % 2 == 1) {
                if (!seens[l])
                    return false;
                l = 1;
            } else {
                l++;
            }
            h /= 2;
        }
        return seens[l];
    }
}
