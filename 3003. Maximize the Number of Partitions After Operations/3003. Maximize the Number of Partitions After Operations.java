/*
 * Problem: 3003. Maximize the Number of Partitions After Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        if (k == 26)
            return 1;
        char[] chrs = s.toCharArray();
        int[][] left = new int[chrs.length][3];
        int[][] right = new int[chrs.length][3];

        int num = 0;
        int mask = 0;
        int count = 0;
        for (int i = 0; i < chrs.length - 1; i++) {
            int binary = 1 << (chrs[i] - 'a');
            if ((mask & binary) == 0) {
                count++;
                if (count <= k) {
                    mask |= binary;
                } else {
                    num++;
                    mask = binary;
                    count = 1;
                }
            }
            left[i + 1][0] = num;
            left[i + 1][1] = mask;
            left[i + 1][2] = count;
        }

        num = 0;
        mask = 0;
        count = 0;
        for (int i = chrs.length - 1; i > 0; i--) {
            int binary = 1 << (chrs[i] - 'a');
            if ((mask & binary) == 0) {
                count++;
                if (count <= k) {
                    mask |= binary;
                } else {
                    num++;
                    mask = binary;
                    count = 1;
                }
            }
            right[i - 1][0] = num;
            right[i - 1][1] = mask;
            right[i - 1][2] = count;
        }
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            int sum = left[i][0] + right[i][0] + 1;
            int bitCount = Integer.bitCount(left[i][1] | right[i][1]);
            if (left[i][2] == k && right[i][2] == k && bitCount < 26) {
                sum += 2;
            } else if (bitCount >= k) {
                sum++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
