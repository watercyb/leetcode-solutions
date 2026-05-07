/*
 * Problem: 3453. Separate Squares I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/separate-squares-i/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public double separateSquares(int[][] squares) {
        long sum = 0;
        long max = 0;
        for (int[] arr : squares) {
            sum += (long) arr[2] * arr[2];
            max = Math.max(arr[1] + arr[2], max);
        }
        long l = 0;
        long r = max;
        long target = sum;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (chk(squares, mid) * 2 >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        long y1 = chk(squares, r);
        long y2 = chk(squares, l);
        return (double) l - (double) (y2 * 2 - target) / 2 / (y2 - y1);
    }

    public long chk(int[][] squares, long mid) {
        long sum = 0;
        for (int[] arr : squares) {
            if (arr[1] >= mid)
                continue;
            sum += Math.min(mid - arr[1], arr[2]) * arr[2];
        }
        return sum;
    }
}
