/*
 * Problem: 3623. Count Number of Trapezoids I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-trapezoids-i/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1_000_000_007;
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int[] point : points) {
            int y = point[1];
            HM.put(y, HM.getOrDefault(y, 0) + 1);
        }
        long res = 0;
        long sum = 0;
        for (int count : HM.values()) {
            long pairs = (long) count * (count - 1) / 2;
            res = (res + sum * pairs) % mod;
            sum = (sum + pairs) % mod;
        }
        return (int) (res % mod);
    }
}
