/*
 * Problem: 1861. Rotating the Box
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotating-the-box/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            int y = box.length - 1 - i;
            int x = box[0].length - 1;
            for (int j = box[0].length - 1; j >= 0; j--) {
                switch (box[i][j]) {
                    case '#':
                        res[x--][y] = '#';
                        break;
                    case '*':
                        while (x > j) {
                            res[x--][y] = '.';
                        }
                        res[x--][y] = '*';
                        break;
                }
            }
            while (x >= 0) {
                res[x--][y] = '.';
            }
        }
        return res;
    }
}
