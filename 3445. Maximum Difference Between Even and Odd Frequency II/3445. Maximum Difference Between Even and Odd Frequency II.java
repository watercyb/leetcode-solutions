/*
 * Problem: 3445. Maximum Difference Between Even and Odd Frequency II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxDifference(String s, int k) {
        char[] chrs = s.toCharArray();
        int res = Integer.MIN_VALUE;
        int[] counts = new int[5];
        int[][] sums = new int[chrs.length + 1][5];
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - '0';
            counts[idx]++;
            for (int j = 0; j < 5; j++) {
                sums[i + 1][j] = sums[i][j];
            }
            sums[i + 1][idx]++;
        }
        for (char i = 0; i < 5; i++) {
            if (counts[i] == 0)
                continue;
            for (char j = 0; j < 5; j++) {
                if (i == j || counts[j] < 2)
                    continue;
                res = Math.max(findMax(sums, i, j, k), res);
            }
        }
        return res;
    }

    public int findMax(int[][] sums, int a, int b, int k) {
        int[][] min = { { Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2 },
                { Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2 } };
        int j = 0;
        int res = Integer.MIN_VALUE;
        for (int i = k; i < sums.length; i++) {
            while (i - j >= k && sums[j][b] < sums[i][b]) {
                int modA = sums[j][a] & 1;
                int modB = sums[j][b] & 1;
                min[modA][modB] = Math.min(sums[j][a] - sums[j][b],
                        min[modA][modB]);
                j++;
            }
            res = Math.max(sums[i][a] - sums[i][b] - min[(sums[i][a] & 1) ^ 1][sums[i][b] & 1], res);
        }
        return res;
    }
}
