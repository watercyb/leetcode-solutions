/*
 * Problem: 2463. Minimum Total Distance Traveled
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-total-distance-traveled/?envType=daily-question&envId=2026-04-14
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int[] arr = new int[robot.size()];
        for (int i = 0; i < robot.size(); i++) {
            arr[i] = robot.get(i);
        }
        Arrays.sort(arr);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        return dfs(arr, new long[arr.length][factory.length], factory, 0, 0) - 1;
    }

    public long dfs(int[] arr, long[][] meme, int[][] factory, int i, int j) {
        if (i == arr.length) {
            return 1;
        }
        if (meme[i][j] != 0)
            return meme[i][j];
        int k = i;
        if (j == factory.length - 1) {
            if (arr.length - k <= factory[j][1]) {
                long res = 1;
                while (k < arr.length) {
                    res += Math.abs(factory[j][0] - arr[k]);
                    k++;
                }
                return meme[i][j] = res;
            }
            return meme[i][j] = Long.MAX_VALUE / 2;
        }
        int count = factory[j][1];
        long res = 0;
        long sum = 0;
        while (k < arr.length && count > 0
                && (arr[k] <= factory[j][0] || arr[k] - factory[j][0] <= factory[j + 1][0] - arr[k])) {
            sum += Math.abs(factory[j][0] - arr[k]);
            count--;
            k++;
        }
        res = dfs(arr, meme, factory, k, j + 1) + sum;
        while (k < arr.length && count > 0) {
            sum += Math.abs(arr[k] - factory[j][0]);
            count--;
            k++;
            res = Math.min(dfs(arr, meme, factory, k, j + 1) + sum, res);
        }
        return meme[i][j] = res;
    }
}
