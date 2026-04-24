/*
 * Problem: 2158. Amount of New Area Painted Each Day
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/amount-of-new-area-painted-each-day/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] amountPainted(int[][] paint) {
        int max = 0;
        for (int i = 0; i < paint.length; i++) {
            max = Math.max(paint[i][1], max);
        }
        int[] links = new int[max + 1];
        int[] res = new int[paint.length];
        for (int i = 0; i < paint.length; i++) {
            int l = paint[i][0];
            int r = paint[i][1];
            while (l < r) {
                if (links[l] == 0) {
                    links[l] = r;
                    l++;
                    res[i]++;
                } else {
                    if (r > links[l]) {
                        int tmp = links[l];
                        links[l] = r;
                        l = tmp;
                    } else {
                        l = links[l];
                    }
                }
            }
        }
        return res;
    }
}
