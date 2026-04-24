/*
 * Problem: 2141. Maximum Running Time of N Computers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-running-time-of-n-computers/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int battery : batteries) {
            sum += battery;
            if (battery > max)
                max = battery;
            if (battery < min)
                min = battery;
        }
        if (n == batteries.length)
            return min;

        if (sum >= (long) max * n)
            return sum / n;
        Arrays.sort(batteries);
        sum = 0;
        for (int i = 0; i <= batteries.length - n; i++) {
            sum += batteries[i];
        }
        int j = 2;
        long max1 = sum;
        for (int i = batteries.length - n + 1; i < batteries.length; i++) {
            sum += batteries[i];
            if (sum / j <= max1) {
                max1 = sum / j;
            } else {
                return max1;
            }
            j++;
        }
        return max1;
    }

}
