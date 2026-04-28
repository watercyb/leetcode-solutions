/*
 * Problem: 2594. Minimum Time to Repair Cars
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-repair-cars/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long max = 0;
        int[] counts = new int[101];
        int count = 0;
        for (int rank : ranks) {
            max = Math.max(rank, max);
            if (counts[rank]++ == 0)
                count++;
        }
        int[][] arr = new int[count][];
        int idx = 0;
        for (int i = 100; i >= 0; i--) {
            if (counts[i] > 0) {
                arr[idx++] = new int[] { i, counts[i] };
            }
        }
        long l = 0;
        long r = max * cars * cars;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(arr, cars, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[][] arr, int cars, long mid) {
        long carsL = cars;
        for (int i = 0; i < arr.length && carsL > 0; i++) {
            carsL -= (long) Math.sqrt(mid / arr[i][0]) * arr[i][1];
        }
        return carsL <= 0;
    }
}
