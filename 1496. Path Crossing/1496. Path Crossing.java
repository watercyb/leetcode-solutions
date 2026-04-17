/*
 * Problem: 1496. Path Crossing
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/path-crossing/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<Integer> HS = new HashSet<>();
        HS.add(0);
        int x = 0;
        int y = 0;
        for (char chr : path.toCharArray()) {
            switch (chr) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }
            int tmp = x * 10001 + y;
            if (HS.contains(tmp))
                return true;
            HS.add(tmp);
        }
        return false;
    }
}
