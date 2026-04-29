/*
 * Problem: 2647. Color the Triangle Red
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/color-the-triangle-red/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[][] colorRed(int n) {
        List<int[]> list = new ArrayList<>();
        int idx = 0;
        for (int i = n; i >= 2; i--) {
            if (idx == 0) {
                for (int j = 1; j < 2 * i; j += 2) {
                    list.add(new int[] { i, j });
                }
            } else if (idx == 1) {
                list.add(new int[] { i, 2 });
            } else if (idx == 2) {
                for (int j = 3; j < 2 * i; j += 2) {
                    list.add(new int[] { i, j });
                }
            } else {
                list.add(new int[] { i, 1 });
            }
            idx = (idx + 1) % 4;
        }
        list.add(new int[] { 1, 1 });
        return list.toArray(new int[list.size()][]);
    }
}
