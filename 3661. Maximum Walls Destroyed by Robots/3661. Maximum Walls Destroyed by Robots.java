/*
 * Problem: 3661. Maximum Walls Destroyed by Robots
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-walls-destroyed-by-robots/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        if (robots.length == 1) {
            int a = 0;
            int b = 0;
            for (int wall : walls) {
                if (wall < robots[0] - distance[0] || wall > robots[0] + distance[0])
                    continue;
                if (wall < robots[0]) {
                    a++;
                } else if (wall > robots[0]) {
                    b++;
                } else {
                    a++;
                    b++;
                }
            }
            return Math.max(a, b);
        }
        int[][] arr = new int[robots.length][];
        for (int i = 0; i < robots.length; i++) {
            arr[i] = new int[] { robots[i], distance[i] };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);
        int a = 0;
        int b = 0;
        int idx = 0;
        while (idx < walls.length && walls[idx] < arr[0][0] - arr[0][1]) {
            idx++;
        }
        while (idx < walls.length && walls[idx] < arr[0][0]) {
            a++;
            idx++;
        }
        if (idx < walls.length && walls[idx] == arr[0][0])
            a++;
        while (idx < walls.length && walls[idx] < Math.min(arr[0][0] + arr[0][1] + 1, arr[1][0])) {
            b++;
            idx++;
        }
        for (int j = 1; j < arr.length; j++) {
            int l1 = 0;
            int k = idx;
            while (k < walls.length && walls[k] < arr[j][0] - arr[j][1]) {
                k++;
            }
            while (k < walls.length && walls[k] < arr[j][0]) {
                l1++;
                k++;
            }
            if (k < walls.length && walls[k] <= arr[j][0])
                l1++;
            int next_idx = k;
            int l2 = l1;
            k = idx - 1;
            idx = next_idx;
            while (k >= 0 && walls[k] > arr[j - 1][0] && walls[k] >= arr[j][0] - arr[j][1]) {
                l2++;
                k--;
            }
            int aNext = Math.max(a + l2, b + l1);
            int r = 0;
            int lim = j < arr.length - 1 ? Math.min(arr[j + 1][0], arr[j][0] + arr[j][1] + 1)
                    : arr[j][0] + arr[j][1] + 1;
            while (idx < walls.length && walls[idx] < lim) {
                r++;
                idx++;
            }
            int bNext = Math.max(a, b) + r;
            a = aNext;
            b = bNext;
        }
        return Math.max(a, b);
    }
}
