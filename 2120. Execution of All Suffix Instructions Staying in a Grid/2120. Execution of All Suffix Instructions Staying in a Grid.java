/*
 * Problem: 2120. Execution of All Suffix Instructions Staying in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] chrs = s.toCharArray();
        int[] res = new int[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            int x = startPos[0];
            int y = startPos[1];
            int count = 0;
            for (int j = i; j < chrs.length; j++) {
                if (chrs[j] == 'L') {
                    if (y > 0) {
                        y--;
                    } else {
                        break;
                    }
                } else if (chrs[j] == 'R') {
                    if (y < n - 1) {
                        y++;
                    } else {
                        break;
                    }
                } else if (chrs[j] == 'U') {
                    if (x > 0) {
                        x--;
                    } else {
                        break;
                    }
                } else {
                    if (x < n - 1) {
                        x++;
                    } else {
                        break;
                    }
                }
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}
