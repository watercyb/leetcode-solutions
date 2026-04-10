/*
 * Problem: 982. Triples with Bitwise AND Equal To Zero
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int countTriplets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int len = 32 - Integer.numberOfLeadingZeros(max);
        max = 1 << len;
        int mask = max - 1;
        int[] counts = new int[max];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
            for (int j = i - 1; j >= 0; j--) {
                counts[nums[i] & nums[j]] += 2;
            }
        }
        int res = 0;
        for (int num : nums) {
            int target = num ^ mask;
            int t = target;
            while (t > 0) {
                res += counts[t];
                t = (t - 1) & target;
            }
            res += counts[0];
        }
        return res;
    }
}
