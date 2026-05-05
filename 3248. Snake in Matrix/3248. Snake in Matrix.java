/*
 * Problem: 3248. Snake in Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/snake-in-matrix/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for (String command : commands) {
            switch (command.charAt(0)) {
                case 'R':
                    y++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'D':
                    x++;
                    break;
                case 'U':
                    x--;
                    break;
            }
        }
        return x * n + y;
    }
}
