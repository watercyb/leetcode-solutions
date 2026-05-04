/*
 * Problem: 3186. Maximum Total Damage With Spell Casting
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-damage-with-spell-casting/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int count = 1;
        for (int i = 1; i < power.length; i++) {
            if (power[i] != power[i - 1])
                count++;
        }
        int[] powers = new int[count];
        long[] sums = new long[count];
        int idx = 0;
        int prv = power[0];
        long sum = power[0];
        for (int i = 1; i < power.length; i++) {
            if (power[i] != prv) {
                powers[idx] = prv;
                sums[idx++] = sum;
                sum = prv = power[i];
            } else {
                sum += prv;
            }
        }
        powers[idx] = prv;
        sums[idx] = sum;
        long[] DP = new long[3];
        for (int i = 0; i < count; i++) {
            long current = Math.max(DP[0] + sums[i], DP[2]);
            if (i > 0 && powers[i] - 2 > powers[i - 1])
                current = Math.max(DP[2] + sums[i], current);
            if (i > 1 && powers[i] - 2 > powers[i - 2])
                current = Math.max(DP[1] + sums[i], current);
            DP[0] = DP[1];
            DP[1] = DP[2];
            DP[2] = current;
        }
        return DP[2];
    }
}
