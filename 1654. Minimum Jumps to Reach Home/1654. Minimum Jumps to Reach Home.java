/*
 * Problem: 1654. Minimum Jumps to Reach Home
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-jumps-to-reach-home/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int offset = 4000;
        int[] arr = new int[2001 + offset];
        for (int i = 0; i < forbidden.length; i++) {
            arr[forbidden[i]] = 2;
        }
        int[] Qu = new int[2001 + offset];
        Qu[0] = 0;
        arr[0] = 2;
        int l = 0;
        int r = 1;
        int stp = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int current = Qu[l++];
                if (current == x)
                    return stp;
                if (arr[current] == 3)
                    continue;
                if (arr[current] == 2 && current - b >= 0 && arr[current - b] == 0) {
                    arr[current - b] = 1;
                    Qu[r++] = current - b;
                    arr[current] = 3;
                }
                if (current + a < arr.length && arr[current + a] < 2) {
                    arr[current + a] = 2;
                    Qu[r++] = current + a;
                }
            }
            stp++;
        }
        return -1;
    }
}
