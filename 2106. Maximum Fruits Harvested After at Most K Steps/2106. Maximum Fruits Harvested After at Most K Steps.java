/*
 * Problem: 2106. Maximum Fruits Harvested After at Most K Steps
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        if (startPos >= fruits[fruits.length - 1][0]) {
            int res = 0;
            int i = fruits.length - 1;
            while (i >= 0 && startPos - fruits[i][0] <= k) {
                res += fruits[i][1];
                i--;
            }
            return res;
        }
        int i = 0;
        while (i < fruits.length && fruits[i][0] <= startPos) {
            i++;
        }
        int l = i - 1;
        int r = i;
        int sum = 0;
        int res = 0;
        while (l >= 0 && startPos - fruits[l][0] <= k) {
            sum += fruits[l][1];
            l--;
        }
        l++;
        while (l <= i) {
            int lim = k - Math.max(2 * (startPos - fruits[l][0]), 0) + startPos;
            while (r < fruits.length && fruits[r][0] <= lim) {
                sum += fruits[r][1];
                r++;
            }
            res = Math.max(sum, res);
            if (r == fruits.length)
                break;
            sum -= fruits[l][1];
            l++;
        }
        if (i > 0 && fruits[i - 1][0] == startPos)
            i--;
        l = i;
        r = i + 1;
        sum = 0;
        while (r < fruits.length && fruits[r][0] - startPos <= k) {
            sum += fruits[r][1];
            r++;
        }
        r--;
        while (r >= i) {
            int lim = startPos - k + Math.max(2 * (fruits[r][0] - startPos), 0);
            while (l >= 0 && fruits[l][0] >= lim) {
                sum += fruits[l][1];
                l--;
            }
            res = Math.max(sum, res);
            if (l < 0)
                break;
            sum -= fruits[r][1];
            r--;
        }
        return res;
    }
}
