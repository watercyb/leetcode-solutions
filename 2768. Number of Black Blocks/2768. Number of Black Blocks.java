/*
 * Problem: 2768. Number of Black Blocks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-black-blocks/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        HashMap<Long, Integer> HM = new HashMap<>(coordinates.length, 0.99f);
        for (int[] coordinate : coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];
            if (x > 0 && y < n - 1) {
                long h = (long) (x - 1) * n + y;
                HM.put(h, HM.getOrDefault(h, 0) + 1);
            }
            if (y > 0 && x < m - 1) {
                long h = (long) x * n + y - 1;
                HM.put(h, HM.getOrDefault(h, 0) + 1);
            }
            if (x > 0 && y > 0) {
                long h = (long) (x - 1) * n + y - 1;
                HM.put(h, HM.getOrDefault(h, 0) + 1);
            }
            if (x < m - 1 && y < n - 1) {
                long h = (long) x * n + y;
                HM.put(h, HM.getOrDefault(h, 0) + 1);
            }
        }
        long[] res = new long[5];
        for (int count : HM.values()) {
            res[count]++;
        }
        res[0] = (long) (m - 1) * (n - 1) - res[1] - res[2] - res[3] - res[4];
        return res;
    }
}
