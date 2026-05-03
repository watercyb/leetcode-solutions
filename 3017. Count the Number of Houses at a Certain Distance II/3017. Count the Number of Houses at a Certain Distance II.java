/*
 * Problem: 3017. Count the Number of Houses at a Certain Distance II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long[] countOfPairs(int n, int x, int y) {
        long[] res = new long[n];
        if (x == y || Math.abs(y - x) == 1) {
            for (int i = 0; i < n - 1; i++) {
                res[i] = (n - i - 1) * 2;
            }
        } else {
            if (x > y) {
                int tmpX = x;
                x = y;
                y = tmpX;
            }
            int tmp = n - y + x + 1;
            for (int i = 0; i < tmp - 1; i++) {
                res[i] = (tmp - i - 1) * 2;
            }
            res[0] -= 2;
            tmp = y - x + 1;
            int a = tmp / 2;
            int b = tmp % 2;
            for (int i = 0; i < a; i++) {
                res[i] += 2 * tmp;
            }
            if (b == 0)
                res[a - 1] -= tmp;

            tmp -= 1;
            for (int i = 1; i <= a + x - 1 - 1; i++) {
                res[i] += ((Math.min(tmp, i * 2) - 1) - (Math.max((i - (x - 1)) * 2 - 1, 0))) * 2;
            }

            x = n - y + 1;
            for (int i = 1; i <= a + x - 1 - 1; i++) {
                res[i] += ((Math.min(tmp, i * 2) - 1) - (Math.max((i - (x - 1)) * 2 - 1, 0))) * 2;
            }
        }
        return res;
    }
}
