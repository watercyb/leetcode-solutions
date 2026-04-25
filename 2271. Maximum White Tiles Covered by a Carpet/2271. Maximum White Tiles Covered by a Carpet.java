/*
 * Problem: 2271. Maximum White Tiles Covered by a Carpet
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int j = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < tiles.length; i++) {
            int lim = tiles[i][0] + carpetLen - 1;
            while (j < tiles.length && tiles[j][0] <= lim) {
                sum += tiles[j][1] - tiles[j][0] + 1;
                j++;
            }
            if (lim > tiles[j - 1][1]) {
                res = Math.max(sum, res);
            } else {
                res = Math.max(sum - tiles[j - 1][1] + lim, res);
            }
            sum -= tiles[i][1] - tiles[i][0] + 1;
        }
        return res;
    }
}
