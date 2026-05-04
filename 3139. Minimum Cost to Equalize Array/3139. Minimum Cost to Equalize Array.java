/*
 * Problem: 3139. Minimum Cost to Equalize Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-equalize-array/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int mod = 1_000_000_007;
        int numMax = 0;
        for (int num : nums) {
            numMax = Math.max(num, numMax);
        }
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += numMax - num;
            max = Math.max(numMax - num, max);
        }
        if (cost1 * 2 <= cost2) {
            return (int) (sum * cost1 % mod);
        } else {
            long res = 0;
            if (sum >= 2 * max - 1) {
                res = sum / 2 * cost2;
                if (sum % 2 == 1)
                    res += cost1;
                if (nums.length > 2) {
                    long res1 = 0;
                    sum += nums.length;
                    res1 = sum / 2 * cost2;
                    if (sum % 2 == 1)
                        res1 += cost1;
                    if (res > res1)
                        res = res1;
                }
                return (int) (res % mod);
            } else {
                res = (sum - max) * cost2 + (2 * max - sum) * cost1;
                if (nums.length > 2) {
                    long res1 = 0;
                    long count = ((2 * max - 1) - sum + nums.length - 3) / (nums.length - 2);
                    sum += count * nums.length;
                    res1 = sum / 2 * cost2;
                    if (sum % 2 == 1)
                        res1 += cost1;
                    if (res > res1)
                        res = res1;
                    sum += nums.length;
                    res1 = sum / 2 * cost2;
                    if (sum % 2 == 1)
                        res1 += cost1;
                    if (res > res1)
                        res = res1;
                }
                return (int) (res % mod);
            }
        }
    }
}
